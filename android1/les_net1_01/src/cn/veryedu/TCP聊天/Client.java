package cn.veryedu.TCP聊天;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements Runnable{
	JTextArea jta = new JTextArea();// 用来显示数据
	JTextField jtf = new JTextField(20);// 用来输入数据
	JButton jtb = new JButton("发送");
	JPanel jp = new JPanel();
	// 定义套接字
	Socket s = null;
	OutputStream out = null;
	InputStream in = null;

	Client() {
		try {
			s = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setTitle("客户端");
		this.setBounds(200, 50, 400, 400);
		this.add(new JScrollPane(jta), BorderLayout.CENTER);
		jp.add(jtf);
		jp.add(jtb);
		this.add(jp, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//注册监听
				jtb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							out=s.getOutputStream();
							//获取文本框中的内容
							String data=jtf.getText().trim();
							//把内容发送出去
							out.write(data.getBytes());
							//刷新一下网络缓存
							out.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				});
	}

	public static void main(String[] args) {
		new Thread(new Client()).start();
	}

	@Override
	public void run() {
		while(true){
			if(s!=null){
				//收信息
				try {
					byte[] b=new byte[64];
					in=s.getInputStream();
					in.read(b);
					String data=new String(b).trim();
					//把数据放到文本域中
					jta.append("服务器说:"+data+"\r\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
