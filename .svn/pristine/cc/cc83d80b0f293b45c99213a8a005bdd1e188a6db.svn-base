package actions;

import java.awt.event.ActionEvent;

import app_main.MyMainFrame;
import view.MySlotView;

public class NewRectangleAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;
	
	private MySlotView view;

	public NewRectangleAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/rectangle.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/rectangle.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnRectangle"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnRectangle"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.startRectangleState();
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}
}
