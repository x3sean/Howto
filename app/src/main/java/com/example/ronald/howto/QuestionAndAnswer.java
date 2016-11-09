package com.example.ronald.howto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuestionAndAnswer {

    public List<String> allAnswers; // distractors plus real answer
    public String answer;
    public int question;
    public String selectedAnswer;
    public int selectedId = -1;

    public QuestionAndAnswer(int question, String answer, List<String> distractors) {
        this.question = question;
        this.answer = answer;
        allAnswers = new ArrayList<String>(distractors);

        // Add real answer to false answers and shuffle them around
        allAnswers.add(answer);
        Collections.shuffle(allAnswers);
    }

    public boolean isCorrect() {
        return answer.equals(selectedAnswer);
    }
}
