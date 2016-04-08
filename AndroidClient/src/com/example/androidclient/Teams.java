package com.example.androidclient;

/**
 * Created by Sufyan on 4/8/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Sufyan on 08/04/2016.
 */
public class Teams extends Activity {
    EditText I,T,p1,p2,p3,p4,p5;
    String id,type,n1,n2,n3,n4,n5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);
        I = (EditText)findViewById(R.id.M);
        T = (EditText)findViewById(R.id.type);
        p1 = (EditText)findViewById(R.id.P1);
        p2 = (EditText)findViewById(R.id.P2);
        p3 = (EditText)findViewById(R.id.P3);
        p4 = (EditText)findViewById(R.id.P4);
        p5 = (EditText)findViewById(R.id.P5);
    }

    public void T(View view)
    {
        id = I.getText().toString();
        type = T.getText().toString();
        n1 = p1.getText().toString();
        n2 = p2.getText().toString();
        n3 = p3.getText().toString();
        n4 = p4.getText().toString();
        n5 = p5.getText().toString();
        String method = "Teams";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,id,type,n1,n2,n3,n4,n5);
    }
}
