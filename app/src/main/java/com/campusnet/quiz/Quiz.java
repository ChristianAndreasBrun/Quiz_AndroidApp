package com.campusnet.quiz;

public class Quiz {
    public String question;
    public String[] answers;
    public String correct;

    public Quiz(String question, String[] answers, String correct) {
        this.question = question;
        this.answers = answers;
        this.correct = correct;
    }

}
