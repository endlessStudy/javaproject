package com.thunisoft.test.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service
public class SpringTask{
	static{
		System.out.println("123465");
	}
	 //@Scheduled(cron="0/3 * *  * * ? ")   //每10秒执行一次      
     public void taskTest(){      
          DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
          System.out.println(sdf.format(new Date())+"*********A任务每10秒执行一次进入测试");      
     }   
}
