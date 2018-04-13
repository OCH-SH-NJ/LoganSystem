package com.logan.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

public interface IWorkService {

	 public String getTotalLogCount() throws IOException, URISyntaxException, InterruptedException, ExecutionException;

	 public String deleteLog();

	 public String getLogType(int id);
	 
	 
	
	
}
