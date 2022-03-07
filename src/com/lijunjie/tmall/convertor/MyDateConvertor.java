package com.lijunjie.tmall.convertor;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lijunjie
 * @version 1.0
 * @date 2019/1/10 19:47
 */
public class MyDateConvertor implements Converter<String, Date> {
	/*
	 * @Override public String convert(Date d) { DateFormat dateFormat = new
	 * SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); try { // 日期转换成功 return
	 * dateFormat.format(d); } catch (Exception e) { e.printStackTrace(); } return
	 * null; }
	 */

	@Override
	public Date convert(String s) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		try { // 日期转换成功 return
			dateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 转换失败，返回null
		return null;
	}

}
