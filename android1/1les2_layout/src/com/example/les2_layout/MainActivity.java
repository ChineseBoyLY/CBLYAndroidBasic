package com.example.les2_layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
/**
 * src	Դ����Ŀ¼
 * gen	R�ļ�ӳ����ԴID���Զ����ɣ�
 * assets	��ԴĿ¼ ���ᱻ����
 * res		��ԴĿ¼ �ᱻ����
 * 	drawable ͼƬ
 * 	layout	�����ļ�
 * 	menu	�˵�����
 * 	values	
 * 		string.xml �ַ���
 * 		style.xml	��ʽ�ļ�
 * 		dimens.xml	����ߴ���Դ
 * ���� ����Ԫ�س�������Ļ��λ��
 * 
 * ��λ sp dip  
 * 
 * 1�����Բ���
 * 	��ֱ�ߵķ���ȷ��Ԫ������λ�� 
 * 	Ĭ�Ϸ���ˮƽ
 * android:orientation ָ�����Բ��ֵ��Ų�����	vertical horizontal
 * ��ͼ������԰�����ͼ �����������Ƕ�ײ��� �����Ⲽ�֣�
 * 
 * 2����Բ���
 * 		��������Ԫ��λ�ö�������������ؼ���λ��
 * 		���û�и�Ԫ��ָ���κ�λ����Ϣ��Ĭ�ϻ��������Ļ�����϶���
 * 		android:layout_above=""
 * 		android:layout_below=""
 * 		android:layout_toRightOf=""
 * 		android:layout_toLeftOf=""
 * 3�����Բ���
 * 		������Ļ������ϵȷ��Ԫ��λ��
 * 4��֡����
 * 		ÿ��Ԫ�ض��ǵ�����һ֡,ͨ�������븸�������߽����
 * 		marginBottom �ӿؼ��ı߿��븸���������루�ײ�
 * 		layout_marg һ��ָ�����������ĸ�����
 * 5����񲼾�
 * 		ͨ���������п���Ԫ��λ��
 * 		��������ȷ��
 * 		ȷ���������ж��ٸ��ӱ�ǩ���ж����У������ӱ�ǩ����ȷ������
 * 		ȷ��������ÿ��<TableRow>�����м���Ԫ�أ��м���
 * 6�����񲼾� 4.0 �Ժ�
 * ��ҵ������������1-9��ť
 * ���벼��
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.absolte_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
