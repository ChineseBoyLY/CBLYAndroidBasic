package com.renwen.login.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

public class LoginService {
	public static boolean saveUserInfo(Context ctx, String uName, String pwd) {
		try {
			if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
				File file = new File(Environment.getExternalStorageDirectory(),"info.txt");
				FileOutputStream fos = new FileOutputStream(file);
				fos.write((uName + "##" + pwd).getBytes());
				fos.close();
				return true;
			}else{
				Toast.makeText(ctx, "sd卡不可用", Toast.LENGTH_SHORT).show();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 获取保存的数据
	public static Map<String, String> getSaveUserInfo(Context ctx) {
		File file = new File(Environment.getExternalStorageDirectory(),"info.txt");
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
