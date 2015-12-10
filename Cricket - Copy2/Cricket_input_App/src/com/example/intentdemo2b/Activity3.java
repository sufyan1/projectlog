package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends Activity implements OnClickListener{

    EditText data;

    Button  btnDone;
    Button  btnchk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        //team = (EditText) findViewById(R.id.target);
        data = (EditText) findViewById(R.id.sscore);

        btnDone = (Button) findViewById(R.id.btntarget);
        btnDone.setOnClickListener(this);

        // pick call made to Activity2 via Intent
        Intent mynewLocalIntent = getIntent();
        btnchk = (Button) findViewById(R.id.btnchkk);

        btnchk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            // get values from the UI

                Integer ss1= Integer.parseInt(data.getText().toString());
                //String v1 = (team.getText().toString());

                Bundle mynewBundle =  mynewLocalIntent.getExtras();
                mynewBundle.putInt("target", ss1);
                mynewLocalIntent.putExtras(mynewBundle);

                // return sending an OK signal to calling activity
                setResult(Activity.RESULT_OK, mynewLocalIntent);

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
