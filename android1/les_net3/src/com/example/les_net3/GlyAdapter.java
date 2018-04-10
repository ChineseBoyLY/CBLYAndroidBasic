package com.example.les_net3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GlyAdapter extends BaseAdapter {
	Context ctx;
	String[] imgUrlStrs;
	
	LayoutInflater inflater;
	
	DownloadManager manager;
	
	public GlyAdapter(Context ctx,String[] imgUrlStrs){
		this.ctx=ctx;
		this.inflater=LayoutInflater.from(ctx);
		this.imgUrlStrs=imgUrlStrs;
		manager=(DownloadManager)ctx.getSystemService(ctx.DOWNLOAD_SERVICE);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgUrlStrs.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView iv;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.gly_item,null);
			iv=(ImageView)convertView.findViewById(R.id.item_iv);
			convertView.setTag(iv);
		}else{
			iv=(ImageView)convertView.getTag();
		}
		//判断文件是否存在
		File file=new File("mnt/sdcard/Pictures"+getFileName(imgUrlStrs[position]));
		FileInputStream fis=null;
		if(file.exists()){
			//文件已经存在 读取sd卡
			try {
				fis=new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bitmap bitmap=BitmapFactory.decodeStream(fis);
			iv.setImageBitmap(bitmap);
		}else{
			//下载
			DownloadManager.Request request=new DownloadManager.Request(Uri.parse(imgUrlStrs[position]));
			request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES,getFileName(imgUrlStrs[position]));
			//去掉下载箭头
			request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
			manager.enqueue(request);
		}
		return convertView;
	}
	
/*	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView iv;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.gly_item,null);
			iv=(ImageView)convertView.findViewById(R.id.item_iv);
			convertView.setTag(iv);
		}else{
			iv=(ImageView)convertView.getTag();
		}
		
		//填充数据  判断文件是否存在，如果文件不存在下载，如果文件已经存在从SD卡里面读取
		String fileName=getFileName(imgUrlStrs[position]);
		File file=new File("mnt/sdcard/"+getFileName(imgUrlStrs[position]));
		FileInputStream fis=null;
		if(judgeFile(fileName)){
			//文件已经存在 读取sd卡
			try {
				fis=new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bitmap bitmap=BitmapFactory.decodeStream(fis);
			iv.setImageBitmap(bitmap);
		}else{
			//文件不存在 下载
			
			new AsyncTask<String,Void,Bitmap>() {
				@Override
				protected Bitmap doInBackground(String... params) {
					// TODO Auto-generated method stub
					URL url=null;
					HttpURLConnection conn=null;
					try {
						url=new URL(params[0]);
						conn=(HttpURLConnection)url.openConnection();
						InputStream is=conn.getInputStream();
						File file=new File("mnt/sdcard/"+getFileName(params[0]));
						FileOutputStream fos=new FileOutputStream(file);
						int size=-1;
						byte[] buf=new byte[1024];
						while((size=is.read(buf))!=-1){
							fos.write(buf,0,size);
						}
						//断开连接
						conn.disconnect();
						GlyAdapter.this.notifyDataSetChanged();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
				
				
				
				
			}.execute(imgUrlStrs[position]);
			
		}
		
		return convertView;
	}*/

	

	//http://19.0.0.130:8080/dataServer/s3.jpg
	public String getFileName(String url){
		int index=url.lastIndexOf("/");
		String result=url.substring(index);
		Log.d("TAG","截取文件名："+result);
		return result;
		
	}
	
	/**
	 * true表示文件已经存在
	 * @param filename
	 * @return
	 */
	public boolean judgeFile(String filename){
		File file=new File("mnt/sdcard/"+filename);
		return file.exists();
	}
	
}
