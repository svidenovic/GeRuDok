package actions;

import java.awt.event.ActionEvent;

import app_main.MyMainFrame;
import view.MySlotView;

public class UndoAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;
	
	private MySlotView view;

	public UndoAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/undo.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/undo.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnUndo"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnUndo"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.view.getCommandManager().undoCommand();
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}
}
