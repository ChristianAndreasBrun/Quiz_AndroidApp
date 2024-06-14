package com.campusnet.quiz;

import android.os.Debug;
import android.content.Context;
import android.content.Intent;
import java.util.Random;

public class QuizGame {

    //Las preguntas del juego
    static public Quiz[] quiz =
    {
            new Quiz("De que compaña es Android?",
                    new String[]{"Apple", "Nokia", "Google", "Samsung"},
                    "Google"),
            new Quiz("Que marca de coche es Española?",
                    new String[]{"BMW", "Seat", "Toyota", "Renault"},
                    "Seat"),
            new Quiz("Cual es el intrumento musical tipico en Hawaii?",
                    new String[]{"Guittara", "Violin", "Flauta", "Ukelele"},
                    "Ukelele"),
            new Quiz("Que genero musical se escucha en el festival TomorrowLand?",
                    new String[]{"Reggaeton", "Rock", "EDM", "Orquestra"},
                    "EDM"),
            new Quiz("Cuál es la capital de Francia?",
                    new String[]{"Londres", "París", "Berlín", "Madrid"},
                    "París"),
            new Quiz("Cuál es el componente principal del aire que respiramos?",
                    new String[]{"Dióxido de carbono", "Nitrógeno", "Oxígeno", "Argón"},
                    "Nitrógeno"),
            new Quiz("Cuál es la montaña más alta del mundo?",
                    new String[]{"Mont Blanc", "K2", "Monte Everest", "Kilimanjaro"},
                    "Monte Everest"),
            new Quiz("En qué año comenzó la Segunda Guerra Mundial?",
                    new String[]{"1935", "1940", "1939", "1945"},
                    "1939"),
            new Quiz("Cuál es el río más largo del mundo?",
                    new String[]{"Amazonas", "Nilo", "Yangtsé", "Misisipi"},
                    "Amazonas"),
            new Quiz("Cuál es el planeta más grande del sistema solar?",
                    new String[]{"Venus", "Júpiter", "Saturno", "Neptuno"},
                    "Júpiter"),
            new Quiz("Quién escribió \"Romeo y Julieta\"?",
                    new String[]{"Charles Dickens", "William Shakespeare", "Jane Austen", "Fyodor Dostoevsky"},
                    "William Shakespeare"),
            new Quiz("Cuál es el elemento más abundante en la corteza terrestre?",
                    new String[]{"Hierro", "Oxígeno", "Silicio", "Aluminio"},
                    "Oxígeno"),
            new Quiz("En qué año se fundó la Organización de las Naciones Unidas (ONU)?",
                    new String[]{"1945", "1950", "1939", "1960"},
                    "1945"),
            new Quiz("Cuál es el animal terrestre más grande?",
                    new String[]{"Elefante africano", "Ballena azul", "Jirafa", "Rinoceronte blanco"},
                    "Ballena azul"),
    };

    //Variables
    static public int score, total, current;
    static public String answer;
    static public boolean winGame;

    //Variable para desordenar
    static public int[] shuffle;

    static public void InitGame() {
        //Inicializa las variables
        score = 0;
        current = 0;
        answer = "";
        total = quiz.length;
        //Desordena las preguntas
        shuffle = new int[total];
        for (int i = 0; i < total; i++) shuffle[i] = i;

        for (int i = 0; i < total; i++)
        {
            int temp = shuffle[i];
            Random random = new Random();
            int randomNum = random.nextInt(total);
            shuffle[i] = shuffle[randomNum];
            shuffle[randomNum] = temp;
        }
    }

    //Resultado de la pregunta actual
    static public Quiz GetCurrentQuiz() {
        return quiz[shuffle[current]];
    }

    //Verifica si la pregunta es correcta o incorrecta
    static public boolean CheckAnswer() {
        if (answer == quiz[shuffle[current]].correct) score++;
        current++;
        answer = "";

        if (current >= total)
        {
            winGame = (score >= total /2);
            return true;
        }
        else return false;
    }
}
