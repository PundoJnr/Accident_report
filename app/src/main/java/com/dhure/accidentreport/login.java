package com.dhure.accidentreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends AppCompatActivity {
    EditText username = (EditText) findViewById(R.id.username);
    EditText password = (EditText) findViewById(R.id.password);
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void login(View view){
        if(username.getText().toString().equals("admin")&&password.getText().toString().equals("admin")){
            Intent intent = new Intent (this,menu.class);
            startActivity(intent);
        }else{
            bt = (Button) findViewById(R.id.loginn);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Incorrect username or password",Toast.LENGTH_LONG);
                }
            });

        }
    }
    public void register(View view){
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }


}
