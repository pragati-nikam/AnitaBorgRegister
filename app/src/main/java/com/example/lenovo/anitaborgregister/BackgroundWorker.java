package com.example.lenovo.anitaborgregister;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Matrix;
import android.os.AsyncTask;

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
 * Created by Afrin on 6/22/2018.
 */

public class BackgroundWorker extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;
    BackgroundWorker(Context ctx){
        context =ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        //set url
        String login_url = "http://myapppractice/AnitaBorgPuneDatabase/login.php";
        String register_url = "http://mymyapppractice/AnitaBorgPuneDatabase/register.php";
        if(type.equals("login")){
            try {
                String user_name = params[1];
                String pass_word = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("username", "UTF-8")+""+URLEncoder.encode(user_name, "UTF-8")+"&"
                        +URLEncoder.encode("password", "UTF-8")+""+URLEncoder.encode(pass_word, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result ="";
                String line ="";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(type.equals("register")){
            try {
                String firstname = params[1];
                String lastname = params[2];
                String email = params[3];
                String password = params[4];
                String contact1 = params[5];
                String contact2 = params[6];
                String company = params[7];
                String design = params[8];

                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String post_data = URLEncoder.encode("name", "UTF-8")+""+URLEncoder.encode(firstname, "UTF-8")+"&"
                        +URLEncoder.encode("surname", "UTF-8")+""+URLEncoder.encode(lastname, "UTF-8")
                        +"&"
                        +URLEncoder.encode("email", "UTF-8")+""+URLEncoder.encode(email, "UTF-8")
                        +"&"
                        +URLEncoder.encode("password", "UTF-8")+""+URLEncoder.encode(password, "UTF-8")
                        +"&"
                        +URLEncoder.encode("contact1", "UTF-8")+""+URLEncoder.encode(contact1, "UTF-8")
                        +"&"
                        +URLEncoder.encode("contact2", "UTF-8")+""+URLEncoder.encode(contact2, "UTF-8")
                        +"&"
                        +URLEncoder.encode("company", "UTF-8")+""+URLEncoder.encode(company, "UTF-8")
                        +"&"
                        +URLEncoder.encode("designation", "UTF-8")+""+URLEncoder.encode(design, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result ="";
                String line ="";
                while((line = bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
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
    protected void onPostExecute(String res) {
        alertDialog.setMessage(res);
        alertDialog.show();
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }


}
