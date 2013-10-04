package common.kodehawa.ce.event;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventManager {

    private Map<Object, LinkedList<Method>> listeners = new ConcurrentHashMap<Object, LinkedList<Method>>();
    private static volatile EventManager instance = new EventManager();
    
    public void register(Object object){
    	Method[] methods = object.getClass().getDeclaredMethods();
    	LinkedList<Method> listen = new LinkedList<Method>();
    	for(Method method : methods){
    		if(method.isAnnotationPresent(Listener.class)){
        		listen.add(method);
    		}
    	}
    	synchronized(listeners){
        	listeners.put(object, listen);
    	}
    }
    
    public void unregister(Object object){
    	synchronized(listeners){
    		for(Map.Entry<Object, LinkedList<Method>> map : listeners.entrySet()){
    			if(map.getKey().equals(object)){
    				listeners.remove(map.getKey());
    			}
    		}
    	}
    }
    
    public void call(Event event){
		synchronized(listeners){
			for(Map.Entry<Object, LinkedList<Method>> map : listeners.entrySet()){
				List<Method> list = map.getValue();
			    //System.out.println("Listener called: "+event+"!");
			    for(Method method : list){
			    	Listener listenerEvent = method.getAnnotation(Listener.class);
				    if(listenerEvent.eventToLoad().equals(event.getClass())){
				    	method.setAccessible(true);
				    	try{
				    		if(method.getAnnotatedParameterTypes().length == 0){
				    			method.invoke(map.getKey());
						    }
				    		if(method.getAnnotatedParameterTypes().length == 1){
				    			method.invoke(map.getKey(), event);
						    }
				    	}	
				    	catch(Exception exception){
				    		exception.printStackTrace();
						}
				    }
			    }
		    }
		}}
	
    public static EventManager instance(){
    	return instance;
    }
}
