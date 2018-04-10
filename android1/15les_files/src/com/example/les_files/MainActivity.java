package com.example.les_files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * 文件浏览器
 * 游标适配器 sqlite方法
 * @author kulv16
 *
 */
public class MainActivity extends Activity {

	//根目录
	File root;
	//文件目录
	ListView lv;
	
	//根目录文件对象集合
	List<File> currentList=new ArrayList<File>();
	
	//文件适配器
	FileAdapter adapter;
	
	//当前选择的目录
	File currentFile;
	
	//堆栈 用来保存文件打开的路径
	Stack<File> stack=new Stack<File>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView)findViewById(R.id.lv);
		
		
		
		//获得根目录的文件对象
		root=new File("mnt/sdcard");
		
		//压入根目录
		stack.push(root);
		
		//列出根目录下面所有文件和文件夹
		File[] files=((File)stack.lastElement()).listFiles();
		//把根目录下面的所有文件放到list
		for (int i = 0; i < files.length; i++) {
			currentList.add(files[i]);
		}
		adapter=new FileAdapter(this,currentList);
		lv.setAdapter(adapter);
		
		//列表点击事件
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				Log.d("TAG","堆栈长度："+stack.size());
				
				//当前所在根目录
				if(stack.size()==1){
					//从当前列表里面获得选中文件对象
					currentFile=currentList.get(position);
					//把当前选中文件对象加入到堆栈
					stack.push(currentFile);
					//列出当前目录
					getList(currentFile,true);
				}else{
					//当前所在子目录 返回上一级
					if(position==0){
						//返回上一级 弹栈 
						stack.pop();
						//获得父级目录对象
						currentFile=stack.get(stack.size()-1);
						
						
						if(stack.size()==1){
							//如果父级目录是根目录不需要添加返回上一级
							getList(currentFile,false);							
						}else{
							//如果父级目录是子目录需要添加返回上一级
							getList(currentFile, true);
						}

					}else{
						//进入子目录 
						//从当前列表里面获得选中文件对象
						currentFile=currentList.get(position);
						//压栈
						stack.push(currentFile);
						//列出当前目录
						getList(currentFile,true);
					}
				}
				//如果是根目录没有返回上一级 如果是子目录添加返回
				//列出当前选择目录下面的子目录
				/*if(stack.size()==1){
					//根目录
					getList(currentFile,false);
				}else{
					//不是根目录 添加返回
					getList(currentFile,true);
				}*/
				
				//刷新适配器
				adapter.notifyDataSetChanged();
				
			}
		});
	}

	//遍历目录
	public void getList(File file,boolean flag){
		File[] files=file.listFiles();
		currentList.clear();
		//flag为true表示是子目录
		if(flag){
			currentList.add(new File("","返回上一级"));
		}
		//把根目录下面的所有文件放到list
		for (int i = 0; i < files.length; i++) {
			currentList.add(files[i]);
		}
		
	}
	
}
