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
//����ǰ���ҳ��Ҫչʾ��ʲô���ӵ�Fragment ��Ƭ�ǿ��Ա�ɸ��ָ�����Ч����
	@Override
	//int ����ǰҳ��ҳ��
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		//Log.e("adapter", "��ǰҳ��λ�ã�"+arg0);(��ӡ��־����ʾҳ��)
		//Fragment fragment = new Fragment();
		//��ҳ��arg0���ݵ�Fragment��ȥ
		MyFragment fragment1 = new MyFragment();
		//�������ݴ���ȥ  Bundle Ϊʲô��ֱ����int
		Bundle bundle = new Bundle();
		bundle.putInt("position", arg0);
		//key ����������ݵı�ǩ����
		fragment1.setArguments(bundle);
		return fragment1;
		
	}
//���������ж���ҳ���Է�
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//return���پ��Ƕ���ҳ
		return titles.length;
	}
	//������������if�����ʾ������
String[] titles = new String[]{"����","����","üë","�۾�","���","����","�۾�","�·�","����","����"};

	public CharSequence getPageTitle(int position){
	return titles[position];
		
		
	}
	
	
}
