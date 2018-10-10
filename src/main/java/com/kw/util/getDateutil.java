package com.kw.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getDateutil {
	
	public static java.sql.Date getdate(){ //获取当前时间转换为sql时间
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String time=sdf.format(date);
		java.sql.Date pubtime=java.sql.Date.valueOf(time);
		return pubtime;
	}
	
	public static void main(String[] args) {
		System.out.println(getDateutil.getdate());
	}
}
