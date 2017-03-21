package com.example.sungin.lab3_3;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Chronometer c1;
    Button b1,b2;
    Switch s1;
    DatePicker dp;
    TimePicker tp;
    FrameLayout f1;
    GridLayout g1,g2;
    EditText timer;
    EditText e1,e2,e3;
    TextView t1,t2,t3,t4,t5;
    int page_count = 0;
    int year;
    int month;
    int day;
    int hour;
    int min;
    String adult;
    String adolescent;
    String child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        g1 = (GridLayout)findViewById(R.id.grid1);
        g2 = (GridLayout)findViewById(R.id.grid2);
        f1 = (FrameLayout)findViewById(R.id.frame1);
        s1 = (Switch)findViewById(R.id.switch1);
        b2 = (Button)findViewById(R.id.button2);
        b1 = (Button)findViewById(R.id.button3);
        dp = (DatePicker)findViewById(R.id.datePicker2);
        tp = (TimePicker)findViewById(R.id.timePicker5);
        e1 =(EditText)findViewById(R.id.editText7);
        e2=(EditText)findViewById(R.id.editText6);
        e3 =(EditText)findViewById(R.id.editText5);
        t1 =(TextView)findViewById(R.id.textView11);
        t2 =(TextView)findViewById(R.id.textView12);
        t3 =(TextView)findViewById(R.id.textView13);
        t4 =(TextView)findViewById(R.id.textView14);
        t5 =(TextView)findViewById(R.id.textView15);
        c1 = (Chronometer)findViewById(R.id.chronometer3);
                s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked == true){
                f1.setVisibility(View.VISIBLE);
                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                dp.setVisibility(View.VISIBLE);
                b1.setEnabled(false);}
                c1.start();

                if(isChecked ==false)
                {
                    f1.setVisibility(View.INVISIBLE);
                    b1.setVisibility(View.INVISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                    dp.setVisibility(View.INVISIBLE);
                    g1.setVisibility(View.INVISIBLE);
                    g2.setVisibility(View.INVISIBLE);
                    year =0;
                    month =0;
                    day =0;
                    hour =0;
                    min =0;
                    c1.stop();
                    c1.setBase(SystemClock.elapsedRealtime());

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page_count++;
                if(page_count == 1) {
                    b1.setEnabled(true);
                    dp.setVisibility(View.INVISIBLE);
                    tp.setVisibility(View.VISIBLE);
                    year = dp.getYear();
                    month = dp.getMonth();
                    day = dp.getDayOfMonth();
                }
                if(page_count == 2){
                    g1.setVisibility(View.VISIBLE);
                    tp.setVisibility(View.INVISIBLE);
                     hour = tp.getHour();
                     min = tp.getMinute();
                }
                if(page_count==3){
                    adult = e3.getText().toString();
                    adolescent = e2.getText().toString();
                    child = e1.getText().toString();
                    int adult_int = Integer.parseInt(adult);
                    int adolescent_int = Integer.parseInt(adolescent);
                    int child_int =Integer.parseInt(child);

                    g1.setVisibility(View.INVISIBLE);
                    g2.setVisibility(View.VISIBLE);
                    b2.setEnabled(false);

                    t1.setText(""+year+"년 "+month+"월 "+day+"일");
                    t2.setText(""+hour+"시 "+min+"분");
                    t5.setText(""+adult_int+"명");
                    t4.setText(""+adolescent_int+"명");
                    t3.setText(""+child_int+"명");
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page_count--;
                if(page_count == 0) {
                    b1.setEnabled(false);
                    dp.setVisibility(View.VISIBLE);
                    tp.setVisibility(View.INVISIBLE);

                }
                if(page_count == 1){
                    g1.setVisibility(View.INVISIBLE);
                    tp.setVisibility(View.VISIBLE);
                }
                if(page_count==2){
                    g1.setVisibility(View.VISIBLE);
                    g2.setVisibility(View.INVISIBLE);
                    b2.setEnabled(true);

                }
            }
        });

    }
}
