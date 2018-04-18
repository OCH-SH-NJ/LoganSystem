package com.logan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.logan.pojo.Bucket;
import com.logan.pojo.DataPojo;
import com.logan.pojo.HitsPojo;
import com.logan.pojo.QueryPojo;
import com.logan.pojo.ResponsePoJo;
import com.logan.util.SparkWorkFlow;

@Service("iWorkService")
public class WorkService implements IWorkService {

	@Autowired  
	private SparkWorkFlow workFlow;
	
	public ResponsePoJo executeQuery(String queryString) {
		QueryPojo pojo = (QueryPojo) JSON.parseObject(queryString,QueryPojo.class);
		System.out.println(pojo.getRange());
		return giveFakeResponse();
	}
	
	private ResponsePoJo giveFakeResponse() {
		List<Bucket> buckets = new ArrayList<Bucket>();
		Bucket bucket = new Bucket(152388717000L, 93);
		buckets.add(bucket);
		String log = "0:0:0:0:0:0:0:1 - - [10/Apr/2018:15:59:40 +0800] \"GET /LoganSystem/demo/getSimpleWork HTTP/1.1\" 405 1045";
		DataPojo dataPojo = new DataPojo(152388717000L, "180.112.191.192", 200, "okhttp/3.9.1", log);
		HashMap<List<DataPojo>, HashMap> hits = new HashMap<List<DataPojo>, HashMap>();
		List<DataPojo> dataPojos = new ArrayList<DataPojo>();
		dataPojos.add(dataPojo);
		HitsPojo hitsPojo = new HitsPojo(dataPojos, 8899);
		ResponsePoJo poJo = new ResponsePoJo(buckets, hitsPojo, true);
		return poJo;
	}

	
}
