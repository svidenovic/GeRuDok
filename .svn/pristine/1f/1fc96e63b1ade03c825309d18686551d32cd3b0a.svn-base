package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import app_main.MyMainFrame;
import view.MySlotView;

public class PasteAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;
	
	private MySlotView view;
	
	public PasteAction() {
		super();
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("src/images/size16/paste.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/paste.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnPaste"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnPaste"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println(this.view.getSlot().toString());
		this.view.paste();
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}
}
