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
		// ��������׽���
		ServerSocket ss = new ServerSocket(9527);
		// ����һ��ͨ���׽���
		Socket s = ss.accept();
		InputStream is=s.getInputStream();
		//�����Լ��Ľ����߳�
		Server server=new Server(is);
		new Thread(server).start();
		
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
			System.out.println("�ͻ���˵:"+new String(b).trim());
		}
		
	}
}
