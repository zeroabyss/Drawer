package com.example.aiy.second;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button denglu;
    private EditText editText_id;
    private EditText getEditText_password;
    private TextView tv1;
    private TextView tv2;
    Person person1=new Person(1,"a");
    Person person2=new Person(2,"b");
    Person person3=new Person(3,"c");
    private List<Person> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Person_Lib.getPersonLib(this).addPerson(person1);
        Person_Lib.getPersonLib(this).addPerson(person2);
        Person_Lib.getPersonLib(this).addPerson(person3);
        denglu=(Button)findViewById(R.id.Main_Button);
        editText_id=(EditText)findViewById(R.id.Main_Edit_ID);
        getEditText_password=(EditText)findViewById(R.id.Main_Edit_Password);

        list=Person_Lib.getPersonLib(this).getList();

        tv1=(TextView)findViewById(R.id.Id_TextView);
        tv2=(TextView)findViewById(R.id.Id_TextView2);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person=Person_Lib.getPersonLib(MainActivity.this).getStudent(2);
                tv1.setText(person.getName());
                tv2.setText(person.getNum()+"");
            }
        });

    }
}
