package com.onestopcancercenter.onestopcancercenter;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MaintainDB extends AppCompatActivity {

    DatabaseHelper DB;
    Cursor result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_db);

        final Button  CopyDBB = (Button) findViewById(R.id.CopyDB);
        final Button  CheckReadB = (Button) findViewById(R.id.CheckRead);
        final Button  DeleteDBB = (Button) findViewById(R.id.DeleteDB);


        final TextView T1 = (TextView)  findViewById(R.id.textView12);
        final TextView T2 = (TextView)  findViewById(R.id.textView13);

        String dbLocation = "/data/data/" + MaintainDB.this.getPackageName() + "/databases/";

        File Dir = new File(dbLocation);
        if (!Dir.mkdirs())
        {
            Log.e("DB","can not find the dir");
        }

       // T1.setText(Dir.getPath());
        DB = new DatabaseHelper(MaintainDB.this, dbLocation);
        DB.close();

         Log.d("print","pass new Databasehelper call");
        CopyDBB.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

               // Toast.makeText(MaintainDB.this,"Try it!", Toast.LENGTH_LONG).show();
               //  MaintainDB.this.getDatabasePath();


                try
                {
                    DB.prepareDatabase();
                }
                catch(
                        IOException e)

                {
                    e.printStackTrace();
                   // Toast.makeText(MaintainDB.this,"not copied", Toast.LENGTH_LONG).show;

                }


            }
        });

     CheckReadB.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             if (DB.checkDataBase())
             {
                 Log.d("print","pass CheckReadDB");

                 result = DB.getTableData("CancerType");
                 Log.d("print","pass gettabledata");

                 if (!(result.isLast()))
                 if (result.moveToNext())
                 {
                    T1.setText(result.getString(0));
                    T2.setText(result.getString(1));
                   //  Log.d("print",result.getString(0));
                   //  Log.d("print",result.getString(1));



                 }
             }



         }
     });

     DeleteDBB.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             DB.close();
             DB.deleteDb();
         }
     });
    }
}
