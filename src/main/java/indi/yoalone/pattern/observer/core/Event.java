package indi.yoalone.pattern.observer.core;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/11/1.
 */
public class Event {

    private EventType eventType;

    private TriggerMethod observer;

    private Component source;

    private Method trigger;

    public Event(EventType eventType, TriggerMethod observer, Method trigger) {
        this.eventType = eventType;
        this.observer = observer;
        this.trigger = trigger;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public TriggerMethod getObserver() {
        return observer;
    }

    public void setObserver(TriggerMethod observer) {
        this.observer = observer;
    }

    public Method getTrigger() {
        return trigger;
    }

    public void setTrigger(Method trigger) {
        this.trigger = trigger;
    }

    public Component getSource() {
        return source;
    }

    public void setSource(Component source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                ", observer=" + observer +
                ", source=" + source +
                ", trigger=" + trigger +
                '}';
    }
}
