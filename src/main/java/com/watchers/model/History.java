package com.watchers.model;

import java.sql.Timestamp;

public class History {
	
	private String id;
	private Long similarity;
	private Long accuracy;
	private Timestamp inputTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getSimilarity() {
		return similarity;
	}
	public void setSimilarity(Long similarity) {
		this.similarity = similarity;
	}
	public Long getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Long accuracy) {
		this.accuracy = accuracy;
	}
	public Timestamp getInputTime() {
		return inputTime;
	}
	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
