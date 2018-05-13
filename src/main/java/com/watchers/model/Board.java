package com.watchers.model;

import java.sql.Timestamp;

public class Board {
	private int idx;
	private String id;
	private Long num;
	private String title;
	private String contents;
	private Timestamp firstDate;
	private Timestamp renewalDate;
	private Long tag;
	private String createdAt;
	private String createdId;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getFirstDate() {
		return firstDate;
	}
	public void setFirstDate(Timestamp firstDate) {
		this.firstDate = firstDate;
	}
	public Timestamp getRenewalDate() {
		return renewalDate;
	}
	public void setRenewalDate(Timestamp renewalDate) {
		this.renewalDate = renewalDate;
	}
	public Long getTag() {
		return tag;
	}
	public void setTag(Long tag) {
		this.tag = tag;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	
	@Override
	public String toString() {
		return "id : "  + id  + "\n"+ "title : "+ title + " \n "  + "content : " + contents
				+ "firstDate : " + firstDate;
	}
}
