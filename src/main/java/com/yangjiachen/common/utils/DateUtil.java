/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: DateUtil.java 
 * @Prject: yangjiachen-common
 * @Package: com.yangjiachen.common.utils 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年12月19日 上午8:11:07 
 */
package com.yangjiachen.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年12月19日 上午8:11:07
 */
public class DateUtil {
	/*
	 * 方法1：(10分) 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	 * 则返回的结果为2019-05-01 00:00:00
	 */
	public static Date getDateByInitMonth(Date date) {
		// TODO 实现代码
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		c.set(c.DAY_OF_MONTH, 1);
		c.set(c.HOUR_OF_DAY, 0);
		c.set(c.MINUTE, 0);
		c.set(c.SECOND, 0);
		return c.getTime();
	}

	/*
	 * 方法2：(10分) 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	 * 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	 * 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	 */
	public static Date getDateByFullMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(c.MONTH, 1);
		Date date2 = getDateByInitMonth(c.getTime());
		c.setTime(date2);
		c.add(c.SECOND, -1);
		return c.getTime();
	}
	

	public static void main(String[] args) {
		Date date = new Date();
		Date date2 = getDateByFullMonth(date);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String string = sf.format(date2);
		System.out.println(string);

	}
}
