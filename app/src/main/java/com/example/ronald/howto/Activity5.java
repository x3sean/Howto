package com.example.ronald.howto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Activity5 extends AppCompatActivity {
    ImageView imageView;
    RadioGroup answerRadioGroup;
    int currentQuestion = 0;
    int i;

    List<QuestionAndAnswer> quiz = new ArrayList<QuestionAndAnswer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        imageView = (ImageView) findViewById(R.id.imageView2);
        answerRadioGroup = (RadioGroup) findViewById(R.id.answers);
        final TextView tv2 = (TextView) findViewById(R.id.textView2);
        final Button button = (Button) findViewById(R.id.buttonNext);

        final int[] imageView = {R.drawable.q4, R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4};   //questions here//
        String[]answer = {"How to learn a magic trick", "How to make a guy that is mad at you like you again through text", "How to play a prank", "How to win a arm wrestling", "How to deal with a sarcastic person"};  //answers here//
        String[]distractor = { "How to keep a rabbit","How to build a house in singapore", "How to cosplay as ironman", "How to make a guy angry at you angry again", "How to act like bella from twilight", "How to devalope common sense", "How to cure a headache without medication", "How to control the urge to masturbate",
                "How to not get nervous", "How to afford expensive stuff(teens)"}; //distractors here//
        final List<String> distractorList = Arrays.asList(distractor);



        final int length = imageView.length;
        for (i = 0; i < length; i++ )
            quiz.add(new QuestionAndAnswer(imageView[i], answer[i], distractorList.subList(i*2,(i+1)*2)));
        //Collections.shuffle(quiz);
        fillInQuestion();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                currentQuestion++;
                if(currentQuestion < length) {

                    fillInQuestion();
                }
                else{
                    Intent intent = new Intent(Activity5.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        // Setup a listener to save chosen answer
        answerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId > -1) {
                    QuestionAndAnswer qna = quiz.get(currentQuestion);
                    qna.selectedAnswer = ((RadioButton) group.findViewById(checkedId)).getText().toString();
                    qna.selectedId = checkedId;
                    if (qna.isCorrect()){
                        tv2.setText("correct");
                    }
                    else{
                        tv2.setText("wrong!");
                    }
                }
            }
        });


    }

    public void fillInQuestion () {
        QuestionAndAnswer qna = quiz.get(currentQuestion);
        imageView.setImageResource(qna.question);



        // Set all of the answers in the RadioButtons
        int count = answerRadioGroup.getChildCount();
        for (int i = 0; i < count; i++)
            ((RadioButton) answerRadioGroup.getChildAt(i)).setText(qna.allAnswers.get(i));

        // Restore selected answer if exists otherwise clear previous question's choice
        if (qna.selectedId > -1)
            answerRadioGroup.check(qna.selectedId);
        else
            answerRadioGroup.clearCheck();
    }
}
