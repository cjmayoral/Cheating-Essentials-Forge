package common.kodehawa.ce.mevents;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;

import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.mevents.classes.EventRender;
import common.kodehawa.ce.mevents.classes.EventTick;

public class EventManager {

	public HashMap<Class<? extends Event>, CopyOnWriteArrayList<Listener>> events = new HashMap<Class<? extends Event>, CopyOnWriteArrayList<Listener>>();
	private volatile static EventManager instance = new EventManager();
	
    public EventManager(){
    	events.put(EventTick.class, new CopyOnWriteArrayList<Listener>());
    	events.put(EventRender.class, new CopyOnWriteArrayList<Listener>());
    }
    
    public void registerListener(Class<? extends Event> clazz, Listener l){
    	if(events.containsKey(clazz)){
    		List list = events.get(clazz);
    		if(!list.contains(l)){
    			list.add(l);
    		}
    	}
    }
    
    public void unregisterListener(Class<? extends Event> clazz, Listener l){
    	if(events.containsKey(clazz)){
    		List list = events.get(clazz);
    		if(list.contains(l)){
    			list.remove(l);
    		}
    	}
    }
    
    public Event fire(Event evt){
    	//System.out.println("Fired event: " + evt);
    	if(events.containsKey(evt.getClass())){
    		List<Listener> list = events.get(evt.getClass());
    		
    		for(Listener listener : list){
    			try{
    				listener.onEvent(evt);
    			}
    			catch(Exception e){
    				e.printStackTrace();
    			}
    		}
    	}
    	else{
    		DynamicLogger.instance().writeLog("Event not recognized!", Level.WARNING);
    	}
    	return evt;
    }
    
    public static EventManager instance(){
    	return instance;
    }
}
