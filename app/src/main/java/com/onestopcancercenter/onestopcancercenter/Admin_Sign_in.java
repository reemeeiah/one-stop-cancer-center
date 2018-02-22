package com.onestopcancercenter.onestopcancercenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Admin_Sign_in extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__sign_in);
        name =(EditText) findViewById(R.id.adminlogin);
        password =(EditText) findViewById(R.id.password2);
        info=(TextView ) findViewById(R.id.textView11);
        login=(Button)findViewById(R.id. button8);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });

    }

    private void validate (String username , String userpassword){
        if ((username.equals("admin")) && (userpassword.equals("1234"))){

            Intent intent= new Intent(Admin_Sign_in.this,Homepage.class);
            startActivity(intent);
        }
        else{

            info.setText(" Wrong password");

            }
        }


    }

