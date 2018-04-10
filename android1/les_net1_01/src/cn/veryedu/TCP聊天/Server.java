package cn.veryedu.TCP����;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Server extends JFrame implements Runnable{
	JTextArea jta=new JTextArea();//������ʾ����
	JTextField jtf=new JTextField(20);//������������
	JButton jtb=new JButton("����");
	JPanel jp=new JPanel();
	//��������׽���
	ServerSocket ss=null;
	Socket s=null;
	OutputStream out=null;
	InputStream in=null;
	
	Server(){
		try {
			ss=new ServerSocket(9999);
			s=ss.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setTitle("������");
		this.setBounds(200, 50, 400, 400);
		this.add(new JScrollPane(jta),BorderLayout.CENTER);
		jp.add(jtf);
		jp.add(jtb);
		this.add(jp,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ע�����
		jtb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					out=s.getOutputStream();
					//��ȡ�ı����е�����
					String data=jtf.getText().trim();
					//�����ݷ��ͳ�ȥ
					out.write(data.getBytes());
					//ˢ��һ�����绺��
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}
	public static void main(String[] args) {
		new Thread(new Server()).start();
	}
	@Override
	public void run() {
		while(true){
			if(s!=null){
				//����Ϣ
				try {
					byte[] b=new byte[64];
					in=s.getInputStream();
					in.read(b);
					String data=new String(b).trim();
					//�����ݷŵ��ı�����
					jta.append("�ͻ�˵:"+data+"\r\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
}






