package events;

import java.util.EventListener;

public interface MyUpdateListener extends EventListener {
	public void updatePerformed(MyUpdateEvent e);
}
