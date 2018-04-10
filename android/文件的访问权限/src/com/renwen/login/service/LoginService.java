package com.renwen.login.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

public class LoginService {
	
	public static boolean saveUserInfo(Context ctx, String uName, String pwd ,int mode) {
		try {
			FileOutputStream fos=null;
			switch(mode){
			case 1:
				fos=ctx.openFileOutput("private.txt", Context.MODE_PRIVATE);
				break;
			case 2:
				fos=ctx.openFileOutput("read.txt", Context.MODE_WORLD_READABLE);
				break;
			case 3:
				fos=ctx.openFileOutput("write.txt", Context.MODE_WORLD_WRITEABLE);
				break;
			case 4:
				fos=ctx.openFileOutput("public.txt", Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
				break;
			}
			
			fos.write((uName+"##"+pwd).getBytes());
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
