/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.logan.util.livy;

/**
 * POJO class reqresenting a request for a new interactive job.
 */
public class InteractiveJobParameters {

	// Required 
	public String kind;
	// Optional
	public String proxyUser;
	public String[] jars;
	public String[] pyFiles;
	public String[] files;
	public String driverMemory;
	public int driverCores;
	public String executorMemory;
	public int executorCores;
	public int numExecutors;
	public String[] archives;

	/**
	 * Constructor
	 * @param sessionKind 
	 */
	public InteractiveJobParameters(SessionKind sessionKind) {
		kind = sessionKind.toString();
	}

	@Override
	public String toString() {
		return "";
	}
}
