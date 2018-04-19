package com.logan.pojo;

import java.util.List;

public class HitsPojo {
	private List<DataPojo> data;
	private int total;

	public List<DataPojo> getData() {
		return data;
	}
	public void setData(List<DataPojo> data) {
		this.data = data;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public HitsPojo(List<DataPojo> dataPojos, int total) {
		super();
		this.data = dataPojos;
		this.total = total;
	}
	
}
