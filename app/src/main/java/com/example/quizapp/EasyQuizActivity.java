package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class EasyQuizActivity extends AppCompatActivity {

    private Button submitButton;
    private int score;
    private RadioGroup numOneRadioGroup;
    private RadioGroup numTwoRadioGroup;
    private RadioGroup numFiveRadioGroup;
    private EditText editText;
    private CheckBox DOneCheckBox;
    private CheckBox DTwoCheckBox;
    private CheckBox DThreeCheckBox;
    private CheckBox DFourCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        submitButton=findViewById(R.id.submit_button);
        editText=findViewById(R.id.edit_text);
        DOneCheckBox=findViewById(R.id.DOne_checkbox);
        DTwoCheckBox=findViewById(R.id.DTwo_checkbox);
        DThreeCheckBox=findViewById(R.id.DThree_checkbox);
        DFourCheckBox=findViewById(R.id.DFour_checkbox);
        numOneRadioGroup=findViewById(R.id.num_one_radio_group);
        numTwoRadioGroup=findViewById(R.id.num_two_radio_group);
        numFiveRadioGroup=findViewById(R.id.num_five_radio_group);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score=0;

                if(numOneRadioGroup.getCheckedRadioButtonId() == R.id.AThree)
                {
                    score=score + 1;
                }
                if(numTwoRadioGroup.getCheckedRadioButtonId() == R.id.BFour)
                {
                    score= score + 1;
                }
                if(numFiveRadioGroup.getCheckedRadioButtonId() == R.id.EFour)
                {
                    score= score + 1;
                }

                String userAnswer=editText.getText().toString();
                if(userAnswer.equalsIgnoreCase("4")){
                    score= score + 1;
                }

                if(DThreeCheckBox.isChecked() && !DOneCheckBox.isChecked() && !DTwoCheckBox.isChecked() && !DFourCheckBox.isChecked())
                {
                    score= score + 1;
                }

                Intent intent=new Intent(EasyQuizActivity.this,ScoreActivity.class);
                intent.putExtra("SCORE",score+"/5");
                startActivity(intent);
            }
        });
    }

}
