package cn.veryedu.TCP发送文件;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception{
		Socket socket=new Socket(InetAddress.getByName("localhost"),9527);
		//用于网络的流
		InputStream in=socket.getInputStream();
		
		//用于文件的流
		FileOutputStream fos=new FileOutputStream("C:\\123.rar");
		
		byte b[]=new byte[1024];
		int n=0;
		while((n=in.read(b))!=-1){
			fos.write(b);
		}
		
		fos.close();
		in.close();
		socket.close();
		
	}

}
