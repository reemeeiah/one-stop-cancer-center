package com.onestopcancercenter.onestopcancercenter;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DatabaseHelper extends SQLiteOpenHelper{

    private final Context myContext ;
    private String pathToSaveDBFile ;

    public static final String  databaseName= "OneStopCancerCenter.db";
    public static final int   databaseVersion= 1;
    public static final String  TAG= "databaseHelper";



    public DatabaseHelper (Context context , String filePath ) {

        super (context , databaseName ,  null , databaseVersion ) ;
        this.myContext = context ;

        pathToSaveDBFile = filePath+ databaseName ;





    }




    public boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {

            checkDB=SQLiteDatabase.openDatabase(pathToSaveDBFile,null,SQLiteDatabase.OPEN_READONLY);

            Log.e("", "Database checked.");

        } catch(SQLiteException e) {

            Log.e(TAG, e.getMessage());

        }
        return checkDB !=null ? true : false;
    }



    public void prepareDatabase() throws
            IOException {
        boolean dbExist = checkDataBase();
        if(dbExist) {
            Log.d(TAG, "Database exists.");

            Toast.makeText(myContext, "قاعدة البيانات موجودة ", Toast.LENGTH_SHORT).show();
        } else {
            try {
                copyDataBase();

                Log.d(TAG, "Database copied.");
            } catch (IOException e) {

                Log.d(TAG, e.getMessage());
            }
        }
    }

    private void copyDataBase() throws IOException {


        OutputStream os = new FileOutputStream(pathToSaveDBFile);

        InputStream is = myContext.getApplicationContext().getAssets().open(databaseName);
        byte[] buffer = new byte[1024];
        int length=0;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        is.close();
        os.flush();
        os.close();
        Toast.makeText(myContext, " تم جلب قاعدة البيانات" , Toast.LENGTH_LONG).show();
    }
    public void deleteDb() {
        File file = new File(pathToSaveDBFile);
        if(file.exists()) {

            file.delete();
            Log.d(TAG, "Database deleted.");
            Toast.makeText(myContext,"تم حذف قاعدة البيانات ",Toast.LENGTH_SHORT).show();
        }
    }





    @Override
    public void onCreate(SQLiteDatabase db) {


        // db = this.getWritableDatabase();



    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
