package com.yihaomen.web.hello;

import org.springframework.scheduling.annotation.Scheduled;  
import org.springframework.stereotype.Component;  
  
@Component("ScheduleTest")
public class ScheduleTest {  
    @Scheduled(cron = "0/5 * * * * ?")  
    public void job1() {
    	System.out.println("test async");  
    }
}