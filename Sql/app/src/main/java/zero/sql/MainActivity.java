package zero.sql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private MySql mySql;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt= (Button) findViewById(R.id.button);
        mySql=new MySql(this,2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database=mySql.getWritableDatabase();
            }
        });
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database=mySql.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("num",1);
                values.put("name","yihao");
                values.put("price",2.3);
                database.insert("book",null,values);

            }
        });
        findViewById(R.id.insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database=mySql.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name","text");
                database.update("book",values,"id=?",new String[]{Integer.toString(1)});
            }
        });
    }
}
