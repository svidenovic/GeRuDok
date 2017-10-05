package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import view.MySlotView;

public class MyGSCListeners extends MouseAdapter implements MouseMotionListener {
	private MySlotView view;
	
	public MyGSCListeners(MySlotView view) {
		this.view = view;
	}
	
	public void mousePressed(MouseEvent e) {
		this.view.getStateManager().getCurrentState().mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		this.view.getStateManager().getCurrentState().mouseReleased(e);
	}
	
	public void mouseMoved(MouseEvent e) {
		this.view.getStateManager().getCurrentState().mouseMoved(e);
	}
}
