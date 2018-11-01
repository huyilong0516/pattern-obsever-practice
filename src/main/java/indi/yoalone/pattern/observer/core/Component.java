package indi.yoalone.pattern.observer.core;

/**
 * Created by admin on 2018/11/1.
 */
public interface Component {

    void connect();

    void sendMsg();

    void close();
}
