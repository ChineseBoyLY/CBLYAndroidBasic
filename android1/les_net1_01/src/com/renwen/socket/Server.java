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
		// 创建 ServerSocket 对象
		ServerSocket serverSocket = new ServerSocket(8888);
		// 接受客户端的请求, 并得到 Socket 对象
		Socket socket = serverSocket.accept();

		// 发送
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		PrintWriter pw = new PrintWriter(osw);
		pw.write("我是来自服务器端的问候");
		pw.flush();
		
		//接收
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
