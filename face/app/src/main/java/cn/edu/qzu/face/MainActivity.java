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
        //延时跳转使用定时器
        Timer timer =new Timer();
        TimerTask timerTask =new TimerTask() {
			
			@Override
			public void run() {
				// RUN方法里面的代码就会别定时的去执行
				//转跳页面Activity
				 Intent intent = new Intent();
				 //制定系统转跳到SexActivity中
			        intent.setClass(MainActivity.this, SexActivity.class);
			        startActivity(intent);
			        //关闭当前页面
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
