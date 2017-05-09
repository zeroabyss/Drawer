package com.example.aiy.second;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aiy.second.Datababse_Values.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Aiy on 2016/12/4.
 */

public class Person_Lib {
    private static Person_Lib personLib;
    private Context context;
    private SQLiteDatabase database;

    public static Person_Lib getPersonLib(Context context){
        if (personLib==null){
            personLib=new Person_Lib(context);
        }
        return personLib;
    }
    private Person_Lib(Context context){
        database=new Database_db(context).getWritableDatabase();
    }

    private CursorWrap query(String IF, String[] IF_num){
        Cursor cursor=database.query(
                Table.TABLE_NAME,
                null,
                IF,
                IF_num,
                null,
                null,
                null
        );
        return new CursorWrap(cursor);
    }

    public List<Person> getList(){
        List<Person> list=new ArrayList<>();
        CursorWrap cursor=query(null,null);
        try {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                list.add(cursor.getPerson());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return list;
    }

  /*  public Person getPerson(int num){
        Cursor cursor=database.rawQuery("select * from manage where num=?",
                new String[]{Integer.toString(num)});

    }*/
    public Person getStudent(int num) {
        CursorWrap cursor=query(Table.cols.NUM+" = ?",
                new String[] { String.valueOf(num)});
        try{
            if(cursor.getCount()==0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getPerson();
        }finally {
            cursor.close();
        }
    }

    private static ContentValues getValuse(Person person){
        ContentValues values=new ContentValues();
        values.put(Table.cols.NUM,person.getNum());
        values.put(Table.cols.NAME,person.getName());
        return values;
    }

    public void addPerson(Person person){
        ContentValues values=getValuse(person);
        database.insert(Table.TABLE_NAME,null,values);
    }

}
