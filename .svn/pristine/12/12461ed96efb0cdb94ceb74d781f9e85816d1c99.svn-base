package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import view.MyToolBar;

public class MyTBListeners implements MouseListener {
	private MyToolBar toolbar;
	
	public MyTBListeners(MyToolBar toolbar) {
		this.toolbar = toolbar;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.toolbar.setCols(Integer.parseInt(
				((JButton) e.getComponent()).getText().trim()
		));
		this.toolbar.holder_update();
	}

	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
}
