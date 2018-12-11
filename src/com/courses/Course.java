package com.courses;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class Course {
	
	private String cid;
	private String desc;
	private int dur;
	
	public Course() {
		
	}
	
	public Course (String cid, String desc, int dur){
		super();
		this.cid = cid;
		this.desc = desc;
		this.dur = dur;
		
	}
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getDur() {
		return dur;
	}

	public void setDur(int dur) {
		this.dur = dur;
	}

}
