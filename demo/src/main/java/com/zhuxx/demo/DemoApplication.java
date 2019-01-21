package com.zhuxx.demo;

import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//springboot的启动类
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("HELLO ");
        SpringApplication.run(DemoApplication.class, args);
    }


//   @Configuration
//    public static class QuartzConfig {
//        @Bean
//        public JobDetail teatQuartzDetail(){
//            return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();
//        }
//
//        @Bean
//        public Trigger testQuartzTrigger(){
//            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                    .withIntervalInSeconds(10)  //设置时间周期单位秒
//                    .repeatForever();
//            return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
//                    .withIdentity("testQuartz")
//                    .withSchedule(scheduleBuilder)
//                    .build();
//        }
//    }

}

