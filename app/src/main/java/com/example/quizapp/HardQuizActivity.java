package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class HardQuizActivity extends AppCompatActivity {
    private Button submitButton;
    private int score;
    private RadioGroup numOneRadioGroup;
    private RadioGroup numTwoRadioGroup;
    private RadioGroup numThreeRadioGroup;
    private RadioGroup numFiveRadioGroup;
    private EditText editText;
    private CheckBox DOneCheckBox;
    private CheckBox DTwoCheckBox;
    private CheckBox DThreeCheckBox;
    private CheckBox DFourCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_quiz);
        submitButton=findViewById(R.id.hard_submit_button);
        DOneCheckBox=findViewById(R.id.hard_DOne_checkbox);
        DTwoCheckBox=findViewById(R.id.hard_DTwo_checkbox);
        DThreeCheckBox=findViewById(R.id.hard_DThree_checkbox);
        DFourCheckBox=findViewById(R.id.hard_DFour_checkbox);
        numOneRadioGroup=findViewById(R.id.hard_num_one_radio_group);
        numTwoRadioGroup=findViewById(R.id.hard_num_two_radio_group);
        numThreeRadioGroup=findViewById(R.id.hard_num_three_radio_group);
        numFiveRadioGroup=findViewById(R.id.hard_num_five_radio_group);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;

                if(numOneRadioGroup.getCheckedRadioButtonId() == R.id.hard_AOne)
                {
                    score=score + 1;
                }
                if(numTwoRadioGroup.getCheckedRadioButtonId() == R.id.hard_BThree)
                {
                    score= score + 1;
                }
                if(numThreeRadioGroup.getCheckedRadioButtonId() == R.id.hard_CTwo)
                {
                    score= score + 1;
                }
                if(numFiveRadioGroup.getCheckedRadioButtonId() == R.id.hard_EThree)
                {
                    score= score + 1;
                }

                if(DOneCheckBox.isChecked() && !DTwoCheckBox.isChecked() && !DThreeCheckBox.isChecked() && !DFourCheckBox.isChecked())
                {
                    score= score + 1;
                }

                Intent intent=new Intent(HardQuizActivity.this,ScoreActivity.class);
                intent.putExtra("SCORE",score+"/5");
                startActivity(intent);
            }
        });
    }

}
