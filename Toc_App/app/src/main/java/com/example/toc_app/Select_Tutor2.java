package com.example.toc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Select_Tutor2 extends AppCompatActivity {

    Timer counter;
    ImageButton image;
    ImageButton image2;
    ImageButton image3;
    ImageButton image4;
    ImageButton image5;
    ImageButton image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tutor2);
        image = findViewById(R.id.layoutmrWhite);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Select_Tutor2.this, "Please wait, Connecting to Lecturer ....", Toast.LENGTH_SHORT).show();
                counter = new Timer();
                counter.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Select_Tutor2.this,MainActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                },5000);
            }
        });
        image2 =  findViewById(R.id.layoutmrClarke);

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Select_Tutor2.this, "Please wait, Connecting to Lecturer ....", Toast.LENGTH_SHORT).show();
                counter = new Timer();
                counter.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Select_Tutor2.this,MainActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                },5000);
            }
        });
        image3 = findViewById(R.id.layoutMuir);

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Select_Tutor2.this, "Please wait, Connecting to Lecturer ....", Toast.LENGTH_SHORT).show();
                counter = new Timer();
                counter.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Select_Tutor2.this,MainActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                },5000);
            }
        });
        image4 =  findViewById(R.id.layoutPanther);

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Select_Tutor2.this, "Please wait, Connecting to Lecturer ....", Toast.LENGTH_SHORT).show();
                counter = new Timer();
                counter.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Select_Tutor2.this,MainActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                },5000);
            }
        });
        image5 =  findViewById(R.id.layoutIan);

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Select_Tutor2.this, "Please wait, Connecting to Lecturer ....", Toast.LENGTH_SHORT).show();
                counter = new Timer();
                counter.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Select_Tutor2.this,MainActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                },5000);
            }
        });
        image6 = findViewById(R.id.layoutShaw);

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Select_Tutor2.this, "Please wait, Connecting to Lecturer ....", Toast.LENGTH_SHORT).show();
                counter = new Timer();
                counter.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Select_Tutor2.this,MainActivity2.class);
                        startActivity(intent);
                        finish();
                    }
                },5000);
            }
        });
    }
}