package gui;

import javax.swing.JPopupMenu;

import app_main.MyMainFrame;

public class MyPopUpMenu extends JPopupMenu {
	private static final long serialVersionUID = 1L;

	public MyPopUpMenu(int i) {
		MyMainFrame mfinst = MyMainFrame.getInstance();
		
		if(i == 1) {
			this.add(mfinst.getActionManager().getNewProjectAction());
		} else if (i == 2) {
			this.add(mfinst.getActionManager().getOpenProjectAction());
			this.addSeparator();
			this.add(mfinst.getActionManager().getNewDocumentAction());
			this.add(mfinst.getActionManager().getDeleteAction());
		} else if(i == 3) {
			this.add(mfinst.getActionManager().getNewPageAction());
			this.add(mfinst.getActionManager().getDeleteAction());
		} else if(i == 4) {
			this.add(mfinst.getActionManager().getNewTSlotAction());
			this.add(mfinst.getActionManager().getNewGSlotAction());
			this.add(mfinst.getActionManager().getDeleteAction());
		} else if(i == 5) {
			this.add(mfinst.getActionManager().getDeleteAction());
		} else if(i == 6) {
			this.add(mfinst.getActionManager().getDeleteAction());
		}
	}
}
