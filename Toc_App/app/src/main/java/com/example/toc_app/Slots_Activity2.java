package com.example.toc_app;

import static android.text.format.DateFormat.format;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Slots_Activity2 extends AppCompatActivity {
    EditText Id;
    EditText name;
    Button confirm;
    Timer counter;
    String mText;
    String mText2;
    private static final int WRITE_EXTERNAL_STORAGE_CODE = 1;

    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots2);
        Id = findViewById(R.id.tv_ID);
        name = findViewById(R.id.tv_name);
        confirm = findViewById(R.id.confirm_button);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText = name.getText().toString().trim();
                mText2 = Id.getText().toString().trim();
                if (mText.isEmpty()) {
                    Toast.makeText(Slots_Activity2.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else  if (mText2.isEmpty()){
                    Toast.makeText(Slots_Activity2.this, "Please enter your Id#", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Slots_Activity2.this, "Processing your Request, Please wait ....", Toast.LENGTH_SHORT).show();
                    openDialog();
                    counter = new Timer();
                    counter.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Slots_Activity2.this,MainActivity2.class);
                            startActivity(intent);
                            finish();
                        }
                    },10000);

                    Toast.makeText(Slots_Activity2.this, "ASSIGNMENT SUBMITTED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                }
            }
         });
      }

    private void openDialog() {
        OpenDialogBox dialogBox = new OpenDialogBox();
        dialogBox.show(getSupportFragmentManager(),"Submission");
    }
}