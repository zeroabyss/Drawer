package com.example.aiy.crime;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.aiy.crime.CrimeDbschema.CrimeTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Aiy on 2016/12/3.
 */

public class CrimeCursorWrapper extends CursorWrapper {//指标
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Crime getCrime(){//当指标确定位置后 创建一个crime 把指标里面的所有变量赋给crime 相当于查询crime
        String uuidString =getString(getColumnIndex(CrimeTable.Cols.UUID));//从指标取出uuid
        String titleSting =getString(getColumnIndex(CrimeTable.Cols.TITLE));//同
        long dateString =getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int solvedString =getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspectString=getString(getColumnIndex(CrimeTable.Cols.SUSPECT));

        Crime crime=new Crime(UUID.fromString(uuidString));
        //创建crime formString是把uuidString格式化成uuid
        crime.setDate(new Date(dateString));
        //此时时间是long 所以要新建Date类
        crime.setTitle(titleSting);
        crime.setSolved(solvedString!=0);
        //因为取出来的checkbox不是boolean 而是int，所以
        crime.setSuspect(suspectString);
        return crime;
    }
}
