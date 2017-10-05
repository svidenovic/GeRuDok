package actions;

import java.awt.event.ActionEvent;

import app_main.MyMainFrame;
import view.MySlotView;

public class NewCircleAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;
	
	private MySlotView view;

	public NewCircleAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/circle.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/circle.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnCircle"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnCircle"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.view.startCircleState();
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}
}
