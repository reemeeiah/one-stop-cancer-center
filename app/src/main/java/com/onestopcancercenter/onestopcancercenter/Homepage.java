package com.onestopcancercenter.onestopcancercenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

    String s = "/data/data" + Homepage.this.getPackageName() + "/Database/";

    DatabaseHelper DB = new DatabaseHelper(Homepage.this, s);
    try
    {
        DB.prepareDatabase();
    }
    catch(
    IOException e)
    {
        e.printStackTrace();
    }


}

}
