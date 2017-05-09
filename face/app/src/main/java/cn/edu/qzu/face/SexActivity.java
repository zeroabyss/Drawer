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
		//������ͼƬִ��λ�ƶ��������������м俿£��
		//1׼����չʾ��ͼƬ�Ķ������
		ImageView iv_man =(ImageView)findViewById(R.id.iv_man);
		ImageView iv_woman =(ImageView)findViewById(R.id.iv_woman);
		//1.1׼���������������
		TranslateAnimation animMan = new TranslateAnimation(-150, 0,0,0);
		TranslateAnimation animWoman = new TranslateAnimation(150, 0,0,0);
		
		//���������ó���ʱ��
		animMan.setDuration(1000);
		animWoman.setDuration(1000);
		
		//2���������ؼ�ȥ���ö������в���
		iv_man.startAnimation(animMan);
		iv_woman.startAnimation(animWoman);
		
		//��˧�簴ť���õ���ļ���
		//1�ÿؼ������Ѿ�������
		//2�������õ��
		iv_man.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(SexActivity.this, DesignActivity.class);
				startActivity(intent);
			}
		});
		
		//����Ů��ť���õ���ļ���
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
