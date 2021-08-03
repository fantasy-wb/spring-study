//package com.fantasy.spring.async;
//
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LogServiceImpl {
//
//
//    @Async
//    public void writeLog(SysLog sysLog) {
//        long start = System.currentTimeMillis();
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // sysLogRepository.save(sysLog);
//        long end = System.currentTimeMillis();
//        System.out.println("异步日志入库完成，耗时：" + (end - start) + "毫秒，入库内容：" + sysLog);
//    }
//
//}