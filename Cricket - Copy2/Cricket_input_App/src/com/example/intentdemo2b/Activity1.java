package com.example.intentdemo2b;
// Multi-Activity Application
// Activity1: collects two data items from the user's UI, places
//			  them into a Bundle, and calls Activity2
// Activity2: accepts two data items, adds them, returns result

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity1 extends Activity {

    TextView txtResult;
	TextView txtResult2;
	TextView Teams;
	TextView Toss;
    Button   btnsub;
	Button   btnsub2;
	Button   btnteam;
	Button   btntoss;
	private Button btnWriteSDFile;
	private String mySdPath;
	MySQLiteHelper dbs;
	SQLiteDatabase db;


	Map<String,String> myMap  = new HashMap<String,String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
		Teams = (TextView) findViewById(R.id.teams);
		Toss = (TextView) findViewById(R.id.toss);
        txtResult = (TextView) findViewById(R.id.txtResult);
		txtResult2 = (TextView) findViewById(R.id.txtResult2);





		mySdPath = Environment.getExternalStorageDirectory().getAbsolutePath();



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
			//	txtMsg.setText("returned from database handler ");
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

		private void dropTable() {
			// (clean start) action query to drop table
			try {
				db.execSQL("DROP TABLE IF EXISTS tableDB;");
			//	txtMsg.append("\n-dropTable - dropped!!");
			} catch (Exception e) {
			//	txtMsg.append("\nError dropTable: " + e.getMessage());
				finish();
			}
		}

		private void openDatabase() {
			try {
				String myDbPath = mySdPath  + "/myDB1.db";
			//	txtMsg.append("\n-openDatabase - DB Path: " + myDbPath);

				db = SQLiteDatabase.openDatabase(myDbPath, null,
						SQLiteDatabase.CREATE_IF_NECESSARY);

			//	txtMsg.append("\n-openDatabase - DB was opened");
			} catch (SQLiteException e) {
			//	txtMsg.append("\nError openDatabase: " + e.getMessage());
				finish();
			}
		}// createDatabase

		private void insertSomeDbData() {
			// create table: tblAmigo
			db.beginTransaction();
			try {
				// create table
				db.execSQL("create table tableDB ("
						+ " ID integer PRIMARY KEY autoincrement, "
						+ " Score  text, "
						+ " Wickets  text, "
						+ " Overs_bowled text , "
						+ " Overslimit text);  ");

				// commit your changes
				db.setTransactionSuccessful();

			//	txtMsg.append("\n-insertSomeDbData - Table was created");

			} catch (SQLException e1) {
			//	txtMsg.append("\nError insertSomeDbData: " + e1.getMessage());
				finish();
			} finally {
				db.endTransaction();
			}
			// populate table: tblAmigo
			db.beginTransaction();
			try {

				// commit your changes
				db.setTransactionSuccessful();
			//	txtMsg.append("\n-insertSomeDbData - 3 rec. were inserted");

			} catch (SQLiteException e2) {
			//	txtMsg.append("\nError insertSomeDbData: " + e2.getMessage());
			} finally {
				db.endTransaction();
			}
		}// insertSomeData
	// backroundAsyncTask


//Activity1
}