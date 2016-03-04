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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

    }
    public void C_batsman(View view)
    {
        startActivity(new Intent(this,Current_BB.class));
    }
    public void userReg2(View view)
    {
        startActivity(new Intent(this,MatchDetails.class));
    }
    public void Score(View view)
    {
        startActivity(new Intent(this,Scoreupdate.class));
    }




}
