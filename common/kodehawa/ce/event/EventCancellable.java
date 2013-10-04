package common.kodehawa.ce.event;

public class EventCancellable extends Event {

	boolean cancelated;
	
	public EventCancellable(Object o) {
		super(o);
	}

	public void cancel(boolean state){
		cancelated = state;
	}

	public boolean isCancelled(){
		return cancelated;
	}
}
