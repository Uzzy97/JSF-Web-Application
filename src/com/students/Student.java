package com.students;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {
	private String sid;
	private String cid;
	private String name;
	private String add;
	
	public Student (String sid, String cid, String name, String add){
		super();
		this.sid = sid;
		this.cid = cid;
		this.name = name;
		this.add = add;
		
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

}
