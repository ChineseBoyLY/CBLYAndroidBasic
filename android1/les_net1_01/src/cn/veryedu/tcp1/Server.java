package cn.veryedu.tcp1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ��������
 * 
 * @author Administrator
 * 
 */
public class Server {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("������������");
		// ����һ�������׽���
		// �׽���:��ַ+�˿�
		// �����ȴ���������������
		// port:0-32767
		ServerSocket ss = new ServerSocket(8888);
		// ����һ��ͨ���׽���,����������ӣ��Ϳ��Լ���
		Socket s = ss.accept();
		System.out.println("�ͻ������ӷ�������");

		while (true) {
			System.out.println("������Ҫ���͵�����:");
			String data = input.next();
			// ����һ���������������������
			OutputStream os = s.getOutputStream();
			os.write(data.getBytes());

			// ����һ��������������������
			InputStream is = s.getInputStream();
			byte[] b = new byte[64];
			is.read(b);
			System.out.println(new String(b));
		}

	}
}
