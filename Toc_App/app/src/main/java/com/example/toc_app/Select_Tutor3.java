package com.example.toc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Select_Tutor3 extends AppCompatActivity {
    ImageButton image;
    ImageButton image2;
    ImageButton image3;
    ImageButton image4;
    ImageButton image5;
    ImageButton image6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tutor3);
        image = findViewById(R.id.layoutmrWhite);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select_Tutor3.this,Slots_Activity2.class);
                startActivity(intent);
            }
        });
        image2 =findViewById(R.id.layoutmrClarke);

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select_Tutor3.this,Slots_Activity2.class);
                startActivity(intent);
            }
        });
        image3 = findViewById(R.id.layoutMuir);

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select_Tutor3.this,Slots_Activity2.class);
                startActivity(intent);
            }
        });
        image4 =findViewById(R.id.layoutPanther);

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select_Tutor3.this,Slots_Activity2.class);
                startActivity(intent);
            }
        });
        image5 =  findViewById(R.id.layoutIan);

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select_Tutor3.this,Slots_Activity2.class);
                startActivity(intent);
            }
        });
        image6 =findViewById(R.id.layoutShaw);

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select_Tutor3.this,Slots_Activity2.class);
                startActivity(intent);
            }
        });

    }
}