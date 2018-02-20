package com.onestopcancercenter.onestopcancercenter;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class db_sqillite extends SQLiteOpenHelper{
    public static final String Dbname= "reemeeiah";
    public static final String Dblocation= Environment.getDataDirectory()+"/data/ com.onestopcancercenter.onestopcancercenter/database";
    private  Context mContext;
    private  SQLiteDatabase mDatabase;
    public db_sqillite(Context context) {
        super(context, Dbname, null, 1);
        this.mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

public  void openDatabase(){
   String dbpath=mContext.getDatabasePath(Dbname).getPath();
   if(mDatabase!=null && mDatabase.isOpen()){
       return;}
mDatabase=SQLiteDatabase.openDatabase(dbpath,null,SQLiteDatabase.OPEN_READWRITE);}


public void  closeDatabase(){
    if (mDatabase!=null){

        mDatabase.close();
    }}


}
