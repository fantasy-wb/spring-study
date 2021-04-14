package com.fantasy.spring.event.order;
 
import com.fantasy.spring.event.OrderCreateEvent;
import com.fantasy.spring.event.OrderServiceImpl;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;
 
/**
* 短信监听器
 *
 * 在实现了SmartApplicationListener的监听器中，
 * 我们通过重写GetOrder方法来修改不同监听器的顺序，
 * 优先级越小，则越先被调用。通过配置不同的优先级
*/
@Component
public class SmsListener2 implements SmartApplicationListener {
 
    @Override
    public int getOrder() {
        return 2;
    }
 
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderCreateEvent.class;
    }
 
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return aClass == OrderServiceImpl.class;
    }
 
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        OrderCreateEvent event = (OrderCreateEvent) applicationEvent;
        //发送短信
        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by sms");
 
    }
 
//    @Override
//    @Async
//    public void onApplicationEvent(OrderCreateEvent event) {
//
//        //发送短信
//        System.out.println(event.getContentList().get(0) + ",您的订单:" + event.getContentList().get(1) + "创建成功! ----by sms");
//
//    }

}