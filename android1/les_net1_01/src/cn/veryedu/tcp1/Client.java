package cn.veryedu.tcp1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * �ͻ���
 * 
 * @author Administrator
 * 
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		// ����һ��ͨ���׽���ȥ���ӷ�����
		// address:��������IP��ַ
		// �������ṩ�����Ӷ˿�
		Socket s = new Socket(InetAddress.getByName("localhost"), 8888);
		while (true) {
			// ����һ��������������������
			InputStream is = s.getInputStream();
			byte[] b = new byte[64];
			is.read(b);
			System.out.println("������˵:" + new String(b));

			System.out.println("������Ҫ���͵�����:");
			String data = input.next();
			// ����һ�������������������
			OutputStream os = s.getOutputStream();
			os.write(data.getBytes());
		}
	}

}
