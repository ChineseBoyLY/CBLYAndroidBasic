package com.example.les_intent;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Intent intent=getIntent();
		//Book book=(Book)intent.getSerializableExtra("book");
		//Log.d("TAG",""+book.bookid+","+book.bookname);
		//Person p=intent.getParcelableExtra("person");
		//Log.d("TAG",""+p.pid+","+p.pname+"£¬"+p.psex);
		/*ArrayList<Person> list=intent.getParcelableArrayListExtra("list");
		for (int i = 0; i < list.size(); i++) {
			Log.d("TAG",""+list.get(i).pid);
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
