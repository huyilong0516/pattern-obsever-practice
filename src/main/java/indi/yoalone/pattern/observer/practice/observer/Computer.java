package indi.yoalone.pattern.observer.practice.observer;

import indi.yoalone.pattern.observer.core.Event;
import indi.yoalone.pattern.observer.core.EventListener;

/**
 * Created by admin on 2018/11/1.
 */
public class Computer extends EventListener {


    public void onConnect(Event event) {
        System.out.println("================获取到连接=========");
        System.out.println(event);
    }

    public void onSendMsg(Event event) {
        System.out.println("================接到到消息发送=========");
        System.out.println(event);
    }

    public void onClose(Event event) {
        System.out.println("================关闭连接=========");
        System.out.println(event);
    }
}
