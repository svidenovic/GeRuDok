package view;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import app_main.MyMainFrame;

public class GDToolbar extends JToolBar {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private GSlotDialog gsd;
	
	public GDToolbar(GSlotDialog gsd) {
		super(SwingConstants.HORIZONTAL);
		setFloatable(true);
		this.gsd = gsd;
		
		add(MyMainFrame.getInstance().getActionManager().getSelectAction());
		add(MyMainFrame.getInstance().getActionManager().getNewRectangleAction());
		add(MyMainFrame.getInstance().getActionManager().getNewCircleAction());
		
		this.addSeparator();
		
		add(MyMainFrame.getInstance().getActionManager().getUndoAction());
		add(MyMainFrame.getInstance().getActionManager().getRedoAction());
		
		MyMainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
		MyMainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
		
		this.addSeparator();
		
		add(MyMainFrame.getInstance().getActionManager().getCutAction());
		add(MyMainFrame.getInstance().getActionManager().getCopyAction());
		add(MyMainFrame.getInstance().getActionManager().getPasteAction());
	}
}
