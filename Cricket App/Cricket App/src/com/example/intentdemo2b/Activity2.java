package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends Activity implements OnClickListener{
	EditText dataReceived;
	EditText data;
	Button  btnDone;
	Button  Btnchk;
	EditText Score;
	EditText Wickets;
	EditText Overs;
	EditText Overslimit;

	String sc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		Score = (EditText)findViewById(R.id.score);
		Wickets = (EditText)findViewById(R.id.wickets);
		Overslimit = (EditText)findViewById(R.id.overslimit);
		Overs = (EditText)findViewById(R.id.overs);

		dataReceived = (EditText) findViewById(R.id.etDataReceived);
		data = (EditText) findViewById(R.id.Data);
		btnDone = (Button) findViewById(R.id.btnDone);
		btnDone.setOnClickListener(this);

		// pick call made to Activity2 via Intent
		Intent myLocalIntent = getIntent();
		Btnchk = (Button) findViewById(R.id.btnchk);

		Btnchk.setOnClickListener(new OnClickListener() {

		  @Override
		  public void onClick(View v) {
			  // get values from the UI
			  Integer s1= Integer.parseInt(Score.getText().toString());
			  Integer s2= Integer.parseInt(Wickets.getText().toString());
			  Double s3= Double.parseDouble(Overs.getText().toString());
			  Double s4= Double.parseDouble(Overslimit.getText().toString());


			  data.setText("Current score  \n"
					  + "Score = " + s1 + "\nwickets = " + s2
					  + "\n\novers = " + s3);
			  //sc="Current score " + "Score = " + s1 + "\nwickets = " + s2 + "\n\novers = " + s3;


		// look into the bundle sent to Activity2 for data items
		Bundle myBundle =  myLocalIntent.getExtras();
		String v1 = myBundle.getString("Team 1");
		String v2 = myBundle.getString("Team 2");
		
		// operate on the input data
		String Teams =  v2 +" vs "+ v1;
		//String livescore="Current score " + "Score = " + s1 + "\nwickets = " + s2 + "\n\novers = " + s3;
		// for illustration purposes. show data received & result
		dataReceived.setText("Current Match  \n"
				+ "Team 1 = " + v1 + "\nTeam 2 = " + v2
				+ "\n\nresult = " + Teams);
		
		// add to the bundle the computed result  
		myBundle.putString("Teams", Teams);
		myBundle.putInt("score", s1);
		myBundle.putInt("wickets", s2);
		myBundle.putDouble("overs", s3);
	    myBundle.putDouble("overslimit", s4);
		
		// attach updated bumble to invoking intent
		myLocalIntent.putExtras(myBundle);
		
		// return sending an OK signal to calling activity
		setResult(Activity.RESULT_OK, myLocalIntent);
		
		// experiment: remove comment
		// finish();
		  }

		});
	}//onCreate

	@Override
	public void onClick(View v) {
		    // close current screen - terminate Activity2
			finish();		
	}
	
}
