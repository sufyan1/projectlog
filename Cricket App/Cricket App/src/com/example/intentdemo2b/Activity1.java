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
    EditText txtValue1;
    EditText txtValue2;
    TextView txtResult;
	TextView txtResult2;
    Button   btnsub;
	Button   btnsub2;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        txtValue1 = (EditText)findViewById(R.id.EditText01);
        txtValue2 = (EditText)findViewById(R.id.EditText02);
        txtResult = (TextView) findViewById(R.id.txtResult);
		txtResult2 = (TextView) findViewById(R.id.txtResult2);
        ///////////////////////////////////////

		//////////////////////////////////////////
        btnsub = (Button) findViewById(R.id.btnAdd);
        btnsub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// get values from the UI
				String v1 = (txtValue1.getText().toString());
				String v2 = (txtValue2.getText().toString());

				// create intent to call Activity2
				Intent myIntentA1A2 = new Intent (Activity1.this,
						Activity2.class);

				// create a Bundle (MAP) container to ship data
				Bundle myDataBundle = new Bundle();

				// add <key,value> data items to the container
				myDataBundle.putString("Team 1", v1);
				myDataBundle.putString("Team 2", v2);

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

	}//onCreate

    //////////////////////////////////////////////////////////////////////////////
    // local listener receives callbacks from other activities
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		try	{
			if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
				Bundle myResultBundle = data.getExtras();
				String  myResult = myResultBundle.getString("Teams");
				int sc =myResultBundle.getInt("score");
				int wkts=myResultBundle.getInt("wickets");
				Double overs=myResultBundle.getDouble("overs");
				Double overslimit=myResultBundle.getDouble("overslimit");
				txtResult.setText("Match  " + myResult+ "\nRuns:"+sc+"\nwkts:"+wkts+"\novers:"+overs+"\novers Limit:"+overslimit);
			}
			else if((requestCode == 102 ) && (resultCode == Activity.RESULT_OK)){
				Bundle mynewResultBundle = data.getExtras();
				int tr =mynewResultBundle.getInt("target");
				txtResult2.setText("Match  " +tr);
			}
		}
		catch (Exception e) {
			txtResult.setText("Problems - " + requestCode + " " + resultCode);
		}
	}//onActivityResult
    
}//Activity1