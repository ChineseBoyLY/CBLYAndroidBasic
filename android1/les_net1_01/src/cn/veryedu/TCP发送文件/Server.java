package cn.veryedu.TCP�����ļ�;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(9527);
		Socket socket=ss.accept();
		
		//�������ļ�����
		File file=new File("C:\\Users\\Administrator\\Desktop\\TechSmith.Camtasia.Studio.v4.0.2.HA.rar");
		FileInputStream fis=new FileInputStream(file);
		//�����������
		OutputStream out=socket.getOutputStream();
		
		//��ȡ�ļ����ݲ�д��������
		int n=0;
		byte b[]=new byte[1024];
		while((n=fis.read(b))!=-1){
			out.write(b);
		}
		
		//�ر���Դ
		out.close();
		fis.close();
		socket.close();
		ss.close();
		
	}

}
