package com.renwen.weather;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.renwen.weather.domain.WeatherInfo;
import com.renwen.weather.service.weatherService;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView)findViewById(R.id.tv);
		
		try {
			List<WeatherInfo> infos = weatherService.getWeatherInfos(MainActivity.class.getClassLoader().getResourceAsStream("weather.xml"));
			StringBuffer sb=new StringBuffer();
			for (WeatherInfo weatherInfo : infos) {
				String str = infos.toString();
				sb.append(str);
				sb.append("\n");
			}
			tv.setText(sb.toString());
		
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "Ω‚Œˆ–≈œ¢ ß∞‹", 0).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
