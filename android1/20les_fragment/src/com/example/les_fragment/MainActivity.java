package com.example.les_fragment;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * fragment ����Ļ�����ֹ���
 * ��Ƭ
 * �����ֻ�ƽ����Ļ�ܴ� ����
 * 1�����ٹ��̿�������
 * 2�����ٵ���������Ա����
 * 3����߽���֮����ϳ̶�
 * 4�����ػ�
 * sw-600dp����Ļ��С�ı߾���
 * 5�������ƶ�,�滻�ֲ����
 * 	fragment��ջ
 * 
 * 6��fragment�������� ��activity���������ڷ��� ����ִ�� �ȴ���fragment ������fragment
 * 3.0�Ժ����  ��android3.0֮�����ƽ��
 * ����
 * 1��ȷ����Ļ����״��
 * 2��������Ļ����ָ��fragment��ǩ
 * 3��ָ��fragment��ʾ���루��ʾ���ݣ�
 * 4��fragment��ǩ�����Ӧ
 * 
 * �������fragment�������getActivity��������
 * ��ʾ������fragment����activity����
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}
