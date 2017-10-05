package model.element;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.io.Serializable;
import serialization.MySerializableStrokeAdapter;
import view.painter.MyElementPainter;

public abstract class MySlotElement implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected MySerializableStrokeAdapter stroke;
	protected Color strokeColor;
	protected Paint paint;
	protected String name;
	protected Dimension size;
	protected Point2D position;
	public static int i_r = 0;
	public static int i_c = 0;
	//public MyElement elem;
	public int relevant_element_ID;
	
	protected MyElementPainter elementPainter;
	
	abstract public MySlotElement clone();

	public MySlotElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		setStroke(stroke);
		//this.stroke = stroke;
		this.paint = paint;
		this.strokeColor = strokeColor;
		this.size = size;
		//position.setLocation(position.getX()-size.getWidth()/2, position.getY()-size.getHeight()/2);
		this.position = position;
	}
	
	//copy constructor
	public MySlotElement(MySlotElement element) {
		//this.elem = element.elem;
		this.stroke = element.stroke;
		this.paint = element.paint;
		this.strokeColor = element.strokeColor;
		this.name = element.name;
		this.position = element.position;
		this.size = element.size;
		this.elementPainter = element.elementPainter;
	}
	
	public MyElementPainter getElementPainter() {
		return elementPainter;
	}
	public void setElementPainter(MyElementPainter elementPainter) {
		this.elementPainter = elementPainter;
	}
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	public Paint getPaint() { return paint; }
	public void setPaint(Paint paint) { this.paint = paint; }
	public Stroke getStroke() { return stroke; }
	public Color getStrokeColor() { return strokeColor; }
	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}
	
	public void setStroke(Stroke stroke) {
		this.stroke = new MySerializableStrokeAdapter(stroke);
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}
}
