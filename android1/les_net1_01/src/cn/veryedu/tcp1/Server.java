package cn.veryedu.tcp1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器端
 * 
 * @author Administrator
 * 
 */
public class Server {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("服务器启动了");
		// 定义一个服务套接字
		// 套接字:地址+端口
		// 用来等待其它人来连接我
		// port:0-32767
		ServerSocket ss = new ServerSocket(8888);
		// 定义一个通信套接字,如果有人连接，就可以继续
		Socket s = ss.accept();
		System.out.println("客户端连接服务器了");

		while (true) {
			System.out.println("请输入要发送的内容:");
			String data = input.next();
			// 定义一个输出流，用来发送数据
			OutputStream os = s.getOutputStream();
			os.write(data.getBytes());

			// 定义一个输入流，用来收数据
			InputStream is = s.getInputStream();
			byte[] b = new byte[64];
			is.read(b);
			System.out.println(new String(b));
		}

	}
}
