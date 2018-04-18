package com.logan.pojo;

import java.util.List;

public class HitsPojo {
	private List<DataPojo> dataPojos;
	private int total;
	public List<DataPojo> getDataPojos() {
		return dataPojos;
	}
	public void setDataPojos(List<DataPojo> dataPojos) {
		this.dataPojos = dataPojos;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public HitsPojo(List<DataPojo> dataPojos, int total) {
		super();
		this.dataPojos = dataPojos;
		this.total = total;
	}
	
}
