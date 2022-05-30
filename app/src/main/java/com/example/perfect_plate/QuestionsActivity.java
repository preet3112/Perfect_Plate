package com.example.perfect_plate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {
        TextView tv;
        Button submitbutton, quitbutton;
        RadioGroup radio_g;
        RadioButton rb1,rb2,rb3,rb4;

        String questions[] = {
                "Which type of beans are used to make baked beans?",
                "What does IPA stand for?",
                "Which of these chocolate bars does not contain nuts in its ingredient list?",
                "Gruyère is a cheese from which country?",
                "What is a hop?",
        };
        String answers[] = {"Haricot beans","India pale ale","Double Decker","Switzerland","A climbing plant, the flowers of which are used in beer"};
        String opt[] = {
                "Borlotti beans","Haricot beans","Cannellini beans","Flageolet beans",
                "Intensely potent ale","International porter association","India premium ale","India pale ale",
                "Double Decker","Snickers","Picnic","Toblerone",
                "France","Switzerland","Austria","Germany",
                "A climbing plant, the flowers of which are used in beer","A climbing plant, the roots of which are used in beer","A climbing plant, the leaves of which are used in beer","A grain crop used in beer"
        };
        int flag=0;
        public static int marks=0,correct=0,wrong=0;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_questions);

            final TextView score = (TextView)findViewById(R.id.textView4);
            Intent intent = getIntent();

            submitbutton=(Button)findViewById(R.id.button3);
            quitbutton=(Button)findViewById(R.id.buttonquit);
            tv=(TextView) findViewById(R.id.tvque);

            radio_g=(RadioGroup)findViewById(R.id.answersgrp);
            rb1=(RadioButton)findViewById(R.id.radioButton);
            rb2=(RadioButton)findViewById(R.id.radioButton2);
            rb3=(RadioButton)findViewById(R.id.radioButton3);
            rb4=(RadioButton)findViewById(R.id.radioButton4);
            tv.setText(questions[flag]);
            rb1.setText(opt[0]);
            rb2.setText(opt[1]);
            rb3.setText(opt[2]);
            rb4.setText(opt[3]);
            submitbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //int color = mBackgroundColor.getColor();
                    //mLayout.setBackgroundColor(color);

                    if(radio_g.getCheckedRadioButtonId()==-1)
                    {
                        Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                    String ansText = uans.getText().toString();
//                  Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                    if(ansText.equals(answers[flag])) {
                        correct++;
                        //Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        wrong++;
                        //Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                    }

                    flag++;

                    if (score != null)
                        score.setText(""+correct);

                    if(flag<questions.length)
                    {
                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag*4]);
                        rb2.setText(opt[flag*4 +1]);
                        rb3.setText(opt[flag*4 +2]);
                        rb4.setText(opt[flag*4 +3]);
                    }
                    else
                    {
                        marks=correct;
                        Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();
                }
            });

            quitbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(intent);
                }
            });
        }

    }