package indi.yoalone.pattern.observer.practice;


import indi.yoalone.pattern.observer.core.EventListener;
import indi.yoalone.pattern.observer.core.EventType;

/**
 * Created by admin on 2018/11/1.
 */
public class Keyboard extends EventListener.EventTrigger {


    public void connect() {
        System.out.println("键盘开始连接到电脑。。。");
    }

    public void sendMsg() {
        System.out.println("键盘开始工作。。");
    }

    public void close() {
        System.out.println("键盘断开连接。");
    }
}
