package common.kodehawa.ce.event;

public class Event {

	final Object src;
	
	public Event(Object object) {
		src = object;
	}

	public Object getObj(){
		return src;
	}
}
