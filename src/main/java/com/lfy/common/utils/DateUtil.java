package com.lfy.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil 
 * @Description:日期工具类
 * @author:charles 
 * @date: 2019年10月11日 下午6:43:17
 */
public class DateUtil {
	
	public static Date getDateByBefore() {
		// TODO Auto-generated method stub
		Date newdate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(newdate);
		c.add(Calendar.DAY_OF_YEAR, -1);
		return c.getTime();
	}
	
	/**
	 * 
	 * @Title: getAge 
	 * @Description: 根据生日计算年龄
	 * @param birthday
	 * @return
	 * @return: int
	 */
	public static int getAge(Date birthday) {
		// 获取当前系统的日历类
		Calendar c = Calendar.getInstance();
		// 获取当前年月日
		int yearNow = c.get(Calendar.YEAR);
		int monthNow = c.get(Calendar.MONTH);
		int dateNow = c.get(Calendar.DAY_OF_MONTH);
		c.setTime(birthday);// 用生日初始化日历类
		int yearBirth = c.get(Calendar.YEAR);
		int monthBirth = c.get(Calendar.MONTH);
		int dateBirth = c.get(Calendar.DAY_OF_MONTH);
		// 年龄 1990-02-10 2019-02-08
		int age = yearNow - yearBirth;
		// 出生月份大于前月份 年龄减少1
		if (monthBirth > monthNow) {
			age--;
		}
		// 如果月份一致并且 日期大于当前日期 年龄减少1
		if (monthBirth == monthNow && dateBirth > dateNow) {
			age--;
		}
		return age;
		
	}
	
	/**
	 * 返回个在minDate和maxDAte之间的随机日期
	 * @Title: getDate 
	 * @Description: TODO
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @return: Date
	 */
	public static Date getDate(Date minDate ,Date maxDate) {
		
		//最小毫秒数
		long min = minDate.getTime();
		long max = maxDate.getTime();
		long x =(long) ((Math.random() * (max -min +1)) +min);
		return new Date(x);
		
	}
	/*
	* 方法1：(5分)  返回给定日期的月初
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/
	public static Date getDateByInitMonth(Date src){
		//获取日历类
		Calendar c = Calendar.getInstance();
	
		//用传入的日期实例化日历类
		c.setTime(src);
		//改变日期设置为月初 1号的00:00:00
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	//TODO 实现代码
	}
	/*
	* 方法2：(5分)  //返回给定日期的月末
	* 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/
	//TODO 实现代码
	public static Date getDateByFullMonth(Date src){
		//思路:让传入的月份+1,再把日 小时 分钟 妙都设置为0,最后,再让日期减去1秒
		//获取日历类
		Calendar c = Calendar.getInstance();
		//让传入的日期初始化日历类
		c.setTime(src);
		//让月份加1
		c.add(Calendar.MONTH, 1);
		//调用月初的工具类返回月初
		Date date = getDateByInitMonth(c.getTime());
		//用月初的初始化类
		c.setTime(date);
		//让日期减去1秒
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	
	}

}
