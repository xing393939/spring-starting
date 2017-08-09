package com.yihaomen.web.hello;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component 
public class MyTestServiceImpl  implements IMyTestService {  
      @Scheduled(cron="0/5 * * * * ?")   //每5秒执行一次  
      @Override  
      public void myTest() {
    	  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	  String date1= sdf1.format(new Date(System.currentTimeMillis()))+".txt";

          String contents = "1111";
          try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(date1), "utf-8"))) {
        	  	writer.write(contents);
          } catch (IOException ex) {
        	  
          }
          System.out.println("test ........." + date1);  
      }
      
      public void myTest2() {
    	  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	  String date1= sdf1.format(new Date(System.currentTimeMillis()))+".txt";

          String contents = "1111";
          try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(date1), "utf-8"))) {
        	  	writer.write(contents);
          } catch (IOException ex) {
        	  
          }
          System.out.println("test ........." + date1);  
      }
}