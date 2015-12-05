package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Toss extends Activity implements OnClickListener{
    TextView Tossview;
    EditText tossteam;
    Button  btnDone;
    Button  btnchk;
    Button  btnbat;
    Button  btnbowl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toss);
        tossteam = (EditText) findViewById(R.id.tosst);
        Tossview = (TextView) findViewById(R.id.tossteam);

        btnDone = (Button) findViewById(R.id.tossupdate);
        btnDone.setOnClickListener(this);

        // pick call made to Activity2 via Intent
        Intent mynewLocalIntent = getIntent();
        btnchk = (Button) findViewById(R.id.Enter);
        btnbat = (Button) findViewById(R.id.btnbat);
        btnbowl = (Button) findViewById(R.id.btnbowl);

        btnchk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // get values from the UI

                String v1 = (tossteam.getText().toString());
                Tossview.setText(v1+" won the toss");

                btnbowl.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String bowl = "bowl first";


                        Bundle mynewBundle = mynewLocalIntent.getExtras();
                        mynewBundle.putString("Toss", v1);
                        mynewBundle.putString("bowl", bowl);
                        mynewLocalIntent.putExtras(mynewBundle);

                        // return sending an OK signal to calling activity
                        setResult(Activity.RESULT_OK, mynewLocalIntent);
                    }
                });
                btnbat.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String bat="bat first";


                        Bundle mynewBundle =  mynewLocalIntent.getExtras();
                        mynewBundle.putString("Toss", v1);
                        mynewBundle.putString("bowl", bat);
                        mynewLocalIntent.putExtras(mynewBundle);

                        // return sending an OK signal to calling activity
                        setResult(Activity.RESULT_OK, mynewLocalIntent);
                    }
                });
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
