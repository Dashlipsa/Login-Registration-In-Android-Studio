package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String db_name="demo_db";
    private static final int db_version=1;
    public DbHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_query="create table register(id integer primary key autoincrement,name text,email text,password text ,gender text)";
        sqLiteDatabase.execSQL(create_table_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists register");
        onCreate(sqLiteDatabase);
    }
    public boolean registerUserHelper(String name,String email,String pswd,String gen){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("password",pswd);
        contentValues.put("gender",gen);

        long l=sqLiteDatabase.insert("register",null,contentValues);
        sqLiteDatabase.close();
        if (l>0){
            return true;
        }
        else {
            return false;
        }
    }
    boolean logedin;
    public boolean login(String email,String pass){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from register where email='"+email+"'and password='"+pass+"'",null);
        if (cursor.moveToFirst()){
            logedin=true;
        }else {
            logedin=false;
        }
        return logedin;
    }
}
