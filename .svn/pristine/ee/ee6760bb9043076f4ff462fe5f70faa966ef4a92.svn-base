package view.painter;

import java.awt.geom.Ellipse2D;

import model.element.MyCircleElement;
import model.element.MySlotElement;

public class MyCirclePainter extends MyDevicePainter {
	private static final long serialVersionUID = 1L;

	public MyCirclePainter(MySlotElement device) {
		super(device);
		MyCircleElement circle = (MyCircleElement) device;
		
		shape = new Ellipse2D.Double(
			circle.getPosition().getX()-20,
			circle.getPosition().getY()-20, 
			circle.getSize().width,
			circle.getSize().height
		);
	}
}
