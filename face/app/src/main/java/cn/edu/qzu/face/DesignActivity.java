package cn.edu.qzu.face;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
//不要继承Activity,要去继承FragmentActivity  影响MypagerAdapter里面的getSupporFramentManager
public class DesignActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_design);
		//设置翻页空闲的翻页数据
		//1找控件
		ViewPager vp = (ViewPager)findViewById(R.id.vp);
		//2给控件设置数据  Adapter 适配器 用来将数据适配到控件
		//使用FragmentPagerAdapter 碎片数据适配器
		//数据在Adapter中进行设置
		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
		vp.setAdapter(adapter);
		
		//1找到标题控件
		PagerSlidingTabStrip pagerTab = (PagerSlidingTabStrip)findViewById(R.id.pagerTab);
		//1+修改标题控件的样式
		pagerTab.setTextSize(20);
		pagerTab.setIndicatorHeight(4);
		pagerTab.setIndicatorColor(Color.parseColor("#0179FF"));
		//准备一个关于字体颜色的选择器
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
