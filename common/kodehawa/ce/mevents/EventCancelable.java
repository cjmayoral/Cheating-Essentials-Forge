package common.kodehawa.ce.mevents;

public class EventCancelable extends Event {

	boolean cancelled = false;
	
	public EventCancelable(Object arg0) {
		super(arg0);
	}

	public boolean isCancelled(){
		return cancelled;
	}
	
    public void setCancelled(boolean cancel)
    {
        cancelled = cancel;
    }
}
