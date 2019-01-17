package com.zhuxx.demo;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class TestQuartz extends QuartzJobBean {
    /**
     * 执行定时任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("zhuxx的生命减少了 "+new Date());
    }
}


