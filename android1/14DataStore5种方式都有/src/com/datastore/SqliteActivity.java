package com.datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class SqliteActivity extends Activity implements OnClickListener {

	private EditText mEditText1, mEditText2;
	private Button returnhome, submit;
	private TextView mExplain;
	private ListView mListView;
	MyAdapter adapter;
	private List<HashMap<String, Object>> mList = new ArrayList<HashMap<String, Object>>();
	private SQLiteDatabase mSQLiteDataBase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_preferences);
		initControl();
		openDataBase();
		initList();
	}

	/* 初始化 */
	private void initControl() {
		returnhome = (Button) this.findViewById(R.id.returnhome);
		returnhome.setOnClickListener(this);

		mEditText1 = (EditText) this.findViewById(R.id.username);
		mEditText2 = (EditText) this.findViewById(R.id.password);
		mExplain = (TextView) this.findViewById(R.id.explain);
		mExplain.setVisibility(View.GONE);

		submit = (Button) this.findViewById(R.id.submit);
		submit.setOnClickListener(this);
	}

	private void initList() {
		mList = getData("SELECT * FROM table1");
		mListView = (ListView) this.findViewById(R.id.mylistview);
		adapter = new MyAdapter(this, mList, R.layout.listview);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				/* 删除数据库记录 */
				TextView record = (TextView) view.findViewById(R.id.recordid);
				int recordid = Integer.parseInt(record.getText().toString()
						.trim());
				delData(recordid);

				/* 动态删除页面记录 */
				mList.remove(position);
				adapter.notifyDataSetChanged();
			}

		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.returnhome:
			super.finish();
			break;
		case R.id.submit:
			addData();
			break;
		}
	}

	/* 打开数据库，创建表 */
	private void openDataBase() {
		mSQLiteDataBase = this.openOrCreateDatabase("examples.db",
				MODE_PRIVATE, null);

		String CREATE_TABLE = "create table if not exists table1 (_id INTEGER PRIMARY KEY,name TEXT,pswd TEXT);";
		mSQLiteDataBase.execSQL(CREATE_TABLE);
	}

	/* 查询数据 */
	private List<HashMap<String, Object>> getData(String where) {
		HashMap<String, Object> hashMap;
		Cursor cur = mSQLiteDataBase.rawQuery(where, null);
		if (cur != null) {
			if (cur.moveToFirst()) {
				do {
					int id = cur.getInt(cur.getColumnIndex("_id"));
					String name = cur.getString(cur.getColumnIndex("name"));
					String pswd = cur.getString(cur.getColumnIndex("pswd"));

					hashMap = new HashMap<String, Object>();
					hashMap.put("recordid", String.valueOf(id));
					hashMap.put("name", name);
					hashMap.put("pswd", pswd);
					mList.add(hashMap);

				} while (cur.moveToNext());
			}
		}
		return mList;
	}

	/* 添加一条数据 */
	private void addData() {
		String name = mEditText1.getText().toString().trim();
		String pswd = mEditText2.getText().toString().trim();

		/* 添加方式一 */
		ContentValues cv = new ContentValues();
		cv.put("name", name);
		cv.put("pswd", pswd);
		mSQLiteDataBase.insert("table1", null, cv);

		/* 添加方式二 */
		String INSERT_DATA = "INSERT INTO table1 (name,pswd) values ('" + name
				+ "2','" + pswd + "2')";
		mSQLiteDataBase.execSQL(INSERT_DATA);

		/* 动态更新页面显示 */
		mList = getData("SELECT * FROM table1 where name='" + name
				+ "' or name ='" + name + "2'");
		adapter.notifyDataSetChanged();
	}

	/* 删除一条数据 */
	private void delData(int recordid) {
		String DELETE_DATA = "DELETE FROM table1 WHERE _id=" + recordid + ";";
		mSQLiteDataBase.execSQL(DELETE_DATA);
	}

	public class MyAdapter extends BaseAdapter {
		private Context context;
		public List<HashMap<String, Object>> dataList;
		public int mView;

		public MyAdapter(Context context,
				List<HashMap<String, Object>> itemMap, int view) {
			this.context = context;
			this.dataList = itemMap;
			this.mView = view;
		}

		@Override
		public int getCount() {
			return dataList.size();
		}

		@Override
		public Object getItem(int position) {
			return dataList.get(position);
		}

		@Override
		public long getItemId(int itemId) {
			return itemId;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parentView) {
			ViewHolder holder;
			if (convertView == null) {
				convertView = LinearLayout.inflate(context, mView, null);
				holder = new ViewHolder();
				holder.recordid = (TextView) convertView
						.findViewById(R.id.recordid);
				holder.name = (TextView) convertView.findViewById(R.id.name);
				holder.pswd = (TextView) convertView.findViewById(R.id.pswd);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			HashMap<String, Object> entry = dataList.get(position);
			holder.recordid.setText((String) entry.get("recordid"));
			holder.name.setText((String) entry.get("name"));
			holder.pswd.setText((String) entry.get("pswd"));
			return convertView;
		}

		/**
		 * 定义ListView要获取的控件
		 */
		class ViewHolder {
			TextView recordid;
			TextView name;
			TextView pswd;
		}
	}
}
