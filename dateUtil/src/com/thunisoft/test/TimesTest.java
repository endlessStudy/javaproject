package com.thunisoft.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;


public class TimesTest {
	static int index = 0;
	public static void main(String[] args) {
		/*
		 * thread
		 */
		
		/*
		 * timer
		 * 
		 * schedule(TimerTask task, Date time) 指定的时间执行指定的任务。
		 * schedule(TimerTask task, Date firstTime, long period) 指定的任务在指定的时间开始进行重复的固定延迟执行。
		 * schedule(TimerTask task, long delay) 指定延迟后执行指定的任务
		 * schedule(TimerTask task, long delay, long period)  指定的任务从指定的延迟后开始进行重复的固定延迟执行。
		 * scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 指定的任务在指定的时间开始进行重复的固定速率执行。
		 * scheduleAtFixedRate(TimerTask task, long delay, long period)指定的任务在指定的延迟后开始进行重复的固定速率执行。
		 */
//		timer0();
//		timer1();
//		timer2();
		timer3();
//		timer4();
		
	}
	//schedule(TimerTask task, Date firstTime, long period) 指定的任务在指定的时间开始进行重复的固定延迟执行。
	public static void timer0() {
		final Thread thread = new Thread("schedule");
		Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.HOUR_OF_DAY, 17); // 控制时
	    calendar.set(Calendar.MINUTE, 32);    // 控制分
	    calendar.set(Calendar.SECOND, 0);    // 控制秒
	 
	    Date time = calendar.getTime();     // 得出执行任务的时间,此处为今天的12：00：00
	    System.out.println(time);
	    Timer timer = new Timer("schedule");
	    timer.schedule(new TimerTask() {
	      public void run() {
	        System.out.println(thread.getName()+"-------设定要指定任务--------"+index++);
	      }
	    },time, 2000);// 设定指定的时间time,此处为2000毫秒
	  }
	 
	// 第一种方法：设定指定任务task在指定时间time执行 schedule(TimerTask task, Date time)
	  public static void timer1() {
		  System.out.println();
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	      public void run() {
	        System.out.println("-------设定要指定任务--------");
	      }
	    }, 2000);// 设定指定的时间time,此处为2000毫秒
	    timer.purge();
	  }
	 
	  // 第二种方法：设定指定任务task在指定延迟delay后进行固定延迟peroid的执行
	  // schedule(TimerTask task, long delay, long period)
	  public static void timer2() {
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
	      public void run() {
	        System.out.println("-------设定要指定任务--------");
	        for (int i = 1; i < 8; i++) {
	        	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
	      }
	    }, 1000, 5000);
	  }
	 
	  // 第三种方法：设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
	  // scheduleAtFixedRate(TimerTask task, long delay, long period)
	  public static void timer3() {
	    Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	      public void run() {
	        System.out.println("-------设定要指定任务--------");
	        for (int i = 1; i < 6; i++) {
	        	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
	      }
	    }, 1000, 1000);
	  }
	   
	  // 第四种方法：安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
	  // Timer.scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
	  public static void timer4() {
		  
		  final Thread thread = new Thread("scheduleAtFixRate");
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.HOUR_OF_DAY, 17); // 控制时
	    calendar.set(Calendar.MINUTE, 32);    // 控制分
	    calendar.set(Calendar.SECOND, 0);    // 控制秒
	 
	    Date time = calendar.getTime();     // 得出执行任务的时间,此处为今天的12：00：00
	    System.out.println(time);
	    final Timer timer = new Timer(thread.getName());
	    timer.scheduleAtFixedRate(new TimerTask() {
	      public void run() {
	        System.out.println(thread.getName()+"-------设定要指定任务--------"+index++);
	      }
	    }, time, 2000);// 这里设定将延时每天固定执行
	  }
}
