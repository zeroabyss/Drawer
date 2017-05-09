package zero.first;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Log.e("e",msg.obj.toString());
                    if ((Integer)msg.obj==5){
                    pb.setVisibility(View.INVISIBLE);
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pb= (ProgressBar) findViewById(R.id.pb);


        findViewById(R.id.sy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent("1");
//                i.addCategory("sy");
//                i.putExtra("zero","zero");
//                startActivityForResult(i,1);

//                if (pb.getVisibility()==View.VISIBLE){
//                    pb.setVisibility(View.GONE);
//                }else{
//                    pb.setVisibility(View.VISIBLE);
//                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i=0;
                        try{
                            while (i<5){
                                i++;
                                Thread.sleep(1000);
                                Log.e("s",i+"");
                                Message message=new Message();
                                message.what=1;
                                message.obj=i;
                                handler.sendMessage(message);
                            }


                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String s=data.getStringExtra("zeros");
                    Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
                }else if (resultCode==RESULT_CANCELED){
                    String s=data.getStringExtra("zeros");
                    Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
                }else if (resultCode==12) {
                    String s = data.getStringExtra("zeros");
                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }*/
}
