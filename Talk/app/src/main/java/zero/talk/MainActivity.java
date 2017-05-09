package zero.talk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Msg> list=new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        final EditText msg1= (EditText) findViewById(R.id.edit);
        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new Adapter(list);
        recyclerView.setAdapter(adapter);
        findViewById(R.id.bt_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Msg msg=new Msg(msg1.getText().toString(),Msg.TYPE_SEND);
                list.add(msg);
                adapter.notifyItemChanged(list.size()-1);

            }
        });
    }
    void init(){
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVE);
        list.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SEND);
        list.add(msg2);
        Msg msg3 = new Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVE);
       list.add(msg3);
    }
}
