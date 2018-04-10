package com.datastore;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NetworkActivity extends Activity implements OnClickListener {

	private EditText mEditText1, mEditText2;
	private Button returnhome, submit;
	private TextView mTextView, explain;
	private String mResult = "";
	private JSONArray info = new JSONArray();
	private Handler handler = null;

	/* ������Ҫ��ȡ��������Դ��ַ */
	private static final String SERVER_URL = "http://115.29.188.74:83/temp_dir/chongqtest.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_preferences);

		initControl();
		// �����������̵߳�handler
		handler = new Handler();
		// �����߳�ִ����������
		new Thread(downloadRun).start();
	}

	/* ��ʼ�� */
	private void initControl() {
		returnhome = (Button) this.findViewById(R.id.returnhome);
		returnhome.setOnClickListener(this);

		mEditText1 = (EditText) this.findViewById(R.id.username);
		mEditText1.setVisibility(View.GONE);
		mEditText2 = (EditText) this.findViewById(R.id.password);
		mEditText2.setVisibility(View.GONE);
		mTextView = (TextView) this.findViewById(R.id.toshow);
		mTextView.setVisibility(View.GONE);
		explain = (TextView) this.findViewById(R.id.explain);

		submit = (Button) this.findViewById(R.id.submit);
		submit.setOnClickListener(this);
		submit.setVisibility(View.GONE);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.returnhome:
			super.finish();
			break;
		case R.id.submit:
			break;
		}
	}

	Runnable downloadRun = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			/* ����������Դ��ַ����һ��HTTP���� */
			HttpPost request = new HttpPost(SERVER_URL);
			/* ���һ������ */
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			/* ����һ���������ƣ���ӱ���Ĳ��� */
			params.add(new BasicNameValuePair("PlaceName", "NewYork"));

			try {
				// ���ò����ı���
				request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
				// �������󲢻�ȡ����
				HttpResponse httpResponse = new DefaultHttpClient()
						.execute(request);

				// �������ص�����
				if (httpResponse.getStatusLine().getStatusCode() != 404) {
					String result = EntityUtils.toString(httpResponse
							.getEntity());

					JSONObject jsonObja = new JSONObject(result)
							.getJSONObject("response");
					JSONArray jsonObjb = jsonObja.getJSONArray("list");
					for (int k = 0; k < jsonObjb.length(); k++) {
						JSONObject jsonObj = (JSONObject) jsonObjb.opt(k);
						JSONArray jsonArr = jsonObj.getJSONArray("items");
						for (int i = 0; i < jsonArr.length(); i++) {
							JSONObject jsonO = ((JSONObject) jsonArr.opt(i));
							mResult += "ID��" + jsonO.getString("id").toString()
									+ "\n";
							mResult += "name��" + jsonO.getString("name") + "\n";
							mResult += "title��" + jsonO.getString("title")
									+ "\n";
							mResult += "short_content��"
									+ jsonO.getString("short_content") + "\n";

							handler.post(runnableUi);

						}
					}
					Log.d("TAG", result);
					Log.d("TAG", info.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	// ����Runnable������runnable�и��½���
	Runnable runnableUi = new Runnable() {
		@Override
		public void run() {
			// ���½���
			explain.setText("the Content is:" + mResult);
		}

	};

}
