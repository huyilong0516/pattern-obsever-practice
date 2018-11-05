package indi.yoalone.pattern.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 2018/11/1.
 */
public abstract class EventListener implements ListenerMethod {


//    private final static Map<EventType, Event> eventsMap =





    public void addListener() {
        try {
            addListener(new Event(EventType.TRIGGER_START, this, this.getClass().getMethod("onConnect", Event.class)));
            addListener(new Event(EventType.TRIGGER_PROCESS, this, this.getClass().getMethod("onSendMsg", Event.class)));
            addListener(new Event(EventType.TRIGGER_END, this, this.getClass().getMethod("onClose", Event.class)));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    private void addListener(Event event) {
        EventTrigger.eventsMap.put(event.getEventType(), event);
    }


    public static abstract class EventTrigger implements TriggerMethod {

        private final static Map<EventType, Event> eventsMap = new ConcurrentHashMap<EventType, Event>(6);





        protected void trigger(EventType type) {
            if (!eventsMap.containsKey(type)) {
                return;
            }
            Event event = eventsMap.get(type);
            event.setSource(this);
            Object observer = event.getObserver();
            try {
                event.getTrigger().invoke(observer, event);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }
}
