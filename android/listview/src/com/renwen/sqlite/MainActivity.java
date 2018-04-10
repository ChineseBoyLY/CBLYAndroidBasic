package com.renwen.sqlite;

import java.util.List;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.renwen.sqlite.dao.PersonDao;
import com.renwen.sqlite.domain.Person;

public class MainActivity extends Activity {

	LinearLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
	
		ll=(LinearLayout) findViewById(R.id.list);
		PersonDao pd=new PersonDao(this);
		List<Person> persons=pd.find();
		for (Person person : persons) {
			String info=person.toString();
			TextView tv=new TextView(this);
			tv.setTextSize(20);
			tv.setTextColor(Color.BLACK);
			tv.setText(info);
			ll.addView(tv);
		}
	}
	
	public void btnClick(View view){
		if(view.getId()==R.id.init){
			PersonSqliteOpenHelper helper = new PersonSqliteOpenHelper(this);
			SQLiteDatabase db = helper.getWritableDatabase();
		}else if(view.getId()==R.id.add){
//			在屏幕显示的时候并不是全部new出来，而是只new出来一屏的TextView，其他的再轮询这一屏的
			PersonDao pd=new PersonDao(this);
			for (int i = 7; i < 50; i++) {
				pd.add(i, "tom"+i);
			}
		}else if(view.getId()==R.id.del){
			PersonDao pd=new PersonDao(this);
			pd.delete(6);
		}else if(view.getId()==R.id.update){
			PersonDao pd=new PersonDao(this);
			pd.update(5, "tom5555");
		}else if(view.getId()==R.id.find){
			PersonDao pd=new PersonDao(this);
			List<Person> personList = pd.find();
			for (Person person : personList) {
				Toast.makeText(this, person.getId()+person.getName(), 0).show();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
