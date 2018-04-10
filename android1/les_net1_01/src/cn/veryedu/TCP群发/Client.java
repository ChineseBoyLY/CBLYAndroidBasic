package cn.veryedu.TCPÈº·¢;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket(InetAddress.getByName("192.168.4.101"), 8888);
			InputStream in = s.getInputStream();
			while (true) {
				byte[] b = new byte[128];
				while (in.read(b) != -1) {
					System.out.println(new String(b).trim());
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
