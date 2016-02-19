package com.example.androidclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sufyan on 2/19/2016.
 */
public class MatchDetails  extends Activity {
    EditText team1,team2;
    String t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match);
        team1 = (EditText)findViewById(R.id.team1);
        team2 = (EditText)findViewById(R.id.team2);

    }



    public void userReg2(View view)
    {
        t1 = team1.getText().toString();
        t2 =  team2.getText().toString();
        String method = "reg2";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,t1,t2);
    }



}
