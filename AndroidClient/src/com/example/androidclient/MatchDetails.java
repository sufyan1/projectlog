package com.example.androidclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sufyan on 2/19/2016.
 */
public class MatchDetails  extends Activity {
    EditText team1,team2,Match_number,Toss,bat_first,bowl_first;
    String t1,t2, M_number,toss,Bat,Bowl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match);
        Match_number = (EditText)findViewById(R.id.M);
        team1 = (EditText)findViewById(R.id.team1);
        team2 = (EditText)findViewById(R.id.team2);
        Toss=(EditText)findViewById(R.id.toss);
        bat_first=(EditText)findViewById(R.id.bat);
        bowl_first=(EditText)findViewById(R.id.bowl);


    }



    public void userReg2(View view)
    {
        M_number =  Match_number.getText().toString();
        t1 = team1.getText().toString();
        t2 =  team2.getText().toString();
        toss = Toss.getText().toString();
        Bat =   bat_first.getText().toString();
        Bowl = bowl_first.getText().toString();

        String method = "reg2";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,M_number,t1,t2,toss,Bat,Bowl);
    }



}
