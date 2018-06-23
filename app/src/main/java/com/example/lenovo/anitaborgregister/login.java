package com.example.lenovo.anitaborgregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    TextView tvemailLogin, tvpasswordLogin;
    EditText etemailLogin, etpasswordLogin;
    Button btbuttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        defineParameter();
    }

    private void defineParameter() {

        tvemailLogin = (TextView)findViewById(R.id.tvemailLogin);
        tvpasswordLogin =(TextView)findViewById(R.id.tvpasswordLogin);
        etemailLogin = (EditText)findViewById(R.id.etemailLogin);
        etpasswordLogin = (EditText)findViewById(R.id.etpasswordLogin);
        btbuttonLogin = (Button)findViewById(R.id.buttonLogin);
    }

    public void onLogin(View view){
        //String username =

        String email = etemailLogin.getText().toString();
        String password = etpasswordLogin.getText().toString();
        String type ="login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, email, password);
    }
}
