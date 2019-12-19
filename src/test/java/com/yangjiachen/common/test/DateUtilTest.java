/**   
 * Copyright © 2019 北京八维. All rights reserved.
 * 
 * @Title: DateUtilTest.java 
 * @Prject: yangjiachen-common
 * @Package: com.yangjiachen.common.test 
 * @Description: TODO
 * @author: 杨家琛  
 * @date: 2019年12月19日 上午8:32:25 
 */
package com.yangjiachen.common.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.yangjiachen.common.utils.DateUtil;

/**
 * @ClassName: DateUtilTest
 * @Description: TODO
 * @author:杨家琛
 * @date: 2019年12月19日 上午8:32:25
 */
public class DateUtilTest {

	
	@Test
	public void testDateUtil() {
		Date date = new Date();
		date.setMonth(1);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2 = DateUtil.getDateByFullMonth(date);
		String string = sf.format(date2);
		Date date3 = DateUtil.getDateByInitMonth(date);
		String format = sf.format(date3);
		String sql = "select * from t_order where create_time>='"+format+"' and create_time<='"+string+"' ";
		System.out.println(sql);
	}

}
