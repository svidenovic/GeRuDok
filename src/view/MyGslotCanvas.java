package view;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Iterator;

import javax.swing.JPanel;

import model.element.MySlotElement;
import view.painter.MyElementPainter;

public class MyGslotCanvas extends JPanel {
	private static final long serialVersionUID = 1L;
	private MySlotView view;
	
	public MyGslotCanvas(MySlotView view) {
		super();
		this.view = view;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint();
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Iterator<MySlotElement> it = this.view.getSlot().getModel().getDeviceIterator();
		while(it.hasNext()) {
			MySlotElement element = it.next();
			MyElementPainter painter = element.getElementPainter();
			painter.paint(g2, element);
		}
		
		this.view.paintSelectionHandles(g2);
	}
}
