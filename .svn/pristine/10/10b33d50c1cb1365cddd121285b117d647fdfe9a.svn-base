package view.painter;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;

import model.element.MySlotElement;

public abstract class MyElementPainter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected MySlotElement element;
	protected Shape shape;
	
	public MyElementPainter(MySlotElement element) {
		this.element = element;
	}
	
	public abstract void paint(Graphics2D g, MySlotElement element);
	public abstract boolean elementAt(Point pos);
	
	public Shape getShape() {
		return shape;
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
