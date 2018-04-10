package com.supermario.filemanager;
import java.io.File;
import java.util.ArrayList;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
public class FileService extends Service {	
	private Looper mLooper;
	private FileHandler mFileHandler;
	private ArrayList<String> mFileName = null;
	private ArrayList<String> mFilePaths = null;
	public static final String FILE_SEARCH_COMPLETED = "com.supermario.file.FILE_SEARCH_COMPLETED";
	public static final String FILE_NOTIFICATION = "com.supermario.file.FILE_NOTIFICATION";	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}	
	//��������
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("FileService", "file service is onCreate");
		//�½������߳�
		HandlerThread mHT = new HandlerThread("FileService",HandlerThread.NORM_PRIORITY);
		mHT.start();
		mLooper = mHT.getLooper();
		mFileHandler = new FileHandler(mLooper);
	}
	//����ʼ
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Log.d("FileService", "file service is onStart");
		mFileName = new ArrayList<String>();
		mFilePaths = new ArrayList<String>();
		mFileHandler.sendEmptyMessage(0);
		//����֪ͨ�������ڽ�������
		fileSearchNotification();
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		//ȡ��֪ͨ
		mNF.cancel(R.string.app_name);
	}	
	class FileHandler extends Handler{		
		public FileHandler(Looper looper){
			super(looper);
		}		
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Log.d("FileService", "file service is handleMessage");
			//��ָ����Χ����
			initFileArray(new File(SearchBroadCast.mServiceSearchPath));
			//���û������ȡ�������򲻷����㲥
			if(!MainActivity.isComeBackFromNotification == true){
				Intent intent = new Intent(FILE_SEARCH_COMPLETED);
				intent.putStringArrayListExtra("mFileNameList", mFileName);
				intent.putStringArrayListExtra("mFilePathsList", mFilePaths);
				//�������֮��Я�����ݲ����͹㲥
				sendBroadcast(intent);
			}
		}	
	}	
	private int m = -1;
    /**�����������¼��Ŀɻص�����*/
    private void initFileArray(File file){
    	Log.d("FileService", "currentArray is "+file.getPath());
    	//ֻ�ܱ����ɶ����ļ��У�����ᱨ��
    	if(file.canRead()){
    		File[] mFileArray = file.listFiles();
        	for(File currentArray:mFileArray){
        		if(currentArray.getName().indexOf(SearchBroadCast.mServiceKeyword) != -1){
        			if (m == -1) {
						m++;
						// ��������֮ǰĿ¼
						mFileName.add("BacktoSearchBefore");
						mFilePaths.add(MainActivity.mCurrentFilePath);
					}
        			mFileName.add(currentArray.getName());
        			mFilePaths.add(currentArray.getPath());
        		}
        		//������ļ�����ص��÷���
        		if(currentArray.exists()&&currentArray.isDirectory()){
        			//����û�ȡ����������Ӧ��ֹͣ�����Ĺ���
        			if(MainActivity.isComeBackFromNotification == true){
        				return;
        			}
        			initFileArray(currentArray);
        		}
        	}
    	}                                                                                                                                                                                                                                                                                                                                                                                            
    }    
    NotificationManager mNF;
    /**֪ͨ*/
    private void fileSearchNotification(){
    	Notification mNotification = new Notification(R.drawable.logo,"��̨������...",System.currentTimeMillis());
    	Intent intent = new Intent(FILE_NOTIFICATION);
    	//��noticeʱ����ʾ����
    	intent.putExtra("notification", "��֪ͨ�����ڣ�˵������δ��ɣ����������ﴥ��һ���¼��������֪ͨ�ص�Activity֮�󣬿��Ե���һ������ʾ�Ƿ�ȡ������!");
    	PendingIntent mPI = PendingIntent.getBroadcast(this,0,intent,0);
    	mNotification.setLatestEventInfo(this, "��"+SearchBroadCast.mServiceSearchPath+"������", "�����ؼ���Ϊ"+SearchBroadCast.mServiceKeyword+"�������ȡ��������", mPI);
    	if(mNF == null){
    		mNF = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    	}
    	mNF.notify(R.string.app_name, mNotification);
    }  
}