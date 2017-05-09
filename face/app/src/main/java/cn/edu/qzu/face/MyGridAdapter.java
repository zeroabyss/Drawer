package cn.edu.qzu.face;

import android.provider.ContactsContract.CommonDataKinds.Im;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyGridAdapter extends BaseAdapter {
	int[]resIds;
	public MyGridAdapter(int[] a){
		resIds=a;
	}
	
	
//int 代表有多少个网格
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		
		return resIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
//返回的是一个View
	//View是任意控件都可以，返回的这个控件长什么样子，对应的这个格子就长什么样子
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//TextView tv = new TextView(parent.getContext());
		//tv.setText("第"+position+"格子");
		
		//在ImageView图片控件的外面套一个相对布局，给相对布局设置带边框的背景
		//最后将相对布局进行返回出去
		RelativeLayout rl = new RelativeLayout(parent.getContext());
		rl.setBackgroundResource(R.drawable.gridview_item_selector);
		
		ImageView iv = new ImageView(parent.getContext());
		//根据position加载不一样的图片
		//通过制作一个存放各个图片的资源地址的数组，来写不同的图片
		//静态：类名。方法名（）；
		//非静态类的实例。方法名（）；new对象（）
		iv.setImageResource(resIds[position]);
		//iv.setImageResource(R.drawable.pic_rs1_28);
		//将ImageView添加到相对布局中
		//设置一个属性给相对布局，让其添加时能够居中
		//通过LayoutParams（布局参数）来进行居中
		//设置宽和高为WrapContent(定值，默认为-2)
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		//添加居中的规则Rule
		lp.addRule(RelativeLayout.CENTER_IN_PARENT);
		rl.addView(iv,lp);
		return rl;
	}

}
