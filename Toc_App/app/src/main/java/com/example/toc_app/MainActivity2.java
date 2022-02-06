package com.example.toc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageButton image;
    ImageButton image2;
    ImageButton image3;
    ImageButton image4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        image = findViewById(R.id.layoutAppointment);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,Select_Tutor.class);
                startActivity(intent);
            }
        });
        image2 = findViewById(R.id.layoutGoal);

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,Select_Tutor2.class);
                startActivity(intent);
            }
        });
        image3 = findViewById(R.id.layoutSubmit);

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,Select_Tutor3.class);
                startActivity(intent);
            }
        });
        image4 =  findViewById(R.id.layoutExit);

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        TextView email = (TextView) findViewById(R.id.Email);
        email.setText(Html.fromHtml("<a href =\"mailto:tier1support@utech.edu.jm\">Email : tier1support@utech.edu.jm</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());
    }
}