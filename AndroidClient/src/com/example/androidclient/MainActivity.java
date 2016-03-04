package com.example.androidclient;

//package com.easyway2in.mysqldbdemo;
		import android.app.Activity;
		import android.content.Intent;
		import android.os.StrictMode;
//		import android.support.v7.app.ActionBarActivity;
		import android.os.Bundle;
		import android.view.Menu;
		import android.view.MenuItem;
		import android.view.View;
		import android.widget.EditText;
public class MainActivity extends Activity{
	EditText ET_NAME,ET_PASS;
	String Bat,Score;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ET_NAME = (EditText)findViewById(R.id.user_name);
		ET_PASS = (EditText)findViewById(R.id.user_pass);
	}
	public void userReg(View view)
	{
		startActivity(new Intent(this,Register.class));
	}

	public void userLogin(View view)
	{
		Bat = ET_NAME.getText().toString();
		Score = ET_PASS.getText().toString();
		String method = "login";
		BackgroundTask backgroundTask = new BackgroundTask(this);
		backgroundTask.execute(method,Bat,Score);
	}
}