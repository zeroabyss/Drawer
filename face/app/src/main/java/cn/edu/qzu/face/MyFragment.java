package cn.edu.qzu.face;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

public class MyFragment extends Fragment {
//控制Fragment的展示效果
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//接收到页码，在这里根据页码来返回不一样的View控件出去
		Bundle 电冰箱 = getArguments();
		int position = 电冰箱.getInt("position");
		// TODO Auto-generated method stub
		//各种控件都是继承自View
		//返回任意控件      返回的这个控件长什么样子，那么Fragment就长什么样子
		/*TextView tv = new TextView(getActivity());
		//通过代码来设置控件的一些效果
		tv.setText("大海"+position);
		tv.setTextSize(40);
		*/
		
		//根据页码，获得对应页面上的图片资源数组
		//声明一个int数组，代表图片资源地址id集合
		int[] resIds= new int[]{}; 
		
		switch (position) {
		case 0:
			// boy的发型的图片地址id集合
			resIds = MyRes.getBoyHair();
			break;
		case 1:
			// 脸型的图片地址id集合
			resIds = MyRes.getFaceShape();
			break;
		case 2:
			// 眉毛的图片地址id集合
			resIds = MyRes.getEyeBrow();
			break;
		case 3:
			// 眼睛的图片地址id集合
			resIds = MyRes.getEye();
			break;
		case 4:
			// 嘴巴的图片地址id集合
			resIds = MyRes.getMouth();
			break;
		case 5:
			// boy的特征图片地址id集合
			resIds = MyRes.getFeature();
			break;
		case 6:
			// 眼镜图片地址id集合
			resIds = MyRes.getGlass();
			break;
		case 7:
			// boy衣服图片的地址id集合
			resIds = MyRes.getBoyClothes();
			break;
		case 8:
			// 背景图片地址id集合
			resIds = MyRes.getBackGround();
			break;
		case 9:
			// 气泡图片地址id集合
			resIds = MyRes.getPop();
			break;
		default:
			break;
		}
		//将这个对应资源数组传递到Adapter
		
		
		//网格控件GridLayout
		GridView gv = new GridView(getActivity());
		//设置网格控件的列数
		gv.setNumColumns(3);
		//设置网格控件的数据
		//把Adapter放到JAVA文件里写
		MyGridAdapter grid = new MyGridAdapter(resIds);
		gv.setAdapter(grid);
		
		return gv;
	}
	
}
