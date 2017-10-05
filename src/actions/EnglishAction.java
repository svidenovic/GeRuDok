package actions;

import java.awt.event.ActionEvent;
import java.util.Locale;

import app_main.MyMainFrame;

public class EnglishAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public EnglishAction() {
		super();
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("menuEnglish"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("menuEnglish"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Locale.setDefault(new Locale("en","US"));
		MyMainFrame.getInstance().changeLanguage();
	}
}
