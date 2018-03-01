package com.onestopcancercenter.onestopcancercenter;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class user_sign_in_page extends AppCompatActivity  implements  AdapterView.OnItemClickListener{
    DatabaseHelper DB;
    Cursor result;
private EditText name;
private EditText password;
private TextView info;
private Button login;
private  int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in_page);

    name =(EditText) findViewById(R.id.textView_username);
    password =(EditText) findViewById(R.id.password1);
    info=(TextView ) findViewById(R.id.textView10);
    login=(Button)findViewById(R.id. button_login);
    info.setText("Number of attemps remaining: 5");


        String dbLocation = "/data/data/" + user_sign_in_page.this.getPackageName() + "/databases/";
        File Dir = new File(dbLocation);
        if (!Dir.mkdirs())
        {
            Log.e("DB","can not find the dir");
        }
        DB = new DatabaseHelper(user_sign_in_page.this, dbLocation);
        DB.close();
        Log.d("print","pass new Databasehelper call");
        if (DB.checkDataBase())



        login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
validate(name.getText().toString(),password.getText().toString());
    }
});
}



private void validate (String username , String userpassword) {


                    int n = result.getCount();
                    String[] list=new String[n];
                    int i=0;
                    while (!result.isLast()&&i<n)
                    {
                        result.moveToNext();
                        list[i++] = result.getString(1);
                        if (username.equals(result.getString(2)) &&
                                userpassword.equals(result.getString(3))) {
                            Intent intent = new Intent(user_sign_in_page.this, Menu_user.class);
                            startActivity(intent);}
                               else {

                                info.setText(" Wrong password or user name");

                            }

                    }





                }


    @Override
    public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
        TextView tv = (TextView) view;
        Toast.makeText(this, "you clicked item #"+i+ tv.getText(),Toast.LENGTH_SHORT).show();
    }
}



