package cn.edu.qzu.face;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class SexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sex);
		//让两张图片执行位移动画（从两边向中间靠拢）
		//1准备出展示该图片的对象出来
		ImageView iv_man =(ImageView)findViewById(R.id.iv_man);
		ImageView iv_woman =(ImageView)findViewById(R.id.iv_woman);
		//1.1准备出动画对象出来
		TranslateAnimation animMan = new TranslateAnimation(-150, 0,0,0);
		TranslateAnimation animWoman = new TranslateAnimation(150, 0,0,0);
		
		//给动画设置持续时间
		animMan.setDuration(1000);
		animWoman.setDuration(1000);
		
		//2对这两个控件去设置动画进行播放
		iv_man.startAnimation(animMan);
		iv_woman.startAnimation(animWoman);
		
		//给帅哥按钮设置点击的监听
		//1拿控件对象（已经做过）
		//2给他设置点击
		iv_man.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SexActivity.this, DesignActivity.class);
				startActivity(intent);
			}
		});
		
		//给美女按钮设置点击的监听
		iv_woman.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SexActivity.this, DesignActivity.class);
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sex, menu);
		return true;
	}

}
