package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import app_main.MyMainFrame;
import model.MySlotElementsSelection;
import view.MySlotView;

public class CutAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	private MySlotView view;
	
	public CutAction() {
		super();
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("src/images/size16/Cut.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/Cut.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnCut"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnCut"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!(this.view.getSlot().getSelectionModel().getSelectionListSize() == 0)) {
			MySlotElementsSelection contents = new MySlotElementsSelection(this.view.getSlot().getSelectionModel().getSelected());
			MyMainFrame.getInstance().getClipboard().setContents(contents, MyMainFrame.getInstance());
			
			/*for(int i = 0; i < this.view.getSlot().getSelectionModel().getSelected().size(); i++) {
				MyElement element = this.view.getSlot().getElement(i);
				//System.out.println(element.toString());
				this.view.getSlot().removeElement(element);
			}*/
			
			this.view.getSlot().getModel().removeAllSelectedElements();
			this.view.getSlot().getSelectionModel().removeAllFromSelectionList();
			
			//radi cut ali samo za jedan element
			/*for(int i = 0; i < this.view.getSlot().getSelectionModel().getSelected().size(); i++) {
				MySlotElement element = this.view.getSlot().getSelectionModel().getElementFromSelectionListAt(i);
				this.view.getSlot().getModel().removeElement(element, false);
			}*/
		}
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}
}
