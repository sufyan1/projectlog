package com.example.intentdemo2b;
// Multi-Activity Application
// Activity1: collects two data items from the user's UI, places
//			  them into a Bundle, and calls Activity2
// Activity2: accepts two data items, adds them, returns result

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends Activity {

    TextView txtResult;
	TextView txtResult2;
	TextView Teams;
	TextView Toss;
    Button   btnsub;
	Button   btnsub2;
	Button   btnteam;
	Button   btntoss;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
		Teams = (TextView) findViewById(R.id.teams);
		Toss = (TextView) findViewById(R.id.toss);
        txtResult = (TextView) findViewById(R.id.txtResult);
		txtResult2 = (TextView) findViewById(R.id.txtResult2);

        btnsub = (Button) findViewById(R.id.btnAdd);
        btnsub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// get values from the UI


				// create intent to call Activity2
				Intent myIntentA1A2 = new Intent (Activity1.this,
						Activity2.class);

				// create a Bundle (MAP) container to ship data
				Bundle myDataBundle = new Bundle();


				// attach the container to the intent
				myIntentA1A2.putExtras(myDataBundle);

				// call Activity2, tell your local listener to wait a
				// response sent to a listener known as 101
				startActivityForResult(myIntentA1A2, 101);
				//startActivityForResult(myIntentA1A3, 102);
				
			}
				
		});
		btnsub2 = (Button) findViewById(R.id.btnAdd2);
		btnsub2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// get values from the UI
				// create intent to call Activity3
				Intent mynewIntentA1A2 = new Intent (Activity1.this,
						Activity3.class);
				// create a Bundle (MAP) container to ship data
				Bundle mynewDataBundle = new Bundle();
				// attach the container to the intent
				mynewIntentA1A2.putExtras(mynewDataBundle);
				// call Activity3, tell your local listener to wait a
				// response sent to a listener known as 102
				startActivityForResult(mynewIntentA1A2, 102);

			}

		});
		btnteam = (Button) findViewById(R.id.buttonteams);
		btnteam.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// get values from the UI
				// create intent to call Activity3
				Intent mynewIntentA1A2 = new Intent (Activity1.this,
						Teams.class);
				// create a Bundle (MAP) container to ship data
				Bundle mynewDataBundle = new Bundle();
				// attach the container to the intent
				mynewIntentA1A2.putExtras(mynewDataBundle);
				// call Activity3, tell your local listener to wait a
				// response sent to a listener known as 102
				startActivityForResult(mynewIntentA1A2, 103);

			}

		});
		btntoss = (Button) findViewById(R.id.toss2);
		btntoss.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// get values from the UI
				// create intent to call Activity3
				Intent mynewIntentA1A2 = new Intent (Activity1.this,
						Toss.class);
				// create a Bundle (MAP) container to ship data
				Bundle mynewDataBundle = new Bundle();
				// attach the container to the intent
				mynewIntentA1A2.putExtras(mynewDataBundle);
				// call Activity3, tell your local listener to wait a
				// response sent to a listener known as 102
				startActivityForResult(mynewIntentA1A2, 104);

			}

		});

	}//onCreate

    //////////////////////////////////////////////////////////////////////////////
    // local listener receives callbacks from other activities
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		try	{
			if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
				Bundle myResultBundle = data.getExtras();

				int sc =myResultBundle.getInt("score");
				int wkts=myResultBundle.getInt("wickets");
				Double overs=myResultBundle.getDouble("overs");
				Double overslimit=myResultBundle.getDouble("overslimit");
				txtResult.setText("Scores  " + "\nRuns:"+sc+"\nwkts:"+wkts+"\novers:"+overs+"\novers Limit:"+overslimit);
			}
			else if((requestCode == 102 ) && (resultCode == Activity.RESULT_OK)){
				Bundle mynewResultBundle = data.getExtras();
				int tr =mynewResultBundle.getInt("target");
				txtResult2.setText("TARGET  " +tr);
			}
			else if((requestCode == 103 ) && (resultCode == Activity.RESULT_OK)){
				Bundle mynewResultBundle = data.getExtras();
				String  team1 = mynewResultBundle.getString("Team 1");
				String  team2 = mynewResultBundle.getString("Team 2");
				 Teams.setText( team1+" vs "+team2);

			}
			else if((requestCode == 104 ) && (resultCode == Activity.RESULT_OK)){
				Bundle mynewResultBundle = data.getExtras();
				String  toss = mynewResultBundle.getString("Toss");
				String  bl = mynewResultBundle.getString("bowl");
				Toss.setText("Toss  " + toss+" "+bl);
			}
		}
		catch (Exception e) {
			txtResult.setText("Problems - " + requestCode + " " + resultCode);
		}
	}//onActivityResult
    
}//Activity1