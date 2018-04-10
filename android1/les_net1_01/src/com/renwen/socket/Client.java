package com.renwen.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	static BufferedReader reader;
	public static void main(String[] args) throws Exception {
		// ���� ServerSocket ����
		Socket socket = new Socket("127.0.0.1", 8888);

		// ����
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		PrintWriter pw = new PrintWriter(osw);
		pw.write("�������Կͻ��˵�huiying");
		pw.flush();
		
		//����
		InputStream is= socket.getInputStream();
		InputStreamReader isr=new InputStreamReader(is,"utf-8");
		reader =new BufferedReader(isr);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						System.out.println(reader.readLine());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
//		reader.close();
//		isr.close();
//		is.close();
//	
//		pw.close();
//		osw.close();
//		out.close();
//		socket.close();
	}
}
