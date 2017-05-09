package com.example.aiy.crime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aiy.crime.CrimeDbschema.CrimeTable;

/**
 * Created by Aiy on 2016/12/3.
 */

public class CrimeBaseHelper extends SQLiteOpenHelper {//创建数据库和更新数据库用
    private static final int VERSION=1; //版本号
    private static final String DATABASE_NAME="crimeBase.db";//数据库文件名

    public CrimeBaseHelper(Context context){//构造方法
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//创建数据库
        db.execSQL("create table " + CrimeTable.NAME + "("+ //SQL语句
                " _id integer primary key autoincrement, "+
                CrimeTable.Cols.UUID + ", "+
                CrimeTable.Cols.TITLE + ", "+
                CrimeTable.Cols.DATE + ", "+
                CrimeTable.Cols.SOLVED +", "+
                CrimeTable.Cols.SUSPECT+
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
