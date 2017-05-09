package cn.edu.qzu.face;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��ʱ��תʹ�ö�ʱ��
        Timer timer =new Timer();
        TimerTask timerTask =new TimerTask() {
			
			@Override
			public void run() {
				// RUN��������Ĵ���ͻ��ʱ��ȥִ��
				//ת��ҳ��Activity
				 Intent intent = new Intent();
				 //�ƶ�ϵͳת����SexActivity��
			        intent.setClass(MainActivity.this, SexActivity.class);
			        startActivity(intent);
			        //�رյ�ǰҳ��
			        finish();
			}
		};
        timer.schedule(timerTask,2000);
      
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
