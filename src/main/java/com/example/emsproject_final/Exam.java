package com.example.emsproject_final;

public class Exam
{
    public String question;
    public String[] answers;
    public String correctAnswer;

    public Exam(String question, String[] answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
}
