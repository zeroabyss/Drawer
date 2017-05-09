package zero.swe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button send;
    private EditText msgEt;
    private MsgAdapter msgAdapter;
    private List<Msg> msgList=new ArrayList<Msg>();

    private void initMsgs(){
        Msg msg1=new Msg("hello",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2=new Msg("who?",Msg.TYPE_SEND);
        msgList.add(msg2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();
        msgAdapter=new MsgAdapter(MainActivity.this,R.layout.list_item,msgList);

        msgEt= (EditText) findViewById(R.id.input_text);
        send= (Button) findViewById(R.id.send);
        listView= (ListView) findViewById(R.id.msg_list_view);
        listView.setAdapter(msgAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Msg sendText=new Msg(msgEt.getText().toString(),Msg.TYPE_SEND);
                msgList.add(sendText);
                msgAdapter.notifyDataSetChanged();
                listView.setSelection(msgList.size());
                msgEt.setText("");
            }
        });

    }
}
