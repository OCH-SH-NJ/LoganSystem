package com.logan.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;
@Repository
public class SparkSQLUtil {
	
	private static HashMap<String, String> sqlColumn = new HashMap<>();
	static {
		sqlColumn.put("hostIp", "IP");
		sqlColumn.put("userName", "USER_NAME");
		sqlColumn.put("timeStamp", "CREATE_TIME");
		sqlColumn.put("reqInfo", "REQUEST");
		sqlColumn.put("agentInfo", "AGENT_INFO");
	}

	
	public String getLog(HashMap<String, String> filterMap, int fetch, HashMap<String, String> orderMap,
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
		//System.out.println("getLog= "+sbr.toString());
		return sbr.toString();
	}

	public String getTotalLogCount(HashMap<String, String> filterMap, HashMap<String, HashMap> rangeMap) {
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
		//System.out.println("getTotalLogCount= "+sbr.toString());
		return sbr.toString();
	}

	public String getCount(HashMap<String, String> filterMap, Long gte, Long lte) {

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
		//System.out.println("getCount= "+sbr.toString());
		return sbr.toString();
	
	}

}
