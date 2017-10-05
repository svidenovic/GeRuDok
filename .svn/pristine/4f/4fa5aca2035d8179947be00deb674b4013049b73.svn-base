package actions;

import java.awt.event.ActionEvent;
import app_main.MyMainFrame;
import view.MySlotView;

public class RedoAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;
	
	private MySlotView view;

	public RedoAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/redo.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/redo.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnRedo"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnRedo"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getCommandManager().doCommand();
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}
}
