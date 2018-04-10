package com.example.les_intent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{
	int pid;
	String pname;
	String psex;
	
	public Person() {
	}
	
	public Person(int pid,String pname) {
		this.pid=pid;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public static final Parcelable.Creator<Person> CREATOR=new Parcelable.Creator<Person>() {
		
		@Override
		public Person[] newArray(int size) {
			//打酱油
			return null;
		}
		
		@Override
		public Person createFromParcel(Parcel source) {
			// 读取对象值 读取值顺序根据写入的顺序决定
			Person p=new Person();
			p.pid=source.readInt();
			p.pname=source.readString();
			p.psex=source.readString();
			return p;
		}
	};
	
	@Override
	public int describeContents() {
		//打酱油
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		//写入对象值
		dest.writeInt(this.pid);
		dest.writeString(this.psex);
		dest.writeString(this.pname);
//		若对象的一个属性还是一个对象的话，可以将其封装为Map类型添加进去
//		dest.writeMap(val);
	}
	
}
