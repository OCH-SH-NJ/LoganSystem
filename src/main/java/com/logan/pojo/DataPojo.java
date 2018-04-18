package com.logan.pojo;

public class DataPojo {
	private Long timeStamp;
	private String hostIp;
	private int status;
	private String message;
	private String _source;
	
	public DataPojo(Long timeStamp, String hostIp, int status, String message, String _source) {
		super();
		this.timeStamp = timeStamp;
		this.hostIp = hostIp;
		this.status = status;
		this.message = message;
		this._source = _source;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String get_source() {
		return _source;
	}
	public void set_source(String _source) {
		this._source = _source;
	}
	
	
}
