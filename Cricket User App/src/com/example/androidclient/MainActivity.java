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
	EditText ID,Match_Details;
	String id,Match;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ID = (EditText)findViewById(R.id.id);
	//	Match_Details = (EditText)findViewById(R.id.m_d);
	}


	public void userLogin(View view)
	{
		id = ID.getText().toString();
		//Match = Match_Details.getText().toString();
		String method = "login";
		BackgroundTask backgroundTask = new BackgroundTask(this);
		backgroundTask.execute(method,id);
	}
	public void matchLogin(View view)
	{
		id = ID.getText().toString();
		String method = "Match";
		BackgroundTask backgroundTask = new BackgroundTask(this);
		backgroundTask.execute(method,id);
	}
	public void Current(View view)
	{
		id = ID.getText().toString();
		String method = "Current";
		BackgroundTask backgroundTask = new BackgroundTask(this);
		backgroundTask.execute(method,id);
	}
}