package cn.veryedu.tcp1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 * 
 * @author Administrator
 * 
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		// 定义一个通信套接字去连接服务器
		// address:服务器的IP地址
		// 服务器提供的连接端口
		Socket s = new Socket(InetAddress.getByName("localhost"), 8888);
		while (true) {
			// 定义一个输入流用来接收数据
			InputStream is = s.getInputStream();
			byte[] b = new byte[64];
			is.read(b);
			System.out.println("服务器说:" + new String(b));

			System.out.println("请输入要发送的内容:");
			String data = input.next();
			// 定义一个输出流用来发送数据
			OutputStream os = s.getOutputStream();
			os.write(data.getBytes());
		}
	}

}
