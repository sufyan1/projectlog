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
    //edit text varaibles
    EditText id,batsman,bowler,type;
    //String variables
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
        //Name of the String Method
        String method = "Current";
        //create an object of a background task
        BackgroundTask backgroundTask = new BackgroundTask(this);
        //Pass the arguments to the object for sending it to database
        backgroundTask.execute(method,Match_id,Bat,bowl,match_type);
    }
}
