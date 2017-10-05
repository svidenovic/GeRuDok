package commands;

import model.MySlotModel;
import model.element.MyCircleElement;
import model.element.MyRectangleElement;
import model.element.MySlotElement;
import view.painter.MyCirclePainter;
import view.painter.MyRectanglePainter;

public class MyPasteCommand extends MyAbstractCommand {
	private MySlotElement element;
	private MySlotModel model;
	
	public MyPasteCommand(MySlotElement element, MySlotModel model) {
		this.element = element;
		this.model = model;
		//this.model.addSlotElements(element, false);
	}
	
	@Override
	public void doCommand() {
		if (element instanceof MyCircleElement) {
			element.setElementPainter(new MyCirclePainter(element));
		} else if (element instanceof MyRectangleElement) {
			element.setElementPainter(new MyRectanglePainter(element));
		}
		
		this.model.addSlotElements(element, true);
	}

	@Override
	public void undoCommand() {
		this.model.removeElement(element, true);
	}
}
