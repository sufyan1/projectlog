package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Teams extends Activity implements OnClickListener{
    EditText Team1;
    EditText Team2;
    EditText Teams;
    Button  btnDone;
    Button  btnchk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);
        Team1 = (EditText)findViewById(R.id.team1);
        Team2 = (EditText)findViewById(R.id.team2);
        Teams = (EditText)findViewById(R.id.checkbar);

        btnDone = (Button) findViewById(R.id.teamupdate);
        btnDone.setOnClickListener(this);

        // pick call made to Activity2 via Intent
        Intent myteamLocalIntent = getIntent();
        btnchk = (Button) findViewById(R.id.btnchk);

        btnchk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // get values from the UI

                String v1 = (Team1.getText().toString());
                String v2 = (Team2.getText().toString());

                String vs =  v2 +" vs "+ v1;
                Teams.setText("Current Match  \n"
                        + "Team 1 = " + v1 + "\nTeam 2 = " + v2
                        + "\n\n" + vs);


                Bundle myteamDataBundle =  myteamLocalIntent.getExtras();
                myteamDataBundle.putString("Team 1", v1);
                myteamDataBundle.putString("Team 2", v2);

                myteamLocalIntent.putExtras(myteamDataBundle);

                // return sending an OK signal to calling activity
                setResult(Activity.RESULT_OK, myteamLocalIntent);

                // experiment: remove comment
                // finish();



            }
        });
    }//onCreate




//onCreate

    @Override
    public void onClick(View v) {
        // close current screen - terminate Activity2
        finish();
    }

}
