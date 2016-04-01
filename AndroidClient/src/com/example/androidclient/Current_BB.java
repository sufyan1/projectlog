package com.example.androidclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sufyan on 3/2/2016.
 */
public class Current_BB extends Activity{
    EditText id,batsman,bowler,type;
    String Match_id,Bat,bowl,match_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current);
        id = (EditText)findViewById(R.id.id);
        batsman = (EditText)findViewById(R.id.bat);
        bowler = (EditText)findViewById(R.id.bowl);
        type = (EditText)findViewById(R.id.type);
    }

    public void upload(View view)
    {
        Match_id = id.getText().toString();
        Bat = batsman.getText().toString();
        bowl = bowler.getText().toString();
        match_type = type.getText().toString();
        String method = "Current";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,Match_id,Bat,bowl,match_type);
    }
}
