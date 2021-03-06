package com.example.androidclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sufyan on 3/4/2016.
 */
public class Scoreupdate extends Activity{
    EditText Batting_team,Score, Wickets,Toss,id_num,Total_overs,type;
    String name,team_score,team_wickets,Get_overs,Match_id,Totalovers,U_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreupdate);
        id_num = (EditText)findViewById(R.id.id);
        Batting_team = (EditText)findViewById(R.id.name);
        Score = (EditText)findViewById(R.id.new_user_name);
        Wickets = (EditText)findViewById(R.id.new_user_pass);
        Toss = (EditText)findViewById(R.id.toss_text);
        Total_overs = (EditText)findViewById(R.id.t);
        type = (EditText)findViewById(R.id.type);
    }
    public void userReg(View view)
    {
        Match_id = id_num.getText().toString();
        name = Batting_team.getText().toString();
        team_score =  Score.getText().toString();
        team_wickets =  Wickets.getText().toString();
        Get_overs = Toss.getText().toString();
        Totalovers =  Total_overs.getText().toString();
        U_type= type.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,Match_id,name,team_score,team_wickets,Get_overs,Totalovers,U_type);
    }
}
