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

public class Activity4 extends AppCompatActivity {
    ImageView imageView;
    RadioGroup answerRadioGroup;
    int currentQuestion = 0;
    int i;
    List<QuestionAndAnswer> quiz = new ArrayList<QuestionAndAnswer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        imageView = (ImageView) findViewById(R.id.imageView2);
        answerRadioGroup = (RadioGroup) findViewById(R.id.answers);
        final TextView tv2 = (TextView) findViewById(R.id.textView2);
        final Button button = (Button) findViewById(R.id.buttonNext);

        final int[] imageView = {R.drawable.q3, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4};   //questions here//
        String[]answer = {"How to learn a magic trick", "How to survive a freestyle rap battle", "How to know when you'll get your first period", "How to enhance your sarcasm skills", "How to get your nipple pierced" };  //answers here//
        String[]distractor = { "How to keep a rabbit","How to build a house in singapore","How to aces in your cca", "How to win a girl by playing a song", "How to take drugs", "How to multitask", "How to be a bad guy", "How to piss people off",
                "How to check expire date", "How to keep a stright face"}; //distractors here//
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
                    Intent intent = new Intent(Activity4.this, MainActivity.class);
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

