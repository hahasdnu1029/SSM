package com.sdnu.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StrToDateConvert implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		//定义日期转换格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
