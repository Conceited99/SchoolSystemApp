package com.example.toc_app;

import static android.text.format.DateFormat.format;
import static java.text.DateFormat.*;

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
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class Slots_Activity extends AppCompatActivity {
    TextView tvDate;
    TextView tvTimr1;
    TextView timer;
    TextView timer2;
    EditText name;
    Button confirm;
    int t1Hour,t1Minute,t2Hour,t2Minute;
    String mText;
    String mText2;
    String mText3;
    Timer counter;

    boolean DateTaken = false;

    private static final int WRITE_EXTERNAL_STORAGE_CODE = 1;

    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);
        tvDate = findViewById(R.id.tv_date);
        timer = findViewById(R.id.timer);
        timer2 = findViewById(R.id.timer2);
        name = findViewById(R.id.tv_name);
        confirm = findViewById(R.id.confirm_button);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(calendar.YEAR);
        final int month= calendar.get(calendar.MONTH);
        final int day = calendar.get(calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Slots_Activity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day +"/"+month+"/"+year;
                timer.setText(date);
            }
        };

        tvTimr1 = findViewById(R.id.tv_timer);
        tvTimr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Slots_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        t1Hour = hourOfDay;
                        t1Minute = minute;
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.set(0,0,0,t1Hour,t1Minute);
                        timer2.setText(format ("hh:mm aa",calendar1));
                    }
                },12,0,false);
               timePickerDialog.updateTime(t1Hour,t1Minute);
               timePickerDialog.show();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mText = name.getText().toString().trim();
                mText2 = timer.getText().toString().trim();
                mText3 = timer2.getText().toString().trim();

                String DatenTime = mText2+mText3;

                if(mText.isEmpty())
                {
                    Toast.makeText(Slots_Activity.this,"Please Enter your name and ID# ...  ",Toast.LENGTH_SHORT).show();
                }
                else if (mText2.isEmpty())
                {
                    Toast.makeText(Slots_Activity.this,"Please Enter Preferred Date ....   ",Toast.LENGTH_SHORT).show();
                }
                else if(mText3.isEmpty())
                {
                    Toast.makeText(Slots_Activity.this,"Please Enter Preferred Time ....   ",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(!DatenTime.toString().isEmpty())
                    {
                        File file = new File(Slots_Activity.this.getFilesDir(),"Data");
                        if (!file.exists())
                        {
                            file.mkdir();
                        }else{
                            try {
                                File gpfile = new File(file,"UserData");
                                FileWriter writer = new FileWriter(gpfile, true);
                                File fileEvents = new File(Slots_Activity.this.getFilesDir()+"/Data/UserData");
                                try {
                                    BufferedReader br = new BufferedReader(new FileReader(fileEvents));
                                    String line;
                                    if(gpfile.length()==0)
                                    {
                                        writer.append(DatenTime);
                                        writer.append("\n");
                                        writer.flush();
                                        writer.close();
                                        goToHomeScreen();
                                    }else {
                                        while ((line = br.readLine()) != null) {
                                            if(line.equals(DatenTime))
                                            {
                                                DateTaken = true;
                                            }
                                        }
                                        if(DateTaken)
                                        {
                                            Toast.makeText(Slots_Activity.this, "Date and Time Already booked ...Please RESELECT", Toast.LENGTH_LONG).show();
                                            br.close();
                                        }else if (!DateTaken)
                                        {
                                            writer.append(DatenTime);
                                            writer.append("\n");
                                            writer.flush();
                                            writer.close();
                                            br.close();
                                            goToHomeScreen();
                                        }
                                        DateTaken = false;
                                    }
                                } catch (IOException e) { }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }


    private void goToHomeScreen() {
            Toast.makeText(Slots_Activity.this, "Processing your Request, Please wait ....", Toast.LENGTH_SHORT).show();
            counter = new Timer();
            counter.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(Slots_Activity.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
            },5000);
        Toast.makeText(Slots_Activity.this, "MEETING SCHEDULED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
    }
}