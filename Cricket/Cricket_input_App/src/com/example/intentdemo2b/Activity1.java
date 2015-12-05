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
	//TextView txtMsg;
	Button btnReadXml;
	private Button btnWriteSDFile;
	private Button dbBtn;
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


	//	txtMsg = (TextView) findViewById(R.id.t1);

		btnReadXml = (Button) findViewById(R.id.r1);
		btnReadXml.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				btnReadXml.setEnabled(false);
				// do slow XML reading in a separated thread
				//Integer xmlResFile = R.xml.manakiki_golf_course;/*************************/
				Integer xmlResFile = R.xml.employees;

				new backgroundAsyncTask().execute(xmlResFile);
				Toast.makeText(getBaseContext(),
						"Done reading xml file employees list updated ",
						Toast.LENGTH_SHORT).show();

			}
		});

		mySdPath = Environment.getExternalStorageDirectory().getAbsolutePath();

		btnWriteSDFile = (Button) findViewById(R.id.d1);
		btnWriteSDFile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
//					dbs.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));
//					dbs.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));
//					dbs.addBook(new Book("Learn Android App Development", "Wallace Jackson"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}// onClick
		}); // btnWriteSDFile

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
	/*******************************************************************************************
	 *reading XML
	 *******************************************************************************************/
	public class backgroundAsyncTask extends
			AsyncTask<Integer, Void, List> {


		ProgressDialog dialog = new ProgressDialog(Activity1.this);

		public List<Employee> getEmpList() {
			return empList;
		}

		List<Employee> empList = new ArrayList<>();

		String content = null;

		@Override
		protected void onPostExecute(List empList1) { // after reading xml
			super.onPostExecute(empList1);//
			dialog.dismiss();

			for(Employee emp: empList) {
			//	txtResult.append(emp.toString()+"\n");
			}

			openDatabase(); // open (create if needed) database
			dropTable(); // if needed drop table tblAmigos
			insertSomeDbData();
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog.setMessage("Please wait...");
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected List doInBackground(Integer... params) {
			Employee emp = null;
			int xmlResFile = params[0];
			XmlPullParser parser = getResources().getXml(xmlResFile);

			StringBuilder stringBuilder = new StringBuilder();
			String nodeText = "";
			String nodeName = "";


			try {
				int eventType = -1;
				while (eventType != XmlPullParser.END_DOCUMENT) {

					eventType = parser.next();

					if (eventType == XmlPullParser.START_DOCUMENT) {
						stringBuilder.append("\nSTART_DOCUMENT");

					} else if (eventType == XmlPullParser.END_DOCUMENT) {
						stringBuilder.append("\nEND_DOCUMENT");

					} else if (eventType == XmlPullParser.START_TAG) {
						nodeName = parser.getName();
						stringBuilder.append("\nSTART_TAG: " + nodeName);
						//stringBuilder.append(getAttributes(parser));

						switch(nodeName){
							//Create a new Employee object when the start tag is found
							case "Match":
								emp = new Employee();
								emp.attributes = getAttributes(parser);
								break;
						}
					}
					else if (eventType == XmlPullParser.END_TAG) {
						nodeName = parser.getName();
						switch(nodeName) {
							//For all other end tags the employee has to be updated.
							case "employee":
								empList.add(emp);
								break;
							case "score":
								emp.firstName = nodeText;
								break;
							case "wickets":
								emp.minit = nodeText;
								break;
							case "overs":
								emp.lastName = nodeText;
								break;

						}
						stringBuilder.append("\nEND_TAG:   " + nodeName );

					} else if (eventType == XmlPullParser.TEXT) {
						nodeText = parser.getText();
						stringBuilder.append("\n    TEXT: " + nodeText);
					}
				}
			} catch (Exception e) {
				Log.e("<<PARSING ERROR>>", e.getMessage());
			}

			return empList;
		}// doInBackground

		private String[] getAttributes(XmlPullParser parser) {
			StringBuilder stringBuilder = new StringBuilder();
			// trying to detect inner attributes nested inside a node tag
			String name = parser.getName();
			String[] attributesList = null;
			if (name != null) {
				int size = parser.getAttributeCount();
				attributesList = new String[size];
				for (int i = 0; i < size; i++) {
					String attrName = parser.getAttributeName(i);

					String SALARY = parser.getAttributeValue(i);

					//myMap.put(attrName, attrValue);
					attributesList[i] = (" " + attrName + "=" + SALARY + "\n");
					//stringBuilder.append("key =" + attrName + " value = " + attrValue + "\n");
				}
			}
			return attributesList;
		}// innerElements

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
				for(Employee emp: empList) {

					ContentValues values = new ContentValues();

					db.insert("tableDB", // table
							null, //nullColumnHack
							values); // key/value -> keys = column names/ values = column values
				}


				// commit your changes
				db.setTransactionSuccessful();
			//	txtMsg.append("\n-insertSomeDbData - 3 rec. were inserted");

			} catch (SQLiteException e2) {
			//	txtMsg.append("\nError insertSomeDbData: " + e2.getMessage());
			} finally {
				db.endTransaction();
			}
		}// insertSomeData
	}// backroundAsyncTask

	class Employee {
		String id;
		String firstName;
		String minit;
		String lastName;


		String [] attributes;

		@Override
		public String toString() {
			return "Match "+ "\n" + " \nScore:" +firstName + " \nWickets: " + minit + " \novers: " + lastName +" \n";
		}
		public String getID(){
			return id;
		}
		public String getscore(){
			return firstName;
		}
		public String getwickets(){
			return minit;
		}
		public String getovers(){
			return minit;
		}



	}
}//Activity1