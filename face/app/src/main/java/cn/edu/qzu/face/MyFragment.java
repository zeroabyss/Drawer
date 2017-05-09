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
//����Fragment��չʾЧ��
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//���յ�ҳ�룬���������ҳ�������ز�һ����View�ؼ���ȥ
		Bundle ����� = getArguments();
		int position = �����.getInt("position");
		// TODO Auto-generated method stub
		//���ֿؼ����Ǽ̳���View
		//��������ؼ�      ���ص�����ؼ���ʲô���ӣ���ôFragment�ͳ�ʲô����
		/*TextView tv = new TextView(getActivity());
		//ͨ�����������ÿؼ���һЩЧ��
		tv.setText("��"+position);
		tv.setTextSize(40);
		*/
		
		//����ҳ�룬��ö�Ӧҳ���ϵ�ͼƬ��Դ����
		//����һ��int���飬����ͼƬ��Դ��ַid����
		int[] resIds= new int[]{}; 
		
		switch (position) {
		case 0:
			// boy�ķ��͵�ͼƬ��ַid����
			resIds = MyRes.getBoyHair();
			break;
		case 1:
			// ���͵�ͼƬ��ַid����
			resIds = MyRes.getFaceShape();
			break;
		case 2:
			// üë��ͼƬ��ַid����
			resIds = MyRes.getEyeBrow();
			break;
		case 3:
			// �۾���ͼƬ��ַid����
			resIds = MyRes.getEye();
			break;
		case 4:
			// ��͵�ͼƬ��ַid����
			resIds = MyRes.getMouth();
			break;
		case 5:
			// boy������ͼƬ��ַid����
			resIds = MyRes.getFeature();
			break;
		case 6:
			// �۾�ͼƬ��ַid����
			resIds = MyRes.getGlass();
			break;
		case 7:
			// boy�·�ͼƬ�ĵ�ַid����
			resIds = MyRes.getBoyClothes();
			break;
		case 8:
			// ����ͼƬ��ַid����
			resIds = MyRes.getBackGround();
			break;
		case 9:
			// ����ͼƬ��ַid����
			resIds = MyRes.getPop();
			break;
		default:
			break;
		}
		//�������Ӧ��Դ���鴫�ݵ�Adapter
		
		
		//����ؼ�GridLayout
		GridView gv = new GridView(getActivity());
		//��������ؼ�������
		gv.setNumColumns(3);
		//��������ؼ�������
		//��Adapter�ŵ�JAVA�ļ���д
		MyGridAdapter grid = new MyGridAdapter(resIds);
		gv.setAdapter(grid);
		
		return gv;
	}
	
}
