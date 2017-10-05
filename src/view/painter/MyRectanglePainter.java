package view.painter;

import java.awt.geom.Rectangle2D;
import model.element.MyRectangleElement;
import model.element.MySlotElement;

public class MyRectanglePainter extends MyDevicePainter {
	private static final long serialVersionUID = 1L;

	public MyRectanglePainter(MySlotElement device) {
		super(device);
		MyRectangleElement rectangle = (MyRectangleElement) device;
		
		shape = new Rectangle2D.Double(
			rectangle.getPosition().getX()-20, 
			rectangle.getPosition().getY()-20, 
			rectangle.getSize().width, 
			rectangle.getSize().height
		);
	}
}
