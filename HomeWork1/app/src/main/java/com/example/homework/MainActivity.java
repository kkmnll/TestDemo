package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private EditText et_Name;
    private TextView tv_show;
    private Button btn_show2;
    private Button btn_show1;
    private ProgressBar pb;

    int counter = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Name =findViewById(R.id.et_Name);
        tv_show = findViewById(R.id.tv_show);
        btn_show2= findViewById(R.id.btn_show2);
        btn_show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_show.setText((et_Name.getText().toString()));
            }
        });

        tv_show=findViewById(R.id.tv_show);
        btn_show1=findViewById(R.id.btn_show1);
        btn_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_show.setText("按钮测试");
                tv_show.setTextSize(30);
            }
        });

        prog();
    }

    public void prog() {
        pb = findViewById(R.id.pb);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);
                if (counter == 100) {
                    t.cancel();
                }
            }
        };
        t.schedule(tt, 0,100);
    }
}
