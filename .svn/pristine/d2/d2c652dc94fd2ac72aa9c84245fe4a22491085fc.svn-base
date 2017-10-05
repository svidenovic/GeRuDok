package actions;

import java.awt.event.ActionEvent;

import app_main.MyMainFrame;

public class VerticalWindowAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public VerticalWindowAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/application_tile_horizontal.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/application_tile_horizontal.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnVertical"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnVertical"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tileWindowsVartically();
	}
	
	public void tileWindowsVartically() {
		int k = 0;	//Number of open JInternalFrames
		
		if(MyMainFrame.getInstance().getDesktop().getAllFrames().length == 0)
			return;
		
		int rows = MyMainFrame.getInstance().getDesktop().getAllFrames().length;
		int cols = 1;
		
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
