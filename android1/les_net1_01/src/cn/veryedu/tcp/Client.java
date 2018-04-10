package cn.veryedu.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
	InputStream in=null;
	Client(InputStream in){
		this.in=in;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner input=new Scanner(System.in);
		//定义一个通信套接字
		Socket s=new Socket(InetAddress.getByName("127.0.0.1"),9527);
		//定义一个输入流用来接收数据
		InputStream is=s.getInputStream();
		//启用一个线程进行收数据的动作
		Client c=new Client(is);
		new Thread(c).start();
		
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
			System.out.println("服务器说:"+new String(b).trim());
		}
		
	}

}
