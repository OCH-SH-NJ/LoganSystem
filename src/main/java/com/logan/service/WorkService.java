package com.logan.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.logan.SparkJob.CountLine;
import com.logan.SparkJob.PreJob;
import com.logan.pojo.Bucket;
import com.logan.pojo.DataPojo;
import com.logan.pojo.HitsPojo;
import com.logan.pojo.QueryPojo;
import com.logan.pojo.ResponsePoJo;
import com.logan.util.SparkSQLUtil;

@Service("iWorkService")
public class WorkService implements IWorkService {

	@Autowired
	private CountLine line;
	
	@Autowired
	private PreJob preJob;
	
	@Autowired
	private SparkSQLUtil sqlUtil;

	public ResponsePoJo executeQuery(String queryString) {
		QueryPojo pojo = (QueryPojo) JSON.parseObject(queryString, QueryPojo.class);
		return conventToParam(pojo);
	}

	@SuppressWarnings("rawtypes")
	private ResponsePoJo conventToParam(QueryPojo pojo) {
		HashMap<String, String> filterMap = new HashMap<>();
		String queryString = pojo.getQueryString();
		try {
			if (!queryString.equals("*")) {
				List<String> strs;
				if (queryString.contains("AND")) {
					strs = Arrays.asList(queryString.split("AND"));
				} else {
					strs = new ArrayList<>();
					strs.add(queryString);
				}
				for (String filter : strs) {
					String[] filters = filter.split(":");
					filterMap.put(filters[0].trim(), filters[1].trim());
				}
			}
		} catch (Exception e) {
			
		}
		int fetch = pojo.getSize();
		HashMap<String, HashMap> sort = pojo.getSort();
		HashMap<String, HashMap> range = pojo.getRange();
		HashMap<String, String> orderMap = new HashMap<String, String>();
		HashMap<String, HashMap> rangeMap = new HashMap<String, HashMap>();
		for (Map.Entry<String, HashMap> entry : sort.entrySet()) {
			orderMap.put(entry.getKey(), (String) entry.getValue().get("order"));
		}
		for (Map.Entry<String, HashMap> entry : range.entrySet()) {
			HashMap<Long, Long> timeRange = new HashMap<Long, Long>();
			timeRange.put((Long) entry.getValue().get("gte"), (Long) entry.getValue().get("lte"));
			rangeMap.put(entry.getKey(), timeRange);
		}
		TreeMap<Long, Long> timeMap = conventIntervalMap(range);
		handleParam(filterMap, fetch, orderMap, rangeMap, timeMap);
		return giveFakeResponse();
	}

	private ResponsePoJo handleParam(HashMap<String, String> filterMap, int fetch, HashMap<String, String> orderMap,
			HashMap<String, HashMap> rangeMap, TreeMap<Long, Long> timeMap) {
		String getLogSql = sqlUtil.getLog(filterMap, fetch, orderMap, rangeMap);
		String getTotalLogCount = sqlUtil.getTotalLogCount(filterMap, rangeMap);
		TreeMap<String, Long> getLogCountSql = new TreeMap<>();
		for (Entry<Long, Long> entry : timeMap.entrySet()) {
			String sql = sqlUtil.getCount(filterMap, entry.getKey(), entry.getValue());
			getLogCountSql.put(sql, (entry.getKey() + entry.getValue())/2);
			}
		System.out.println("getLogSql= "+getLogSql);
		System.out.println("getTotalLogCount= "+getTotalLogCount);
		System.out.println("getLogCountSql= "+getLogCountSql);
//		line.run(getLogSql, getTotalLogCount, getLogCountSql);
		return getResponse();
	}
	
	

	private ResponsePoJo getResponse() {
		List<Bucket> buckets = line.getBuckets();
		List<DataPojo> data = line.getDataPojos();
		int count = line.getLogCount();
		HitsPojo hitsPojo = new HitsPojo(data, count);
		ResponsePoJo poJo = new ResponsePoJo(buckets, hitsPojo, true);
		return poJo;
	}

	private ResponsePoJo giveFakeResponse() {
		List<Bucket> buckets = new ArrayList<Bucket>();
		Bucket bucket = new Bucket(152388717000L, 93);
		buckets.add(bucket);
		String log = "0:0:0:0:0:0:0:1 - - [10/Apr/2018:15:59:40 +0800] \"GET /LoganSystem/demo/getSimpleWork HTTP/1.1\" 405 1045";
		DataPojo dataPojo = new DataPojo("114.91.14.102 ", "bob", "2018-04-18 16:22:36.0",
				"GET /media/compressed/green.jpg HTTP/1.1\" 200 902",
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:43.0)",
				"114.91.14.102 - - [09/Mar/2018:15:09:10 +0000] \"GET /index.html HTTP/1.1\" 200 16328 \"-\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:43.0) Gecko/20100101 Firefox/43.0\"\r\n"
						+ "114.91.14.104 - bob [09/Mar/2018:15:09:11 +0000] \"GET /media/compressed/green.jpg HTTP/1.1\" 200 902 \"-\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:43.0) Gecko/20100101 Firefox/43.0\"");
		HashMap<List<DataPojo>, HashMap> hits = new HashMap<List<DataPojo>, HashMap>();
		List<DataPojo> data = new ArrayList<DataPojo>();
		data.add(dataPojo);
		HitsPojo hitsPojo = new HitsPojo(data, 8899);
		ResponsePoJo poJo = new ResponsePoJo(buckets, hitsPojo, true);
		return poJo;
	}
	private TreeMap<Long, Long> conventIntervalMap(HashMap<String, HashMap> timeRange) {
		Calendar twoDaysAgo = Calendar.getInstance();
		twoDaysAgo.add(Calendar.DATE, -2);
		Long oldestTime = twoDaysAgo.getTime().getTime();
		Long latestTime = new Date().getTime();
		for (Map.Entry<String, HashMap> entry : timeRange.entrySet()) {
			if ((Long) entry.getValue().get("gte") != null) {
				oldestTime = (Long) entry.getValue().get("gte");
			}
			if ((Long) entry.getValue().get("lte") != null) {
				latestTime = (Long) entry.getValue().get("lte");
			}
		}
		TreeMap<Long, Long> time = new TreeMap<>();
		do {
			Long times = latestTime;
			if (latestTime - 1800000 < oldestTime) {
				time.put(oldestTime, times);
				break;
			}
			time.put(times - 1800000, times);
			latestTime = latestTime - 1800000;
		} while (true);
		return time;
	}
}
