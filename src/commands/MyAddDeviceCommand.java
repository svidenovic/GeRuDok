package commands;

import model.MySlotModel;
import model.element.MyCircleElement;
import model.element.MyRectangleElement;
import model.element.MySlotElement;
import view.MySlotView;

import java.awt.geom.Point2D;

public class MyAddDeviceCommand extends MyAbstractCommand {
	MySlotModel model;
	Point2D lastPosition;
	MySlotElement device = null;
	int deviceType;
	
	public MyAddDeviceCommand(MySlotModel model, Point2D lastPosition, int deviceType) {
		this.model = model;
		this.lastPosition = lastPosition;
		this.deviceType = deviceType;
	}
	
	@Override
	public void doCommand() {
		if(device == null) {
			if(deviceType == MySlotView.CIRCLE) {
				device = MyCircleElement.createDefault(
					lastPosition, model.getElementCount()
				);
			} else if(deviceType == MySlotView.RECTANGLE) {
				device = MyRectangleElement.createDefault(
					lastPosition, model.getElementCount()
				);
			}
			model.addSlotElements(device, false); // add
		}
		else model.addSlotElements(device, true); // redo
	}

	@Override
	public void undoCommand() {
		model.removeElement(device, true);
	}
}
