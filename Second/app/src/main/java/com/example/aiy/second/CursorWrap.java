package com.example.aiy.second;

import android.database.CursorWrapper;

import com.example.aiy.second.Datababse_Values.Table;

import java.util.UUID;


/**
 * Created by Aiy on 2016/12/4.
 */

public class CursorWrap extends CursorWrapper {

    public CursorWrap(android.database.Cursor cursor) {
        super(cursor);
    }

    public Person getPerson(){
        int num=getInt(getColumnIndex(Table.cols.NUM));
        String name=getString(getColumnIndex(Table.cols.NAME));

        Person person=new Person(num,name);
        return person;
    }
}
