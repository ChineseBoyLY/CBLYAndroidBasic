package com.example.dbtest;

import android.app.Activity;
import android.content.ContentValues;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.db.CopyDBToSDCard;
import com.example.db.DatabaseHelper;
import com.example.domain.UserEx;

public class MainActivity extends Activity {

	private final String db_name = "DBTest";
	private int rowNo = 0;

	private final String CREATE_TABLE = "create table if not exists user(id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(10), remark varchar(50))";

	private EditText mRemark, mDeleteId;
	private TextView mResult;
	private UserEx userEx = null;

	private int dbVersion = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnCreateDB = (Button) findViewById(R.id.db_create);
		Button btnUpgradeDB = (Button) findViewById(R.id.db_upgrade);
		Button btnCreateTable = (Button) findViewById(R.id.table_create);
		Button btnInsertTable = (Button) findViewById(R.id.table_insert);
		Button btnUpdateTable = (Button) findViewById(R.id.table_update);
		Button btnDeleteTable = (Button) findViewById(R.id.table_delete);
		Button btnQueryTable = (Button) findViewById(R.id.table_query);

		btnCreateDB.setOnClickListener(new CreateDBListener());
		btnUpgradeDB.setOnClickListener(new UpgradeDBListener());
		btnCreateTable.setOnClickListener(new CreateTableListener());
		btnInsertTable.setOnClickListener(new InsertTableListener());
		btnUpdateTable.setOnClickListener(new UpdateTableListener());
		btnDeleteTable.setOnClickListener(new DeleteTableListener());
		btnQueryTable.setOnClickListener(new QueryTableListener());

		mRemark = (EditText) findViewById(R.id.remark);
		mDeleteId = (EditText) findViewById(R.id.deleteid);
		mResult = (TextView) findViewById(R.id.query_result);

		userEx = new UserEx(MainActivity.this);

		try {
			this.dbVersion = MainActivity.this.getPackageManager()
					.getPackageInfo(MainActivity.this.getPackageName(), 0).versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ʵ��Ӧ�õ�ʱ��Ӧ���÷���������DatabaseHelper.java�в�����
	 * */
	class CreateDBListener implements OnClickListener {

		@Override
		public void onClick(View v) {

			try {
				userEx.openDBConnect();

				show("����ɹ�");
			} catch (Exception e) {
				e.printStackTrace();
				show("����ʧ��" + e.getMessage());
			} finally {
				userEx.closeDBConnect();
			}

		}

	}

	/**
	 * ʵ��Ӧ�õ�ʱ��Ӧ���÷���������DatabaseHelper.java�в�����
	 * */
	class UpgradeDBListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			try {
				userEx.openDBConnect();

				show("�汾�����ɹ�");
			} catch (Exception e) {
				e.printStackTrace();
				show("�汾����ʧ��" + e.getMessage());
			} finally {
				userEx.closeDBConnect();
			}

		}

	}

	/**
	 * ʵ��Ӧ�õ�ʱ��Ӧ���÷���������DatabaseHelper.java�в�����
	 * */
	class CreateTableListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			DatabaseHelper dbHelper = null;
			SQLiteDatabase db = null;
			try {

				dbHelper = new DatabaseHelper(MainActivity.this, db_name,
						dbVersion);
				db = dbHelper.getWritableDatabase();

				db.execSQL(CREATE_TABLE);
				System.out.println("MainActivity  ������user");
				show("����ɹ�");
			} catch (Exception e) {
				e.printStackTrace();
				show("����ʧ��" + e.getMessage());
			} finally {
				db.close();
				dbHelper.close();
			}
		}

	}

	class InsertTableListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			try {

				rowNo++;
				ContentValues values = new ContentValues();
				values.put("name", "row" + rowNo);
				values.put("remark", "row" + rowNo);

				userEx.Add(values);
				show("�����ɹ�");
				System.out.println("MainActivity  ��������" + rowNo);
			} catch (Exception e) {
				e.printStackTrace();
				show("����ʧ��" + e.getMessage());
			}

		}

	}

	class UpdateTableListener implements OnClickListener {

		@Override
		public void onClick(View v) {

			try {

				ContentValues values = new ContentValues();
				values.put("remark", mRemark.getText().toString());

				userEx.Update(values, "id=? and name=?", new String[] { "1",
						"row1" });
				System.out.println("MainActivity  �޸�����1");
				show("���³ɹ�");
			} catch (Exception e) {
				e.printStackTrace();
				show("����ʧ��" + e.getMessage());
			}
		}
	}

	class DeleteTableListener implements OnClickListener {

		@Override
		public void onClick(View v) {

			try {
				userEx.Delete("id=?", new String[] { mDeleteId.getText()
						.toString() });

				System.out.println("MainActivity  ɾ������idΪ��"
						+ mDeleteId.getText().toString());
				show("ɾ���ɹ�");
			} catch (Exception e) {
				e.printStackTrace();
				show("ɾ��ʧ��" + e.getMessage());
			}
		}
	}

	class QueryTableListener implements OnClickListener {

		@Override
		public void onClick(View v) {

			// // ��ѯ�ɰ汾user��id��name��remark��
			// getOldVersionUsers();

			// ��ѯ�°汾user��id��name��remark��age��
			getNewVersionsers();
		}
	}

	private void getOldVersionUsers() {
		try {

			Cursor cursor;

			cursor = userEx.Query(new String[] { "id", "name", "remark" },
					null, null, null, null, null);

			String pre = "";

			if (cursor.getCount() > 0) {
				System.out.println("��ѯ���Ϊ��");
				while (cursor.moveToNext()) {

					String id = cursor.getString(cursor.getColumnIndex("id"));
					String name = cursor.getString(cursor
							.getColumnIndex("name"));
					String remark = cursor.getString(cursor
							.getColumnIndex("remark"));

					pre = pre + "\r\n" + "id : " + id + "; name : " + name
							+ "; remark : " + remark;

				}
				mResult.setText(pre);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			userEx.closeDBConnect();
		}
	}

	private void getNewVersionsers() {
		try {

			Cursor cursor;
			cursor = userEx.Query(
					new String[] { "id", "name", "remark", "age" }, null, null,
					null, null, null);

			String pre = "";

			if (cursor.getCount() > 0) {
				System.out.println("��ѯ���Ϊ��");
				while (cursor.moveToNext()) {

					String id = cursor.getString(cursor.getColumnIndex("id"));
					String name = cursor.getString(cursor
							.getColumnIndex("name"));
					String remark = cursor.getString(cursor
							.getColumnIndex("remark"));
					String age = cursor.getString(cursor.getColumnIndex("age"));

					pre = pre + "\r\n" + "id : " + id + "; name : " + name
							+ "; remark : " + remark + "; age : " + age;

				}
				mResult.setText(pre);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			userEx.closeDBConnect();
		}
	}

	private void show(String t) {
		Toast.makeText(getApplicationContext(), t, Toast.LENGTH_LONG).show();
	}

}
