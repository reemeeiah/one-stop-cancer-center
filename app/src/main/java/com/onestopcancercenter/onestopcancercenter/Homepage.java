package com.onestopcancercenter.onestopcancercenter;

<<<<<<< HEAD
=======
import android.content.Intent;
>>>>>>> ربط في المنيو و ليست لسيرش و الفيو في كانسر تايب
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class Homepage extends AppCompatActivity implements AdapterView.OnItemClickListener {

    DatabaseHelper DB;
    Cursor result;
    ListView lv;
    SearchView sv;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        String dbLocation = "/data/data/" + Homepage.this.getPackageName() + "/databases/";

        File Dir = new File(dbLocation);
        if (!Dir.mkdirs())
        {
            Log.e("DB","can not find the dir");
        }

        // T1.setText(Dir.getPath());
        DB = new DatabaseHelper(Homepage.this, dbLocation);
        DB.close();

        Log.d("print","pass new Databasehelper call");
        if (DB.checkDataBase())
            result = DB.getTableData("CancerType");
        else return;
        int n = result.getCount();
        String[] list=new String[n];
        int i=0;
       while (!result.isLast()&&i<n)
       {
            result.moveToNext();
            list[i++] = result.getString(1);

       }


        lv = (ListView) findViewById(R.id.listviewHP);
        sv = (SearchView) findViewById(R.id.searchView);
        aa = new  ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(this);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
<<<<<<< HEAD

            @Override
            public boolean onQueryTextChange(String s) {

=======

            @Override
            public boolean onQueryTextChange(String s) {

>>>>>>> ربط في المنيو و ليست لسيرش و الفيو في كانسر تايب
                aa.getFilter().filter(s);
                return false;
            }

        });

<<<<<<< HEAD
=======


>>>>>>> ربط في المنيو و ليست لسيرش و الفيو في كانسر تايب
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView tv = (TextView) view;
<<<<<<< HEAD
        Toast.makeText(this, "you clicked item #"+i+ tv.getText(),Toast.LENGTH_SHORT).show();
=======
       // Toast.makeText(this, "you clicked item #"+i+ tv.getText(),Toast.LENGTH_SHORT).show();
       Intent intent =  new Intent(Homepage.this, List_of_Hospitals.class);
        String CN = (String) tv.getText(); // to Send data from thoer activitiy
        intent.putExtra("CN", CN);
        startActivity(intent);

>>>>>>> ربط في المنيو و ليست لسيرش و الفيو في كانسر تايب
    }
}
