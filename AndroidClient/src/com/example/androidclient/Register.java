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
    EditText ET_NAME,ET_USER_NAME,ET_USER_PASS,Toss;
    String name,user_name,user_pass,Get_Toss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        ET_NAME = (EditText)findViewById(R.id.name);
        ET_USER_NAME = (EditText)findViewById(R.id.new_user_name);
        ET_USER_PASS = (EditText)findViewById(R.id.new_user_pass);
        Toss = (EditText)findViewById(R.id.toss_text);
    }



    public void userReg(View view)
    {
        name = ET_NAME.getText().toString();
        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();
        Get_Toss = Toss.getText().toString();
        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,user_name,user_pass,Get_Toss);
    }



}
