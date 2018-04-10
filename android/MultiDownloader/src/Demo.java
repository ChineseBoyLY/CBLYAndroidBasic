import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo {

	public static int threadCount = 3;
	public static int runningThread = 3;

	public static void main(String[] args) throws Exception {
		// 1`���ӷ���������ȡһ���ļ�����ȡ�ļ��ĳ��ȣ��ڱ��ش���һ����С���������ļ�һ����С����ʱ�ļ�
		String path = "http://10.100.51.162:8080/a.mp3";
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		int code = conn.getResponseCode();
		if (code == 200) {
			// ���������ص����ݵĳ��� ʵ���Ͼ����ļ��ĳ���
			int length = conn.getContentLength();
			System.out.println("�ļ��ĳ���Ϊ" + length);
			// �ڿͻ��˱��ش�������һ����С�����������ļ�һ������ʱ�ļ�
			RandomAccessFile raf = new RandomAccessFile("a.mp3", "rwd");
			// ָ�������ļ��ĳ���
			raf.setLength(length);
			raf.close();

			// ������3���߳�ȥ������Դ
			// ƽ��ÿһ���߳������ļ��Ĵ�С
			int blockSize = length / threadCount;
			for (int threadId = 1; threadId <= threadCount; threadId++) {
				// ��һ���̵߳Ŀ�ʼλ��
				int startIndex = (threadId - 1) * blockSize;
				int endIndex = threadId * blockSize - 1;

				if (threadId == threadCount) {// ���һ���߳����صĳ���Ҫ��һ��
					endIndex = length;
				}
				System.out.println("�̣߳�" + threadId + "���أ�---" + startIndex
						+ "----" + endIndex);
				new DownloadThread(threadId, startIndex, endIndex, path)
						.start();
			}

		} else {
			System.out.println("������������");
		}
	}

	/**
	 * �����ļ������߳� ÿһ���߳����ض�Ӧλ�õ��ļ�
	 * 
	 * @author Administrator
	 * 
	 */
	public static class DownloadThread extends Thread {
		private int threadId;
		private int startIndex;
		private int endIndex;
		private String path;

		public DownloadThread(int threadId, int startIndex, int endIndex,
				String path) {
			super();
			this.threadId = threadId;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.path = path;
		}

		@Override
		public void run() {
			try {
				// ����Ƿ���ڼ�¼���س��ȵ��ļ���������� ����ȡ����ļ�������
				File tempFile = new File(threadId + ".txt");
				if (tempFile.exists() && tempFile.length() > 0) {
					FileInputStream fis = new FileInputStream(tempFile);
					byte[] temp = new byte[1024];
					int leng = fis.read(temp);
					String downloadLen = new String(temp, 0, leng);
					int downloadLenInt = Integer.parseInt(downloadLen);
					startIndex = downloadLenInt;// �޸����ص���ʵ�Ŀ�ʼλ��
					fis.close();
				}

				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				conn.setConnectTimeout(5000);
				conn.setRequestMethod("GET");
				// ��Ҫ��������������ز��ֵ��ļ�ָ���ļ���λ��
				conn.setRequestProperty("Range", "bytes=" + startIndex + "-"
						+ endIndex);
				System.out.println("�߳���ʵ���أ�" + threadId + "���أ�***" + startIndex
						+ "***" + endIndex);
				int code = conn.getResponseCode();// �ӷ���������ȫ����Դ200 ok �����󲿷���Դ
													// 206ok
				System.out.println("code:" + code);
				if (code == 206) {
					InputStream is = conn.getInputStream();// ���ص�ǰλ�ö�Ӧ���ļ���������
					RandomAccessFile raf = new RandomAccessFile("a.mp3", "rwd");
					// ���д�ļ���ʱ���Ǵ����￪ʼд
					raf.seek(startIndex);// ��λ�ļ�
					int len = 0;
					byte[] buffer = new byte[1024];
					int total = 0;// �Ѿ��������ݵĳ���
					while ((len = is.read(buffer)) != -1) {
						RandomAccessFile info = new RandomAccessFile(threadId
								+ ".txt", "rwd");// ��¼��ǰ���ؽ���
						raf.write(buffer, 0, len);
						total += len;
						info.write((total+startIndex+"").getBytes());//��¼�������ص�λ��
						info.close();
					}
					is.close();
					raf.close();
					System.out.println("�̣߳�" + threadId + "���������...");
				}else{
					System.out.println("�̣߳�" + threadId + "����ʧ����...");
				}
	
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				runningThread--;
				if(runningThread==0){//�����߳��Ѿ�ִ�������
					for(int i=1;i<=3;i++){
						File file = new File(i+".txt");
						file.delete();
					}
					System.out.println("�ļ�������ϣ�ɾ����¼�ļ�");
				}
			}
		}
	}
}
