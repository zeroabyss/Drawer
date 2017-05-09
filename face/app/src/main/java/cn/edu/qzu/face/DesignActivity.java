package cn.edu.qzu.face;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
//��Ҫ�̳�Activity,Ҫȥ�̳�FragmentActivity  Ӱ��MypagerAdapter�����getSupporFramentManager
public class DesignActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_design);
		//���÷�ҳ���еķ�ҳ����
		//1�ҿؼ�
		ViewPager vp = (ViewPager)findViewById(R.id.vp);
		//2���ؼ���������  Adapter ������ �������������䵽�ؼ�
		//ʹ��FragmentPagerAdapter ��Ƭ����������
		//������Adapter�н�������
		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
		vp.setAdapter(adapter);
		
		//1�ҵ�����ؼ�
		PagerSlidingTabStrip pagerTab = (PagerSlidingTabStrip)findViewById(R.id.pagerTab);
		//1+�޸ı���ؼ�����ʽ
		pagerTab.setTextSize(20);
		pagerTab.setIndicatorHeight(4);
		pagerTab.setIndicatorColor(Color.parseColor("#0179FF"));
		//׼��һ������������ɫ��ѡ����
		pagerTab.setTextColorResource(R.color.bg_text_color_selector);
		pagerTab.setViewPager(vp);
		
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.design, menu);
		return true;
	}

}
