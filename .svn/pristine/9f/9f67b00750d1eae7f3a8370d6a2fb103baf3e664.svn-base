package actions;

import java.awt.event.ActionEvent;

import app_main.MyMainFrame;
import view.MySlotView;

public class MySelectAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;
	
	private MySlotView view;

	public MySelectAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/one_finger.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/one_finger.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnSelect"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnSelect"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.view.startSelectState();
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}
}
