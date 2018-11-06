package indi.yoalone.pattern.observer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 2018/11/1.
 */
public abstract class EventListener implements ListenerMethod {


//    private final static Map<EventType, Event> eventsMap =





    public void addListener() {
        for (EventType eventType : EventType.values()) {
            for (Method m : this.getClass().getMethods()) {
                if (m.getName().toLowerCase().contains(eventType.name().toLowerCase())) {
                    addListener(new Event(eventType, this, m));
                }
            }
        }

    }


    private void addListener(Event event) {
        EventTrigger.eventsMap.put(event.getEventType(), event);
    }


    public static abstract class EventTrigger implements TriggerMethod {

        private final static Map<EventType, Event> eventsMap = new ConcurrentHashMap<EventType, Event>(6);




        private void trigger(EventType type) {
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


    public static class EventTriggerProxy implements InvocationHandler {

        private EventTrigger trigger;

        private EventTriggerProxy(EventTrigger trigger) {
            this.trigger = trigger;
        }

        public static TriggerMethod getInstance(EventTrigger trigger) {
            return (TriggerMethod) Proxy.newProxyInstance(trigger.getClass().getClassLoader(), EventTrigger.class.getInterfaces(), new EventTriggerProxy(trigger));
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            method.invoke(trigger, (Object[]) null);
            trigger.trigger(EventType.valueOf(method.getName().toUpperCase()));
            return null;
        }
    }
}
