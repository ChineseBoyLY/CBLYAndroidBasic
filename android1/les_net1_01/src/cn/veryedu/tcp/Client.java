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
		//����һ��ͨ���׽���
		Socket s=new Socket(InetAddress.getByName("127.0.0.1"),9527);
		//����һ��������������������
		InputStream is=s.getInputStream();
		//����һ���߳̽��������ݵĶ���
		Client c=new Client(is);
		new Thread(c).start();
		
		while (true) {
			// �����������
			System.out.println("��������Ҫ���͵�����:");
			String data = input.next();
			// ����������������ݷ���
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
			System.out.println("������˵:"+new String(b).trim());
		}
		
	}

}
