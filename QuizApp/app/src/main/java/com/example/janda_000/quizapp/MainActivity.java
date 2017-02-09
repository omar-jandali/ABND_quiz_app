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

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkResults(View view){
        EditText submitName  = (EditText) findViewById(R.id.user_name_view);
        Editable userName = submitName.getText();

        RadioButton patriots = (RadioButton) findViewById(R.id.patriots);
        RadioButton brady = (RadioButton) findViewById(R.id.tom_brady);
        RadioButton ryan = (RadioButton) findViewById(R.id.matt_ryan);
        RadioButton houston = (RadioButton) findViewById(R.id.houston);

        if (patriots.isChecked()){
            score = score + 1;
        }
        if (brady.isChecked()){
            score = score + 1;
        }
        if (ryan.isChecked()){
            score = score + 1;
        }
        if (houston.isChecked()){
            score = score + 1;
        }

        CheckBox edelmanChecked = (CheckBox) findViewById(R.id.julian_edelman);
        CheckBox whiteChecked = (CheckBox) findViewById(R.id.james_white);
        boolean edelman = edelmanChecked.isChecked();
        boolean white = whiteChecked.isChecked();

        if (edelman){
            score = score + 1;
        }
        if (white){
            score = score + 1;
        }

        String message = calculateScore(score, userName);

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        clearChecked(view, edelmanChecked, whiteChecked, submitName);

    }

    private String calculateScore(int score, Editable userName){
        String message = "Hello " + userName + " - Your score is " + score + " out of 6";
        return message;
    }

    public void clearChecked(View view, CheckBox edelman, CheckBox white, EditText name){
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

        score = 0;
    }

}
