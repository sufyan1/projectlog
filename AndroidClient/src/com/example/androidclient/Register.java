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

    //Register activity starts four other actvities
    //C_batsman on click method for this activity
    public void C_batsman(View view)
    {
        startActivity(new Intent(this,Current_BB.class));
    }
    //userreg2 on click method for this activity
    public void userReg2(View view)
    {
        startActivity(new Intent(this,MatchDetails.class));
    }
    //score on click method for this activity
    public void Score(View view)
    {
        startActivity(new Intent(this,Scoreupdate.class));
    }
    //teams on click method for this activity
    public void Teams(View view) {startActivity(new Intent(this,Teams.class));}
    //condition on click method for this activity
    public void Conditions(View view) {startActivity(new Intent(this,Playing_Conditions_And_Venue.class));}

}
