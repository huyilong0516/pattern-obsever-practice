package indi.yoalone.pattern.observer.practice;

import indi.yoalone.pattern.observer.core.EventListener;
import indi.yoalone.pattern.observer.core.EventType;

/**
 * Created by admin on 2018/11/1.
 */
public class Mouse extends EventListener.EventTrigger {



    public void connect() {
        System.out.println("鼠标开始连接到电脑。。。");
    }

    public void sendMsg() {
        System.out.println("鼠标开始工作。。");
    }

    public void close() {
        System.out.println("鼠标断开连接。");
    }
}
