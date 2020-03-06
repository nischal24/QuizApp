package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button quizButton;
    public CheckBox easy,hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quizButton=findViewById(R.id.start_button);
        easy=findViewById(R.id.easy);
        hard=findViewById(R.id.hard);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(easy.isChecked() && !hard.isChecked())
                {
                    Intent intent=new Intent(MainActivity.this, EasyQuizActivity.class);
                    startActivity(intent);
                }
                else if(hard.isChecked() && !easy.isChecked())
                {
                    Intent intent=new Intent(MainActivity.this, HardQuizActivity.class);
                    startActivity(intent);
                }
                else if(hard.isChecked() && easy.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Both Quiz Mode Cannot Be Selected", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Select Quiz Mode", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
