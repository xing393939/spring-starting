package com.yihaomen.web.hello;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;

public class AsyncTask {

    @Async
    public void doSomeHeavyBackgroundTask(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    @Async
    public Future<String> doSomeHeavyBackgroundTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void printLog() {
        System.out.println("  i print a log  ,time=" + System.currentTimeMillis());
    }
 }