package com.lfy.common.utils;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testGegAge() {
		Calendar c = Calendar.getInstance();
		c.set(2000,12,01);
		
		System.out.println(DateUtil.getAge(c.getTime()));
	}

	@Test // 月初
	public void testGetDateByInitMonth() {
		Calendar c = Calendar.getInstance();
		c.set(2018, 2, 23, 12, 12, 28);

		Date date = DateUtil.getDateByInitMonth(c.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(df.format(date));
	}

	@Test
	public void testGetDateByFullMonth() {

		Date dateByFullMonth = DateUtil.getDateByFullMonth(new Date());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(dateByFullMonth));

	}

	/**
	 * 拼接下面根据时间范围查询订单的SQL： String sql = "select * from t_order where
	 * create_time>='{1}' and create_time<='{2}' ";
	 * 将上面{1}的位置使用DateUtil工具类中的getDateByInitMonth()返回值替换，
	 * 将上面{2}的位置使用DateUtil工具类中的getDateByFullMonth()返回值替换。最后打印出正确拼接的SQL字符串。
	 * 
	 * @Title: testSQl
	 * @Description: TODO
	 * @return: void
	 */
	@Test
	public void testSQl() {
		// 月初
		Date initMonth = DateUtil.getDateByInitMonth(new Date());

		// 月末
		Date fullMonth = DateUtil.getDateByFullMonth(new Date());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}'";

		// 替换后的结果
		String sql2 = sql.replace("{1}", df.format(initMonth)).replace("{2}", df.format(fullMonth));
		System.out.println(sql2);

	}



}
