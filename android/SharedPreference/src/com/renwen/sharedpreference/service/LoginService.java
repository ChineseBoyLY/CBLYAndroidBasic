package com.renwen.sharedpreference.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LoginService {
	public static void saveUserInfo(Context ctx, String uName, String pwd) {
		SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("uName", uName);
		editor.putString("pwd", pwd);
		editor.commit();
	}

	// 获取保存的数据
	public static Map<String, String> getSaveUserInfo(Context ctx) {
		File file = new File(ctx.getFilesDir(), "info.txt");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			String str = br.readLine();
			String[] infos = str.split("##");
			Map<String, String> map = new HashMap<String, String>();
			map.put("uName", infos[0]);
			map.put("pwd", infos[1]);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
