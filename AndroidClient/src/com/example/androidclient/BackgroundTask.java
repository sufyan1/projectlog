package com.example.androidclient;

/**
 * Created by Sufyan on 1/22/2016.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
/**
 * Created by prabeesh on 7/14/2015.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx =ctx;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Uploading Information....");
    }
    @Override
    protected String doInBackground(String... params) {
     //   String reg_url = "http://192.168.0.7/webapp/register.php"; //home ip address
     //   String login_url = "http://192.168.0.7/webapp/login.php";//home ip address
       String reg_url = "http://10.0.3.2/webapp/register.php";
        String reg2_url = "http://10.0.3.2/webapp/reg2.php"; //for reg2 php
           String login_url = "http://10.0.3.2/webapp/login.php";
        String bat_url = "http://10.0.3.2/webapp/Current.php";
        String method = params[0];
        if (method.equals("register")) {
            String id = params[1];
            String name = params[2];
            String team_score = params[3];
            String team_wickets = params[4];
            String Get_overs = params[5];
            String Totalovers = params[6];
            String type = params[7];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&" +
                        URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("team_score", "UTF-8") + "=" + URLEncoder.encode(team_score, "UTF-8") + "&" +
                        URLEncoder.encode("team_wickets", "UTF-8") + "=" + URLEncoder.encode(team_wickets, "UTF-8") + "&" +
                        URLEncoder.encode("Get_overs", "UTF-8") + "=" + URLEncoder.encode(Get_overs, "UTF-8") + "&" +
                URLEncoder.encode("Totalovers", "UTF-8") + "=" + URLEncoder.encode(Totalovers, "UTF-8")+ "&" +
                URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Scores has been Registered successfully";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("reg2")) {
            String Match_Number = params[1];
            String team1 = params[2];
            String team2 = params[3];
            String toss = params[4];
            String bat = params[5];
            String bowl = params[6];
            String type = params[7];



            try {
                URL url = new URL(reg2_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("Match_Number", "UTF-8") + "=" + URLEncoder.encode(Match_Number, "UTF-8") + "&" +
                        URLEncoder.encode("team1", "UTF-8") + "=" + URLEncoder.encode(team1, "UTF-8") + "&" +
                        URLEncoder.encode("team2", "UTF-8") + "=" + URLEncoder.encode(team2, "UTF-8") + "&" +
                        URLEncoder.encode("toss", "UTF-8") + "=" + URLEncoder.encode(toss, "UTF-8") + "&" +
                        URLEncoder.encode("batting", "UTF-8") + "=" + URLEncoder.encode(bat, "UTF-8") + "&" +
                        URLEncoder.encode("bowling", "UTF-8") + "=" + URLEncoder.encode(bowl, "UTF-8")+ "&" +
                URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Match Details Uploaded";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("Current")) {
            String id = params[1];
            String bat = params[2];
            String bowl = params[3];
            String type = params[4];



            try {
                URL url = new URL(bat_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&" +
                        URLEncoder.encode("bat", "UTF-8") + "=" + URLEncoder.encode(bat, "UTF-8") + "&" +
                        URLEncoder.encode("bowl", "UTF-8") + "=" + URLEncoder.encode(bowl, "UTF-8") + "&" +
                        URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();
                return "Batsman at Crease and Bowler Bowling Updated";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success..."))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}