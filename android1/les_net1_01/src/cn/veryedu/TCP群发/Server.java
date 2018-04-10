package cn.veryedu.TCP群发;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Server extends JFrame implements Runnable {
	ServerSocket ss = null;
	ArrayList<Socket> allUser = new ArrayList<Socket>();
	JTextField jtf = new JTextField(20);
	JButton jb = new JButton("发送");

	Server() {
		try {
			ss = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setBounds(200, 50, 400, 300);
		this.setLayout(new FlowLayout());
		this.add(jtf);
		this.add(jb);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String data = jtf.getText().trim();
				for (int i = 0; i < allUser.size(); i++) {
					Socket s = allUser.get(i);
					OutputStream os = null;
					try {
						os = s.getOutputStream();
						os.write(data.getBytes());
						os.flush();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						//关闭动作最好写到窗口事件的clossed方法中
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new Thread(new Server()).start();
	}

	/**
	 * 获取所有的客户连接对象
	 */
	@Override
	public void run() {
		while (true) {
			Socket s = null;
			try {
				s = ss.accept();
				allUser.add(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
