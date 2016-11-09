package com.example.ronald.howto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


import static com.example.ronald.howto.R.id.imageButtonq1;
import static com.example.ronald.howto.R.id.imageButtonq2;
import static com.example.ronald.howto.R.id.imageButtonq3;
import static com.example.ronald.howto.R.id.imageButtonq4;
// import static com.example.ronald.howto.R.id.imageViewhowtosg;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton Button2 = (ImageButton) findViewById(imageButtonq1);
        ImageButton Button3 = (ImageButton) findViewById(imageButtonq2);
        ImageButton Button4 = (ImageButton) findViewById(imageButtonq3);
        ImageButton Button5 = (ImageButton) findViewById(imageButtonq4);



        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);

            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity3.class);
                startActivity(intent);

            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity4.class);
                startActivity(intent);

            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity5.class);
                startActivity(intent);
            }
        });
    }
}
