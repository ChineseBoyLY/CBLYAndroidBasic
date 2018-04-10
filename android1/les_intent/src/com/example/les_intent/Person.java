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
			//����
			return null;
		}
		
		@Override
		public Person createFromParcel(Parcel source) {
			// ��ȡ����ֵ ��ȡֵ˳�����д���˳�����
			Person p=new Person();
			p.pid=source.readInt();
			p.pname=source.readString();
			p.psex=source.readString();
			return p;
		}
	};
	
	@Override
	public int describeContents() {
		//����
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		//д�����ֵ
		dest.writeInt(this.pid);
		dest.writeString(this.psex);
		dest.writeString(this.pname);
//		�������һ�����Ի���һ������Ļ������Խ����װΪMap������ӽ�ȥ
//		dest.writeMap(val);
	}
	
}
