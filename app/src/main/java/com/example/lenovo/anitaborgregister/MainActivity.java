package com.example.lenovo.anitaborgregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btloginmain, btregmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineParameters();


    }

    private void defineParameters() {
        btloginmain = (Button) findViewById(R.id.buttonLoginmain);
        btregmain = (Button) findViewById(R.id.buttonRegistermain);
    }

    public void openLogin(View view){
        startActivity(new Intent(this, login.class));
    }

     public void openRegister(View view){
         startActivity(new Intent(this, Register.class));
     }



    /*
    public void start (View view)
    {
        Intent intent =new Intent(this,start.class );
        startActivity(intent);
    }
    
    public void login (View view)
    {
        Intent intent =new Intent(this,login.class );
        startActivity(intent);
    }
    */
}
