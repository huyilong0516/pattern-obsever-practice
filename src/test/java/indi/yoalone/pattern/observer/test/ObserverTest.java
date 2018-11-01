package indi.yoalone.pattern.observer.test;

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
        Keyboard keyboard = new Keyboard();

        keyboard.connect();
        mouse.connect();

        mouse.sendMsg();
        keyboard.sendMsg();

        keyboard.close();

        mouse.close();

    }
}
