package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.TSlotDialog;

public class MyTSDListeners implements KeyListener {
	private TSlotDialog tsd;
	
	public MyTSDListeners(TSlotDialog tsd) {
		super();
		this.tsd = tsd;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		tsd.getView().getT().setStyledDocument(tsd.getTextPane().getStyledDocument());
	}
	
	@Override public void keyPressed(KeyEvent e) {}
	@Override public void keyTyped(KeyEvent e) {}
}
