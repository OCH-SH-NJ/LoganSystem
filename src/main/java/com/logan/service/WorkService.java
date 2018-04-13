package com.logan.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logan.util.SparkWorkFlow;

@Service("iWorkService")
public class WorkService implements IWorkService {

	@Autowired  
	private SparkWorkFlow workFlow;
	
	public String getTotalLogCount() throws IOException, URISyntaxException, InterruptedException, ExecutionException {
		return String.valueOf(workFlow.testSparkWork());
	}

	public String deleteLog() {
		// TODO Auto-generated method stub
		return "delete successful";
	}

	public String getLogType(int id) {
		return "Log type = eoe";
	}

}
