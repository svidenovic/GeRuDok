package view.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import model.element.MySlotElement;

public class MyDevicePainter extends MyElementPainter {
	private static final long serialVersionUID = 1L;
	protected Shape shape;

	public MyDevicePainter(MySlotElement device) {
		super(device);
	}

	@Override
	public void paint(Graphics2D g, MySlotElement element) {
		
		if(element instanceof MySlotElement) {
			@SuppressWarnings("unused")
			MySlotElement device = (MySlotElement) element;
			//g.drawString(device.getName(), (int) device.getPosition().getX()+10, (int) device.getPosition().getY()+10);
		}
		
		g.setPaint(element.getStrokeColor());
		g.setStroke(element.getStroke());
		g.draw(getShape());

		g.setPaint(element.getPaint());
		g.fill(getShape());	
	}

	@Override
	public boolean elementAt(Point pos) {
		return getShape().contains(pos);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
