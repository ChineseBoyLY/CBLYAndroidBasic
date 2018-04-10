package cn.veryedu.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable{
	InputStream in=null;
	Server(InputStream in){
		this.in=in;
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		// 定义服务套接字
		ServerSocket ss = new ServerSocket(9527);
		// 定义一个通信套接字
		Socket s = ss.accept();
		InputStream is=s.getInputStream();
		//启动自己的接收线程
		Server server=new Server(is);
		new Thread(server).start();
		
		while (true) {
			// 如果有人连接
			System.out.println("请输入需要发送的内容:");
			String data = input.next();
			// 定义输出流进行数据发送
			OutputStream os = s.getOutputStream();
			os.write(data.getBytes());
		}
	}
	@Override
	public void run() {
		while(true){
			byte[] b=new byte[64];
			try {
				this.in.read(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("客户端说:"+new String(b).trim());
		}
		
	}
}
