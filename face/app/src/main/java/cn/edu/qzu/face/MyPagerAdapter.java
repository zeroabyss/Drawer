package cn.edu.qzu.face;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class MyPagerAdapter extends FragmentPagerAdapter {

	public MyPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
//代表当前这个页面要展示成什么样子的Fragment 碎片是可以变成各种各样的效果的
	@Override
	//int 代表当前页的页码
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		//Log.e("adapter", "当前页码位置："+arg0);(打印日志，显示页码)
		//Fragment fragment = new Fragment();
		//将页码arg0传递到Fragment中去
		MyFragment fragment1 = new MyFragment();
		//设置数据传过去  Bundle 为什么不直接是int
		Bundle bundle = new Bundle();
		bundle.putInt("position", arg0);
		//key 代表这个数据的标签名字
		fragment1.setArguments(bundle);
		return fragment1;
		
	}
//用来设置有多少页可以翻
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//return多少就是多少页
		return titles.length;
	}
	//用数组来代替if语句显示标题栏
String[] titles = new String[]{"发型","脸型","眉毛","眼睛","嘴巴","特征","眼镜","衣服","背景","气泡"};

	public CharSequence getPageTitle(int position){
	return titles[position];
		
		
	}
	
	
}
