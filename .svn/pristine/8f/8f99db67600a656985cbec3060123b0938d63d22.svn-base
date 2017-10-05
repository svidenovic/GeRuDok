package actions;

import java.awt.event.ActionEvent;
import java.util.Locale;

import app_main.MyMainFrame;

public class SerbianLAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public SerbianLAction() {
		super();
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("menuSerbian"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("menuSerbian"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Locale.setDefault(new Locale("sr","RS"));
		MyMainFrame.getInstance().changeLanguage();
		System.out.println(Locale.getDefault().toString());
	}
}
