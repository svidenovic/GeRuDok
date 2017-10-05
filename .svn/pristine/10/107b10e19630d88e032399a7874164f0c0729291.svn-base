package actions;

import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;

import app_main.MyMainFrame;
import view.MyProjectView;

public class CascadeWindowAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public CascadeWindowAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/application_cascade.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/application_cascade.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnCascade"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnCascade"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		cascadeWidnows();
	}

	public void cascadeWidnows() {
		if(MyMainFrame.getInstance().getDesktop().getAllFrames().length == 0)
			return;
		
		int i;
		JInternalFrame[] pom = new JInternalFrame[MyMainFrame.getInstance().getDesktop().getAllFrames().length];
		
		for(i = 0; i < pom.length; i++)
			pom[i] = MyMainFrame.getInstance().getDesktop().getAllFrames()[i];
		
		MyProjectView pv = null;
		for(i = pom.length - 1; i >= 0; i--) {
			pv = (MyProjectView) pom[i];
			pom[i].setLocation(
				pv.getX_Offset()*(-1+2*(pom.length-i)),
				pv.getY_Offset()*(-1+2*(pom.length-i))
			);
			pom[i].setSize(600, 450);
		}
	}
}
