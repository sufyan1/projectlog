package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends Activity implements OnClickListener{
    EditText dataReceived;
    EditText data;

    Button  btnDone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        dataReceived = (EditText) findViewById(R.id.target);
        data = (EditText) findViewById(R.id.sscore);

        btnDone = (Button) findViewById(R.id.btntarget);
        btnDone.setOnClickListener(this);

        // pick call made to Activity2 via Intent
        Intent mynewLocalIntent = getIntent();
///////////////////////////////////////////
               // get values from the UI
      //  Double ss4= Double.parseDouble(data.getText().toString());
        //have to fix this now////////////////////////

                // look into the bundle sent to Activity2 for data items
                Bundle mynewBundle =  mynewLocalIntent.getExtras();
                mynewLocalIntent.putExtras(mynewBundle);

                // return sending an OK signal to calling activity
                setResult(Activity.RESULT_OK, mynewLocalIntent);

                // experiment: remove comment
                // finish();
            }


    //onCreate

    @Override
    public void onClick(View v) {
        // close current screen - terminate Activity2
        finish();
    }

}
