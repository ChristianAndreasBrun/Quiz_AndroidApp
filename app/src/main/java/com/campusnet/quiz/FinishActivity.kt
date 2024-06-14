package com.campusnet.quiz

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        //Variables
        val winGame = QuizGame.winGame

        //Texto que indica si se ha perdido o ganado
        val textResult = findViewById<TextView>(R.id.resultText)
        if (winGame)
        {
            textResult.text = "¡HAS GANADO!"
            textResult.setTextColor(resources.getColor(R.color.green))
        }
        else
        {
            textResult.text = "¡HAS PERDIDO!"
            textResult.setTextColor(resources.getColor(R.color.red))
        }

        //Boton para volver al menu principal
        val returnMain = findViewById<Button>(R.id.return_button)
        returnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}