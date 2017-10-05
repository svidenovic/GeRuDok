package actions;

import java.awt.event.ActionEvent;

import app_main.MyMainFrame;

public class HorizontalWindowAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public HorizontalWindowAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/application_split.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/application_split.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnHorizontal"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnHorizontal"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tileWindowsHorizontally();
	}
	
	public void tileWindowsHorizontally() {
		int k = 0;	//Number of open JInternalFrames
		
		if(MyMainFrame.getInstance().getDesktop().getAllFrames().length == 0)
			return;
		
		int rows = 1;
		int cols = MyMainFrame.getInstance().getDesktop().getAllFrames().length;
		
		//Sets a size of every open JInternalFrames
		int x = (int) MyMainFrame.getInstance().getDesktop().getSize().getWidth() / rows;
		int y = (int) MyMainFrame.getInstance().getDesktop().getSize().getHeight() / cols;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(k < MyMainFrame.getInstance().getDesktop().getAllFrames().length) {
					MyMainFrame.getInstance().getDesktop().getAllFrames()[k].setLocation(x * i, y * j);
					MyMainFrame.getInstance().getDesktop().getAllFrames()[k].setSize(x, y);
					k++;
				}
			}
		}
	}
}
