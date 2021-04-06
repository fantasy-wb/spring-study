package com.fantasy.spring.event;
 
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
 
/**
* 短信监听器
* ApplicationListener是无序的
*/
@Component
public class SmsListener implements ApplicationListener<OrderCreateEvent> {
 
    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        //发送短信
        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by sms");
 
    }
}