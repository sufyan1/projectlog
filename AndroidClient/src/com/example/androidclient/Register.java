package com.example.androidclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sufyan on 1/22/2016.
 */
public class Register  extends Activity {
    EditText Batting_team,Score, Wickets,Toss;
    String name,team_score,team_wickets,Get_overs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        Batting_team = (EditText)findViewById(R.id.name);
        Score = (EditText)findViewById(R.id.new_user_name);
        Wickets = (EditText)findViewById(R.id.new_user_pass);
        Toss = (EditText)findViewById(R.id.toss_text);
    }



    public void userReg(View view)
    {
        name = Batting_team.getText().toString();
        team_score =  Score.getText().toString();
        team_wickets =  Wickets.getText().toString();
        Get_overs = Toss.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,team_score,team_wickets,Get_overs);
    }



}
