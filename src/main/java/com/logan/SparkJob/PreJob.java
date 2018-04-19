package com.logan.SparkJob;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.livy.Job;
import org.apache.livy.JobContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.springframework.stereotype.Repository;

import com.logan.pojo.Bucket;
import com.logan.pojo.DataPojo;
import com.logan.util.TimeUtil;

@Repository
public class PreJob implements Job<Double>, Function<Integer, Integer>, Function2<Integer, Integer, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int samples = 5;

	public PreJob() {
		// TODO Auto-generated constructor stub
	}

	private static HashMap<String, String> sqlColumn = new HashMap<>();
	static {
		sqlColumn.put("hostIp", "IP");
		sqlColumn.put("userName", "USER_NAME");
		sqlColumn.put("timeStamp", "CREATE_TIME");
		sqlColumn.put("reqInfo", "REQUEST");
		sqlColumn.put("agentInfo", "AGENT_INFO");
	}

	public Double call(JobContext ctx) throws Exception {
		List<Integer> sampleList = new ArrayList<Integer>();
		for (int i = 0; i < samples; i++) {
			sampleList.add(i + 1);
		}

		return 4.0d * ctx.sc().parallelize(sampleList).map(this).reduce(this) / samples;
	}

	public Integer call(Integer v1) {
		double x = Math.random();
		double y = Math.random();
		return (x * x + y * y < 1) ? 1 : 0;
	}

	public Integer call(Integer v1, Integer v2) {
		return v1 + v2;
	}

	public List<DataPojo> getLog(HashMap<String, String> filterMap, int fetch, HashMap<String, String> orderMap,
			HashMap<String, HashMap> rangeMap) {
		StringBuffer sbr = new StringBuffer("SELECT * FROM LOG_TEST2  ");
		sbr.append("WHERE");
		Boolean queryFirst = false;
		for (Entry<String, String> filter : filterMap.entrySet()) {
			if (sqlColumn.containsKey(filter.getKey())) {
				if (queryFirst) {
					sbr.append("AND");
				}
				sbr.append(" " + sqlColumn.get(filter.getKey()) + " like " + "'%" + filter.getValue() + "%' ");
				queryFirst = true;
			}
		}
		for (Entry<String, HashMap> range : rangeMap.entrySet()) {
			HashMap<Object, Object> param = range.getValue();
			for (Entry<Object, Object> queryParam : param.entrySet()) {
				if (queryFirst) {
					sbr.append("AND");
				}
				if (!range.getKey().equals("timeStamp")) {
					sbr.append(" " + sqlColumn.get(range.getKey()) + " > " + "'" + queryParam.getKey() + "' ");
					if (queryParam.getValue() != null) {
						if (queryFirst) {
							sbr.append("AND");
						}
						sbr.append(" " + sqlColumn.get(range.getKey()) + " < " + "'" + queryParam.getValue() + "' ");
					}
				} else {
					Long startTime = (Long) queryParam.getKey();
					Long endTime = (Long) queryParam.getValue();
					if (startTime == null) {
						Calendar twoDaysAgo = Calendar.getInstance();
						twoDaysAgo.add(Calendar.DATE, -2);
						startTime = twoDaysAgo.getTimeInMillis();
					}
					if (endTime == null) {
						endTime = new Date().getTime();
					}
					sbr.append(" " + sqlColumn.get(range.getKey()) + " between " + "'"
							+ TimeUtil.conventToStringTime((Long) queryParam.getKey()) + "'" + " AND '"
							+ TimeUtil.conventToStringTime((Long) queryParam.getValue()) + "' ");
				}
			}
			for (Entry<String, String> order : orderMap.entrySet()) {
				sbr.append(" ORDER BY " + sqlColumn.get(order.getKey()) + " " + order.getValue());
			}
			sbr.append(" LIMIT ").append(fetch);
		}
		System.out.println(sbr.toString());
		return null;
	}

	public int getTotalLogCount(HashMap<String, String> filterMap, HashMap<String, HashMap> rangeMap) {
		StringBuffer sbr = new StringBuffer("SELECT count(*) FROM LOG_TEST2  ");
		sbr.append("WHERE");
		Boolean queryFirst = false;
		for (Entry<String, String> filter : filterMap.entrySet()) {
			if (sqlColumn.containsKey(filter.getKey())) {
				if (queryFirst) {
					sbr.append("AND");
				}
				sbr.append(" " + sqlColumn.get(filter.getKey()) + " like " + "'%" + filter.getValue() + "%' ");
				queryFirst = true;
			}
		}
		for (Entry<String, HashMap> range : rangeMap.entrySet()) {
			HashMap<Object, Object> param = range.getValue();
			for (Entry<Object, Object> queryParam : param.entrySet()) {
				if (queryFirst) {
					sbr.append("AND");
				}
				if (!range.getKey().equals("timeStamp")) {
					sbr.append(" " + sqlColumn.get(range.getKey()) + " > " + "'" + queryParam.getKey() + "' ");
					if (queryParam.getValue() != null) {
						if (queryFirst) {
							sbr.append("AND");
						}
						sbr.append(" " + sqlColumn.get(range.getKey()) + " < " + "'" + queryParam.getValue() + "' ");
					}
				} else {
					Long startTime = (Long) queryParam.getKey();
					Long endTime = (Long) queryParam.getValue();
					if (startTime == null) {
						Calendar twoDaysAgo = Calendar.getInstance();
						twoDaysAgo.add(Calendar.DATE, -2);
						startTime = twoDaysAgo.getTimeInMillis();
					}
					if (endTime == null) {
						endTime = new Date().getTime();
					}
					sbr.append(" " + sqlColumn.get(range.getKey()) + " between " + "'"
							+ TimeUtil.conventToStringTime((Long) queryParam.getKey()) + "'" + " AND '"
							+ TimeUtil.conventToStringTime((Long) queryParam.getValue()) + "' ");
				}
			}
		}
		System.out.println(sbr.toString());
		return 0;
	}

	public Bucket getCount(HashMap<String, String> filterMap, Long gte, Long lte) {

		StringBuffer sbr = new StringBuffer("SELECT count(*) FROM LOG_TEST2  ");
		sbr.append("WHERE");
		Boolean queryFirst = false;
		for (Entry<String, String> filter : filterMap.entrySet()) {
			if (sqlColumn.containsKey(filter.getKey())) {
				if (queryFirst) {
					sbr.append("AND");
				}
				sbr.append(" " + sqlColumn.get(filter.getKey()) + " like " + "'%" + filter.getValue() + "%' ");
				queryFirst = true;
			}
		}
		sbr.append(" AND CREATE_TIME  between " + "'"
				+ TimeUtil.conventToStringTime((Long) gte) + "'" + " AND '"
				+ TimeUtil.conventToStringTime((Long) lte) + "' ");
		System.out.println(sbr.toString());
		return null;
	
	}

}