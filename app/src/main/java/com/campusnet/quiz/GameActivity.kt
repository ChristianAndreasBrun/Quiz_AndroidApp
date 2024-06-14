package com.campusnet.quiz

import android.graphics.Color
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    //Variables
    lateinit var totals:TextView
    lateinit var quiz:TextView
    lateinit var answer0:Button
    lateinit var answer1:Button
    lateinit var answer2:Button
    lateinit var answer3:Button
    lateinit var check:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //Llama a los elementos por ID
        totals = findViewById(R.id.totals)
        quiz = findViewById(R.id.questions)
        answer0 = findViewById(R.id.answer1)
        answer1 = findViewById(R.id.answer2)
        answer2 = findViewById(R.id.answer3)
        answer3 = findViewById(R.id.answer4)
        check = findViewById(R.id.play)

        //Inicializacion de Funcciones
        QuizGame.InitGame()
        PrintQuiz()
    }

    //Imprime la actual pregunta y respuestas
    fun PrintQuiz()
    {
        answer0.setBackgroundColor(Color.WHITE)
        answer1.setBackgroundColor(Color.WHITE)
        answer2.setBackgroundColor(Color.WHITE)
        answer3.setBackgroundColor(Color.WHITE)

        var newQuiz:Quiz = QuizGame.GetCurrentQuiz()
        quiz.setText(newQuiz.question)
        answer0.setText(newQuiz.answers[0])
        answer1.setText(newQuiz.answers[1])
        answer2.setText(newQuiz.answers[2])
        answer3.setText(newQuiz.answers[3])
        totals.setText(QuizGame.score.toString()+"/"+QuizGame.total.toString())
    }

    public fun SelectAnswer(view: View)
    {
        answer0.setBackgroundColor(Color.WHITE)
        answer1.setBackgroundColor(Color.WHITE)
        answer2.setBackgroundColor(Color.WHITE)
        answer3.setBackgroundColor(Color.WHITE)

        var button: Button = view as Button
        button.setBackgroundColor(resources.getColor(R.color.blue))
        QuizGame.answer = button.text.toString()
    }

    public fun ChekAnswer(view: View)
    {
        if (QuizGame.answer == "") return

        var finished: Boolean = QuizGame.CheckAnswer()
        if (finished == false) PrintQuiz()
        else
        {
            val intent = Intent(this, FinishActivity::class.java)
            startActivity(intent)
        }
    }
}