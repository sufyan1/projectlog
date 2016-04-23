package com.example.androidclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sufyan on 4/23/2016.
 */

public class Playing_Conditions_And_Venue extends Activity {
    EditText I,T,Weather,Pitch,Venue;
    String id,type,weather,pitch,venue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditions);
        I = (EditText)findViewById(R.id.M);
        T = (EditText)findViewById(R.id.type);
        Weather = (EditText)findViewById(R.id.w);
        Pitch = (EditText)findViewById(R.id.p);
        Venue = (EditText)findViewById(R.id.v);

    }

    public void C(View view)
    {
        id = I.getText().toString();
        type = T.getText().toString();
        weather = Weather.getText().toString();
        pitch = Pitch.getText().toString();
        venue = Venue.getText().toString();

        String method = "conditions";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,id,type,weather,pitch,venue);
    }
}

