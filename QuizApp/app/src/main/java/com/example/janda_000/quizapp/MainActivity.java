package com.example.janda_000.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkResults(View view){
        int score = 0;

        EditText submitName  = (EditText) findViewById(R.id.user_name_view);
        Editable userName = submitName.getText();

        RadioButton patriots = (RadioButton) findViewById(R.id.patriots);
        RadioButton brady = (RadioButton) findViewById(R.id.tom_brady);
        RadioButton ryan = (RadioButton) findViewById(R.id.matt_ryan);
        RadioButton houston = (RadioButton) findViewById(R.id.houston);

        if (patriots.isChecked()){
            score ++;
        }
        if (brady.isChecked()){
            score ++;
        }
        if (ryan.isChecked()){
            score ++;
        }
        if (houston.isChecked()){
            score ++;
        }

        EditText patriotsScore = (EditText) findViewById(R.id.patriots_score);
        EditText falconsScore = (EditText) findViewById(R.id.falcons_score);
        String patriotsFinal = patriotsScore.getText().toString();
        String falconsFinal = falconsScore.getText().toString();

        try{
            int patsFinalScore = Integer.parseInt(patriotsFinal);
            int falcFinalScore = Integer.parseInt(falconsFinal);

            if (patsFinalScore == 31){
                if (falcFinalScore == 28){
                    score ++;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        CheckBox edelmanChecked = (CheckBox) findViewById(R.id.julian_edelman);
        CheckBox whiteChecked = (CheckBox) findViewById(R.id.james_white);
        CheckBox chrisHogan = (CheckBox) findViewById(R.id.chris_hogan);
        boolean edelman = edelmanChecked.isChecked();
        boolean white = whiteChecked.isChecked();
        boolean hogan = chrisHogan.isChecked();

        if (edelman){
            if (white){
                if (!hogan){
                    score ++;
                }
            }
        }


        String message = calculateScore(score, userName);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        clearChecked(view, edelmanChecked, whiteChecked, submitName, patriotsScore, falconsScore);

    }

    public void clearChecked(View view, CheckBox edelman,
                             CheckBox white, EditText name,
                             EditText patsScore, EditText falcScore){
        RadioGroup winningTeam = (RadioGroup) findViewById(R.id.winning_team_answers);
        RadioGroup patriotsQuarterback = (RadioGroup) findViewById(R.id.patriots_quarterback_answer);
        RadioGroup falconsQuarterback = (RadioGroup) findViewById(R.id.falcons_quarterback_answer);
        RadioGroup superbowlHost = (RadioGroup) findViewById(R.id.superbowl_host_answer);

        winningTeam.clearCheck();
        patriotsQuarterback.clearCheck();
        falconsQuarterback.clearCheck();
        superbowlHost.clearCheck();

        if (edelman.isChecked()){
            edelman.setChecked(false);
        }
        if (white.isChecked()){
            white.setChecked(false);
        }

        name.setText("", TextView.BufferType.EDITABLE);
        patsScore.setText("", TextView.BufferType.EDITABLE);
        falcScore.setText("", TextView.BufferType.EDITABLE);
    }

    private String calculateScore(int score, Editable userName){
        if (score < 3){
            String message = "Sorry" + userName + " you only got " + score + " out of 6";
            return message;
        } else {
            String message = "Congrats! " + userName + " you got " + score + " out of 6";
            return message;
        }
    }
}
