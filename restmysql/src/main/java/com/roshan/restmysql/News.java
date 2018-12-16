package com.roshan.restmysql;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class News {

	private String date;
	private String time;
	private String status;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "News [date=" + date + ", time=" + time + ", status=" + status + "]";
	}
	
	
	
	
}
