package com.example.lenovo.anitaborgregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Afrin on 6/23/2018.
 */

public class Register extends AppCompatActivity {


    TextView tvfirstname, tvlastname, tvemail, tvpassword, tvcontact1, tvcontact2,
            tvcompany, tvdesign;
    EditText Firstname, Lastname, Email, Password, Contact1, Contact2,
            Company, Design;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        defineParameters();


    }

    private void defineParameters() {

        tvfirstname = (TextView)findViewById(R.id.tvfirname);
        tvlastname = (TextView)findViewById(R.id.tvlastname);
        tvemail = (TextView)findViewById(R.id.tvemail);
        tvpassword = (TextView)findViewById(R.id.tvpassword);
        tvcontact1 = (TextView)findViewById(R.id.tvcontact1);
        tvcontact2 = (TextView)findViewById(R.id.tvcontact2);
        tvcompany = (TextView)findViewById(R.id.tvcompany);
        tvdesign = (TextView)findViewById(R.id.tvdesignation);

        Firstname = (EditText) findViewById(R.id.etfirname);
        Lastname = (EditText)findViewById(R.id.etlastname);
        Email = (EditText)findViewById(R.id.etemail);
        Password = (EditText)findViewById(R.id.etpassword);
        Contact1 = (EditText)findViewById(R.id.etcontact1);
        Contact2 = (EditText)findViewById(R.id.etcontact2);
        Company = (EditText)findViewById(R.id.etcompany);
        Design = (EditText)findViewById(R.id.etdesignation);

    }

    public void onRegister(View view){
        String firstname = Firstname.getText().toString();
        String lastname = Lastname.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String contact1 = Contact1.getText().toString();
        String contact2 = Contact2.getText().toString();
        String company = Company.getText().toString();
        String design = Design.getText().toString();
        String type ="register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, firstname, lastname, email, password, contact1, contact2, company, design);

    }

}





