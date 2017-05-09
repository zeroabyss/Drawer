package zero.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aiy on 2017/3/5.
 */

public class MySql extends SQLiteOpenHelper {

    private static final int version=1;//初始版本号
    private static final String DbName="book_manage.db";

    public MySql(Context context,int version) {
        super(context, DbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table book(" +
                        "id integer primary key autoincrement," +
                        "name text," +
                        "num integer," +
                        "price real" +
                        ")"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(catory);
        switch (oldVersion){
            case 1:
                //如果是版本号1的话如何变化
            case 2:
                //如果是版本号2的话如何变化
            default:
        }
    }

    private static final String catory="create table catory(" +
            "id integer primary key autoincrement," +
            "catory_name text," +
            "catory_code integer)";

}
