package indi.yoalone.pattern.observer.test;

import indi.yoalone.pattern.observer.core.EventListener;
import indi.yoalone.pattern.observer.core.TriggerMethod;
import indi.yoalone.pattern.observer.practice.Keyboard;
import indi.yoalone.pattern.observer.practice.Mouse;
import indi.yoalone.pattern.observer.practice.observer.Computer;

/**
 * Created by admin on 2018/11/1.
 */
public class ObserverTest {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.addListener();

        Mouse mouse = new Mouse();
        TriggerMethod mouseProxy = EventListener.EventTriggerProxy.getInstance(mouse);
        Keyboard keyboard = new Keyboard();
        TriggerMethod keyboardProxy = EventListener.EventTriggerProxy.getInstance(keyboard);

        keyboardProxy.connect();
        mouseProxy.connect();

        mouseProxy.sendMsg();
        keyboardProxy.sendMsg();

        keyboardProxy.close();

        mouseProxy.close();

    }
}
