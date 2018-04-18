package com.logan.pojo;

public class Bucket {
	private Long timeStamp;
	private int doc_count;

	public Bucket(Long timeStamp, int doc_count) {
		super();
		this.timeStamp = timeStamp;
		this.doc_count = doc_count;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getDoc_count() {
		return doc_count;
	}

	public void setDoc_count(int doc_count) {
		this.doc_count = doc_count;
	}

}
