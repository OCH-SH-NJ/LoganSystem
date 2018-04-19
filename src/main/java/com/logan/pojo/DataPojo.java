package com.logan.pojo;

public class DataPojo {

	private String hostIp;
	private String userName;
	private String timeStamp;
	private String reqInfo;
	private String agentInfo;
	private String resource;

	public DataPojo(String hostIp, String userName, String timeStamp, String reqInfo, String agentInfo,
			String resource) {
		super();
		this.hostIp = hostIp;
		this.userName = userName;
		this.timeStamp = timeStamp;
		this.reqInfo = reqInfo;
		this.agentInfo = agentInfo;
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getReqInfo() {
		return reqInfo;
	}

	public void setReqInfo(String reqInfo) {
		this.reqInfo = reqInfo;
	}

	public String getAgentInfo() {
		return agentInfo;
	}

	public void setAgentInfo(String agentInfo) {
		this.agentInfo = agentInfo;
	}

}
