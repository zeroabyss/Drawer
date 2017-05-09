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
	
	
//int �����ж��ٸ�����
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
//���ص���һ��View
	//View������ؼ������ԣ����ص�����ؼ���ʲô���ӣ���Ӧ��������Ӿͳ�ʲô����
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//TextView tv = new TextView(parent.getContext());
		//tv.setText("��"+position+"����");
		
		//��ImageViewͼƬ�ؼ���������һ����Բ��֣�����Բ������ô��߿�ı���
		//�����Բ��ֽ��з��س�ȥ
		RelativeLayout rl = new RelativeLayout(parent.getContext());
		rl.setBackgroundResource(R.drawable.gridview_item_selector);
		
		ImageView iv = new ImageView(parent.getContext());
		//����position���ز�һ����ͼƬ
		//ͨ������һ����Ÿ���ͼƬ����Դ��ַ�����飬��д��ͬ��ͼƬ
		//��̬��������������������
		//�Ǿ�̬���ʵ����������������new���󣨣�
		iv.setImageResource(resIds[position]);
		//iv.setImageResource(R.drawable.pic_rs1_28);
		//��ImageView��ӵ���Բ�����
		//����һ�����Ը���Բ��֣��������ʱ�ܹ�����
		//ͨ��LayoutParams�����ֲ����������о���
		//���ÿ�͸�ΪWrapContent(��ֵ��Ĭ��Ϊ-2)
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		//��Ӿ��еĹ���Rule
		lp.addRule(RelativeLayout.CENTER_IN_PARENT);
		rl.addView(iv,lp);
		return rl;
	}

}
