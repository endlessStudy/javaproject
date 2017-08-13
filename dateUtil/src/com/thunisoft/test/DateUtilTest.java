package com.thunisoft.test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

public class DateUtilTest {
	public static void main(String[] args) {
		
		/*
		 * DateFormatUtils 日期和时间的格式化工具和常量。
		 * DateUtils 使用日历和Date对象的一组实用工具。
		 * DurationFormatUtils 持续格式化实用程序和常量。
		 * FastDateFormat FastDateFormat是SimpleDateFormat的一种快速且线程安全的版本。
		 * StopWatch 秒表为计时提供了一个方便的API。
		 */
		
	}
	/*
	 * 
	 */
	public void printFormatDate(Date date){
		System.out.println(DateFormatUtils.format(date,"yyyy-MM-dd HH:mm:ssZZ"));
		
	}
	/*
	 * getFragmentInSeconds
	 * isSameDay
	 * isSameInstant
	 * iterator
	 * round
	 */
	@Test
	public void dateUtilsTest() throws ParseException{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(DateUtils.addDays(date, 2));
		System.out.println(DateFormatUtils.format(DateUtils.addDays(date, 2),"yyyy-MM-dd HH:mm:ssZZ"));
		printFormatDate(DateUtils.ceiling(date, Calendar.ERA));
		printFormatDate(DateUtils.ceiling(date, Calendar.MONTH));
		printFormatDate(DateUtils.ceiling(date, Calendar.YEAR));
		//======
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println(DateUtils.getFragmentInDays(calendar, Calendar.YEAR));
		System.out.println(DateUtils.getFragmentInDays(calendar, Calendar.HOUR_OF_DAY));
		System.out.println(DateUtils.getFragmentInDays(calendar, Calendar.MONTH));
		
		printFormatDate(DateUtils.parseDate("2017-01-01",new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ssZZ"}));
		/*Iterator<Calendar> iterator =  DateUtils.iterator(calendar, Calendar.MONTH);
		if (iterator.hasNext()){
			printFormatDate(new Date(iterator.next().getTimeInMillis()));
		}*/
	}
	
	/*
	 * public static String format(long millis, String pattern, TimeZone timeZone)
	 */
	@Test
	public void dateFormatUtilsTest(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String string2 = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		System.out.println("Calendar==========>"+calendar.getTimeZone().getID());
		System.out.println("Calendar==========>"+DateFormatUtils.format(calendar, "yyyy-MM-dd HH:mm:ssZZ"));
		System.out.println("CalendarLocal==========>"+DateFormatUtils.format(calendar, "yyyy-MM-dd HH:mm:ssZZ",Locale.ENGLISH));
		System.out.println("Date==============>"+date);
		System.out.println(DateFormatUtils.formatUTC(date, "yyyy-MM-dd HH:mm:ssZZ"));
		System.out.println("format(date)======>"+string2);
	}
}
