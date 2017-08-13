package com.thunisoft.test.spring;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
@Service
public class SpringQuartz extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		System.out.println("定时任务开始。。。。。。");
	}

}
