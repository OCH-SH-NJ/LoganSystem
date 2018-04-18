package com.logan.pojo;

import java.util.HashMap;
import com.alibaba.fastjson.JSON;
public class QueryPojo {
	private String queryString;
	private int size;
	private HashMap<String, String> date_histogram;
	private HashMap<String, HashMap> sort;
	private HashMap<String, HashMap> range;
	
	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public HashMap<String, String> getDate_histogram() {
		return date_histogram;
	}

	public void setDate_histogram(HashMap<String, String> date_histogram) {
		this.date_histogram = date_histogram;
	}

	public HashMap<String, HashMap> getSort() {
		return sort;
	}

	public void setSort(HashMap<String, HashMap> sort) {
		this.sort = sort;
	}

	public HashMap<String, HashMap> getRange() {
		return range;
	}

	public void setRange(HashMap<String, HashMap> range) {
		this.range = range;
	}

	public static void main(String[] args) {
		QueryPojo pojo = new QueryPojo();
		pojo.setQueryString("status:200");
		pojo.setSize(500);
		HashMap<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("order", "desc");
		HashMap<String, HashMap> sort = new HashMap<String, HashMap>();
		sort.put("timestamp", queryMap);
		pojo.setSort(sort);
		
		HashMap<String, Object> queryMap1 = new HashMap<String, Object>();
		queryMap1.put("gte", 1523808000000L);
		queryMap1.put("lte", 1523894399999L);
		queryMap1.put("format", "epoch_millis");
		HashMap<String, HashMap> range = new HashMap<String, HashMap>();
		range.put("timestamp", queryMap1);
		pojo.setRange(range);
		
		HashMap<String, String> date_histogram = new HashMap<String, String>();
		date_histogram.put("field", "timestamp");
		date_histogram.put("interval", "30m");
		
		pojo.setDate_histogram(date_histogram);
		String intarrJSON = JSON.toJSONString(pojo);  
        System.out.println(intarrJSON);  
	}
}
