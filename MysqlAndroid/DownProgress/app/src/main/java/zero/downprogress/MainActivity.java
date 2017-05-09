package zero.downprogress;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button start;
    private Button stop;
    private MyService.DownBinder downBinder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downBinder= (MyService.DownBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start= (Button) findViewById(R.id.start);
        stop= (Button) findViewById(R.id.stop);
        Intent i=new Intent(this,MyService.class);
        startService(i);
        bindService(i,connection,BIND_AUTO_CREATE);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downBinder==null){
                    Log.d(TAG, "onClick1: ");
                    return;
                }
                String url="http://xiazai.kugou.com/Corp/kugou7_3761.exe";
                downBinder.startDownload(url);
                Log.d(TAG, "onClick: ");
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downBinder==null){
                    return;
                }
                downBinder.pauseDownload();
            }
        });
    }

}
