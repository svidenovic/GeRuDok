package actions;

import java.awt.event.ActionEvent;
import app_main.MyMainFrame;
import gui.AboutDialog;

public class CallAboutDialog extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public CallAboutDialog() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/About.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/About.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnAbout"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnAbout"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AboutDialog ad = new AboutDialog(null);
		ad.setVisible(true);
	}

}
