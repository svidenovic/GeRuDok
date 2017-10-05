package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import view.MySlotView;
import commands.MyAddDeviceCommand;

public class MyRectangleState extends MyState {
	private static final long serialVersionUID = 1L;
	private MySlotView med;

	public MyRectangleState(MySlotView md) {
		this.med = md;
	}
	public MyRectangleState( MyRectangleState mrs ) {
		this.med = new MySlotView( mrs.med );
	}
	
	@SuppressWarnings("static-access")
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(med.getSlot().getModel().getDeviceAtPosition(position) == -1) {
				med.getCommandManager().
					addCommand(new MyAddDeviceCommand(med.getSlot().getModel(), position, med.RECTANGLE)
				);
			}
		}
	}
}
