package common.kodehawa.ce.mevents;

import java.util.EventListener;

public interface Listener extends EventListener {

	public void onEvent(Event evt);
}
