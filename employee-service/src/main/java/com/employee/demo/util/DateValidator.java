
package com.employee.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {
	public static boolean isvalidformat(String format,String value)
	{
		Date date=null;
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			date=sdf.parse(value);
			if(!value.equals(sdf.format(date))) {
				date=null;
			}
		}
		catch (ParseException e) {
			System.out.println("Date format is not valid");
		}
		return date!=null;
	}
}