package view;

import javax.swing.JPanel;

import model.MySlot;

public class MySlotCanvas extends JPanel {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private MySlot slot;
	
	public MySlotCanvas(MySlot slot) {
		super();
		this.slot = slot;
	}
}
