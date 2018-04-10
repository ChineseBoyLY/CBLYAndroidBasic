package com.example.les_data1;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

/**
 * oracle number
 * sqlserver int money
 * mysql	int integer
 * sqlite�ٷ���վȷ����������  �а汾����
 * ���ݴ洢 �ṩ���ֽ������
 * 1���Լ�ֵ�Ե���ʽ�洢����    sharedPreferences
 * 2���ֻ��ڴ�洢                         io
 * 3���ⲿĿ¼�Ĵ洢
 * 4��SQLite Databases ���ݿ� ���㷺Ӧ�����ƶ��ն��豸 Android ios ���� wp8...
 * 		���������ݿ�     sqlserver  mysql
 * 5���Ʒ��� 
	SQLiteDatabase ÿ�����ݿ��ļ���Ӧһ�������Ķ���
	���ݿ��ļ�����Ŀ¼
	data/data/Ӧ�ó������/databases/���ݿ��ļ�
	
	���ִ������ݿⷽʽ
	sqliteOpenHelper ���� �������ݺʹ�����
	getReadableDatabase �����ݿ�����
		��������Ѿ�д����ֻ�᷵��ֻ�������ݿ��������
	getWriteableDatbase �����ݿ�����
		��������Ѿ�д��������ΪȨ������ᵼ�²��������������ݿ��������
	sqlite3 ��������  .exit�˳���ǰ�༭����
	.tables �鿴���ݿ��ļ��������б�
	Cursor �α�
	
	main Thread���߳�   ֻҪ��activity����ķ��� �����������߳�
	
	1������������
	2����������
	3���α������� ��ҵ
	4���Զ���������
	
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	SQLiteDatabase sqlite=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//������  ֻ����ContextWrapper�������д�  �������ߴ�һ�����ݿ�����
		//������ݿ��Ѿ����ھʹ����ݿ� ������ݿⲻ���ھʹ���һ�����ݿ�
		//1�����ݿ������2�����ݿ�ķ���ģʽ3���α깤��  �α�����ResultSet
	/*	SQLiteDatabase sqlite=openOrCreateDatabase("stu", MODE_PRIVATE, null);
		//������
		String sql="create table stuinfo(humanid int primary key,humanname varchar(10))";
		//sqlite.execSQL(sql);
		
		sql="insert into humaninfo values(1,'�ǵ�')";
		
		//�������ݿ�
		//sqlite.execSQL(sql);
		
		//��ѯ����
		sql="select * from stuinfo";
		//sqlite.query(distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit, cancellationSignal)
		Cursor cursor=sqlite.rawQuery(sql, null);
		if(cursor.moveToFirst()){
			do {
				Log.d("TAG",""+cursor.getString(1));
			} while (cursor.moveToNext());
		}*/
	}

	public void btnClick(View view){
		
		if(view.getId()==R.id.btnCreate){
			//�������ݿ�
			MyDbHelper helper=new MyDbHelper(this,"bookdb",null,2);
			//�Ƿ�����
			sqlite=helper.getReadableDatabase();
		}else if(view.getId()==R.id.btnadd){
			String sql="insert into bookinfo values(1,'С����')";
			sqlite.execSQL(sql);
		}else if(view.getId()==R.id.btndel){
			//ɾ��
			String sql="delete from bookinfo where bookid=1";
			sqlite.execSQL(sql);
		}else if(view.getId()==R.id.btnupdate){
			//�޸�
			String sql="update bookinfo set bookname='Ѫɫ����' where bookid=1";
			sqlite.execSQL(sql);
			
		}
	}

}
