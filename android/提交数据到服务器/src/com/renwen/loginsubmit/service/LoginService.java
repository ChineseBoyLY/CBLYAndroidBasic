package com.renwen.loginsubmit.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.renwen.loginsubmit.utils.StreamTools;

public class LoginService {

	public static String loginByGet(String userName, String password) {
		try {
			String path = "http://192.168.1.100:8080/web/LoginServlet?username="
					+ URLEncoder.encode(userName, "utf-8")
					+ "&pwd="
					+ URLEncoder.encode(password, "utf-8");
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");

			int code = conn.getResponseCode();
			if (code == 200) {
				// 登录成功
				InputStream is = conn.getInputStream();
				String text = StreamTools.readInputStream(is);
				return text;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String loginByPost(String userName, String password) {
		String path = "http://192.168.1.100:8080/web/LoginServlet";
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(5000);
			conn.setRequestMethod("POST");

			String data = "username=" + URLEncoder.encode(userName, "utf-8")
					+ "&pwd=" + URLEncoder.encode(password, "utf-8");
			conn.setRequestProperty("Content-Type", "text/html");
			conn.setRequestProperty("Content-Length", data.length() + "");

			// post 的方式 实际上是浏览器将数据写给了服务器
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			os.write(data.getBytes());

			int code = conn.getResponseCode();
			if (code == 200) {
				// 登录成功
				InputStream is = conn.getInputStream();
				String text = StreamTools.readInputStream(is);
				return text;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 利用系统框架去提交数据
	 * 
	 * @throws Exception
	 */
	public static String loginByClientGet(String userName, String password) {
		try {
			// 1·打开一个浏览器
			HttpClient client = new DefaultHttpClient();
			// 2·输入地址
			String path = "http://192.168.1.100:8080/web/LoginServlet?username="
					+ URLEncoder.encode(userName, "utf-8")
					+ "&pwd="
					+ URLEncoder.encode(password, "utf-8");
			HttpGet httpGet = new HttpGet(path);
			// 3·敲回车
			HttpResponse response = client.execute(httpGet);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				// 登录成功
				InputStream is = response.getEntity().getContent();
				String text = StreamTools.readInputStream(is);
				return text;
			}
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
		return null;
	}
	
	public static String loginByClientPost(String userName, String password) {
		try {
			// 1·打开一个浏览器
			HttpClient client = new DefaultHttpClient();
			// 2·输入地址
			String path = "http://192.168.1.100:8080/web/LoginServlet";
			HttpPost httpPost = new HttpPost(path);
			
			//指定要提交数据的实体
			List<NameValuePair> param=new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("username", userName));
			param.add(new BasicNameValuePair("password", password));
			httpPost.setEntity(new UrlEncodedFormEntity(param,"utf-8"));
			// 3·敲回车
			HttpResponse response = client.execute(httpPost);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) {
				// 登录成功
				InputStream is = response.getEntity().getContent();
				String text = StreamTools.readInputStream(is);
				return text;
			}
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
		return null;
	}

}
