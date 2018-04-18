package com.logan.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class ResponsePoJo {
	private List<Bucket> buckets;
	private HitsPojo hits;
	private boolean success;
	
	
	public ResponsePoJo(List<Bucket> buckets, HitsPojo hits, boolean success) {
		super();
		this.buckets = buckets;
		this.hits = hits;
		this.success = success;
	}


	public List<Bucket> getBuckets() {
		return buckets;
	}


	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}


	public HitsPojo getHits() {
		return hits;
	}


	public void setHits(HitsPojo hits) {
		this.hits = hits;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}



	
	
}
