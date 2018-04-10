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

public class Server {
	static BufferedReader reader;
	public static void main(String[] args) throws Exception {
		// ���� ServerSocket ����
		ServerSocket serverSocket = new ServerSocket(8888);
		// ���ܿͻ��˵�����, ���õ� Socket ����
		Socket socket = serverSocket.accept();

		// ����
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		PrintWriter pw = new PrintWriter(osw);
		pw.write("�������Է������˵��ʺ�");
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
//		serverSocket.close();
	
	}
}
