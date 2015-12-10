package com.example.intentdemo2b;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends Activity implements OnClickListener{
//	EditText dataReceived;

	private  String mySdPath;
	//EditText txtMsg;
	EditText data;
	Button  btnDone;
	Button  Btnchk;
	Button  Btnadd;
	Button btnDelete;
	EditText Score;
	EditText Wickets;
	EditText Overs;
	EditText Overslimit;
	SQLiteDatabase db;
	MySQLiteHelper dbs;
	String sc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
	//	txtMsg = (EditText) findViewById(R.id.e2);
		mySdPath = Environment.getExternalStorageDirectory().getAbsolutePath();

		Score = (EditText)findViewById(R.id.score);
		Wickets = (EditText)findViewById(R.id.wickets);
		Overslimit = (EditText)findViewById(R.id.overslimit);
		Overs = (EditText)findViewById(R.id.overs);

//		dataReceived = (EditText) findViewById(R.id.etDataReceived);
		data = (EditText) findViewById(R.id.Data);
		Btnadd = (Button) findViewById(R.id.a1);
		btnDelete = (Button) findViewById(R.id.d1);
		btnDone = (Button) findViewById(R.id.btnDone);
		btnDone.setOnClickListener(this);
		dbs = new MySQLiteHelper(this);

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
					  + "Score = " + s1 + "\nWickets = " + s2
					  + "\nOvers = " + s3+ "\nOvers limit= " + s4);
			  Bundle myBundle =  myLocalIntent.getExtras();

			  // operate on the input data

			  // add to the bundle the computed result
			  //	myBundle.putString("Teams", Teams);

			  // attach updated bumble to invoking intent

			    myBundle.putInt("score", s1);
			  myBundle.putInt("wickets", s2);
			  myBundle.putDouble("overs", s3);
			  myBundle.putDouble("overslimit", s4);
			  myLocalIntent.putExtras(myBundle);
			  //sc="Current score " + "Score = " + s1 + "\nwickets = " + s2 + "\n\novers = " + s3;
		  }

		});
		setResult(Activity.RESULT_OK, myLocalIntent);
		// look into the bundle sent to Activity2 for data items

		btnDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String tableName = Score.getText().toString();
				String tableName2 = Wickets.getText().toString();
				dbs.helperUseDeleteMethod(tableName);
			}// onClick
		});

		// return sending an OK signal to calling activity
	 Btnadd.setOnClickListener(new OnClickListener() {
		  @Override
		  public void onClick(View v) {
			  String tableName = Score.getText().toString();
			  String tableName2 = Wickets.getText().toString();
			  String tableName3 = Overs.getText().toString();
			  String tableName4 = Overslimit.getText().toString();

			  //addMethod(tableName, tableName2);
			  dbs.helperAddMethod(tableName,tableName2,tableName3,tableName4);
		  }// onClick
	  });



		
		// experiment: remove comment
		// finish();


	}//onCreate

	/*********************************************************************************************/
	// button methods
	/*******************************************************************************/

	private void showTable(String tableName) {
		try {
			String sql = "select * from " + tableName ;
			Cursor c = db.rawQuery(sql, null);
	//		txtMsg.append("\n-showTable: " + tableName + showCursor(c));
		} catch (Exception e) {
	//		txtMsg.append("\nError showTable: " + e.getMessage());

		}
	}// useCursor1

	private void openDatabase() {
		try {
			// path to private memory:data/data/cis470.matos.databases/myfriendsDB2.db
			//myDbPath = "data/data/cis470.matos.databases/";
			//mySdPath = Environment.getExternalStorageDirectory().getPath();
			String myDbPath = mySdPath  + "/myDB1.db";
	//		txtMsg.append("\n-openDatabase - DB Path: " + myDbPath);

			db = SQLiteDatabase.openDatabase(myDbPath, null,
					SQLiteDatabase.CREATE_IF_NECESSARY);

	//		txtMsg.append("\n-openDatabase - DB was opened");
		} catch (SQLiteException e) {
	//		txtMsg.append("\nError openDatabase: " + e.getMessage());
			finish();
		}
	}// createDatabase

	private void dropTable() {
		try {
			db.execSQL("DROP TABLE IF EXISTS tblAmigo;");
	//		txtMsg.append("\n-dropTable - dropped!!");
		} catch (Exception e) {
	//		txtMsg.append("\nError dropTable: " + e.getMessage());
			finish();
		}
	}



	private void useUpdateMethod() {
		try {
			// using the 'update' method to change name of selected friend
			String[] whereArgs = { "2" };

			ContentValues updValues = new ContentValues();
			updValues.put("name", "UPDATE");

			int recAffected = db.update("tblAMIGO", updValues,
					"recID = ? ", whereArgs);

	//		txtMsg.append("\n-useUpdateMethod - Rec Affected " + recAffected);
			showTable("tblAmigo");

		} catch (Exception e) {
	//		txtMsg.append("\n-useUpdateMethod - Error: " + e.getMessage());
		}
	}



	private String showCursor( Cursor cursor) {
		// show SCHEMA (column names & types)
		cursor.moveToPosition(-1); //reset cursor's top
		String cursorData = "\nCursor: [";

		try {
			// get column names
			String[] colName = cursor.getColumnNames();
			for(int i=0; i<colName.length; i++){
				String dataType = getColumnType(cursor, i);
				cursorData += colName[i] + dataType;

				if (i<colName.length-1){
					cursorData+= ", ";
				}
			}
		} catch (Exception e) {
			Log.e("<<SCHEMA>>", e.getMessage());
		}
		cursorData += "]";

		// now get the rows
		cursor.moveToPosition(-1); //reset cursor's top
		while (cursor.moveToNext()) {
			String cursorRow = "\n[";
			for (int i = 0; i < cursor.getColumnCount(); i++) {
				cursorRow += cursor.getString(i);
				if (i<cursor.getColumnCount()-1)
					cursorRow +=  ", ";
			}
			cursorData += cursorRow + "]";
		}
		return cursorData + "\n";
	}

	private String getColumnType(Cursor cursor, int i) {
		try {
			//peek at a row holding valid data
			cursor.moveToFirst();
			int result = cursor.getType(i);
			String[] types = {":NULL", ":INT", ":FLOAT", ":STR", ":BLOB", ":UNK" };
			//backtrack - reset cursor's top
			cursor.moveToPosition(-1);
			return types[result];
		} catch (Exception e) {
			return " ";
		}
	}

	private void useCursor1() {
		try {
			// this is similar to showCursor(...)
			// obtain a list of records[recId, name, phone] from DB
			String[] columns = { "ID", "firstName", "lastName","address" };
			// using simple parametric cursor
			Cursor c = db.query("tblAMIGO", columns, null, null, null, null,
					"recID");

			int theTotal = c.getCount();
	//		txtMsg.append("\n-useCursor1 - Total rec " + theTotal);
	//		txtMsg.append("\n");
			int idCol = c.getColumnIndex("ID");
			int nameCol = c.getColumnIndex("firstName");
			int phoneCol = c.getColumnIndex("lastName");
			int addressCol = c.getColumnIndex("address");

			c.moveToPosition(-1);
			while (c.moveToNext()) {
				columns[0] = Integer.toString((c.getInt(idCol)));
				columns[1] = c.getString(nameCol);
				columns[2] = c.getString(phoneCol);
				columns[3] = c.getString(addressCol);

	//			txtMsg.append(columns[0] + " " + columns[1] + " " + columns[2]+ columns[3] + " "
	//					+ "\n");
			}

		} catch (Exception e) {
	//		txtMsg.append("\nError useCursor1: " + e.getMessage());
			finish();
		}
	}// useCursor1

	@Override
	public void onClick(View v) {
		    // close current screen - terminate Activity2
			finish();		
	}
	
}
