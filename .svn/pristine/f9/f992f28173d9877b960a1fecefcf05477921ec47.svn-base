package controller;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import view.MyDocumentView;

public class MyDocViewListeners implements ComponentListener {
	private MyDocumentView view;
	
	public MyDocViewListeners(MyDocumentView view) {
		this.view = view;
	}

	@Override public void componentHidden(ComponentEvent e) {}
	@Override public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentResized(ComponentEvent e) {
		this.view.setMain_panel_size(this.view.getMain_panel().getSize());
		this.view.getToolbar().holder_update();
	}

	@Override
	public void componentShown(ComponentEvent e) {
		this.view.setMain_panel_size(this.view.getMain_panel().getSize());
		this.view.getToolbar().setCols(3); //dafault value setting
		this.view.getToolbar().holder_update();
	}
}
