package com.fantasy.spring.event.order;
 
import com.fantasy.spring.event.OrderCreateEvent;
import com.fantasy.spring.event.OrderServiceImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;
 
/**
* 微信监听器
* SmartApplicationListener可以设置顺序等
*/
@Component
public class WechatListener2 implements SmartApplicationListener {
 
    //设置监听优先级
    @Override
    public int getOrder() {
        return 1;
    }
 
    //监听器智能所在之一，能够根据事件类型动态监听
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderCreateEvent.class;
    }
 
    //监听器智能所在之二，能够根据事件发布者类型动态监听
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == OrderServiceImpl.class;
    }
 
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderCreateEvent event = (OrderCreateEvent) applicationEvent;
        //发送微信
        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by wechat");
 
    }
 
//    @Override
//    @async
//    public void onApplicationEvent(OrderCreateEvent event) {
//
//        //发送微信
//        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by wechat");
//
//    }
}