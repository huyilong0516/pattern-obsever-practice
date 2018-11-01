package indi.yoalone.pattern.observer.core;

/**
 * Created by admin on 2018/11/1.
 */
public interface ListenerMethod {

    void onConnect(Event event);

    void onSendMsg(Event event);

    void onClose(Event event);
}
