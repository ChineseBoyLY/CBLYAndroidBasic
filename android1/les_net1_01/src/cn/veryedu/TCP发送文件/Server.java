package cn.veryedu.TCP发送文件;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(9527);
		Socket socket=ss.accept();
		
		//用来读文件的流
		File file=new File("C:\\Users\\Administrator\\Desktop\\TechSmith.Camtasia.Studio.v4.0.2.HA.rar");
		FileInputStream fis=new FileInputStream(file);
		//用于网络的流
		OutputStream out=socket.getOutputStream();
		
		//读取文件内容并写入网络中
		int n=0;
		byte b[]=new byte[1024];
		while((n=fis.read(b))!=-1){
			out.write(b);
		}
		
		//关闭资源
		out.close();
		fis.close();
		socket.close();
		ss.close();
		
	}

}
