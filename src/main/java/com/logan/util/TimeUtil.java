package com.logan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeUtil {
	public static Long conventToLongTime(String stringTime) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		long longTime = simpleDateFormat.parse(stringTime).getTime();
		return longTime;
	}
	
	public static String conventToStringTime(Long longTime) {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		 return formatter.format(longTime);
	}
}
