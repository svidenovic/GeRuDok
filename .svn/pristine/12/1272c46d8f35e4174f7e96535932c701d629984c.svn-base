package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.SwingUtilities;

import app_main.MyMainFrame;
import model.MyElement;
import model.MyPage;
import model.MySlot;

public class NewSlotAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;
	private char slot_type;
	
	public NewSlotAction(char type){
		super();
		this.slot_type = type;
		
		if(type == 'G') {
			putValue(SMALL_ICON, loadIcon("src/images/size16/GraphicSlot.png"));
			putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/GraphicSlot.png"));
			putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnNewGSlot"));
			putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnNewGSlot"));
		} else if(type == 'T') {
			putValue(SMALL_ICON, loadIcon("src/images/size16/TextSlot.png"));
			putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/TextSlot.png"));
			putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnNewTSlot"));
			putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnNewTSlot"));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyMainFrame mfinst = MyMainFrame.getInstance();
		MyPage seld_page = mfinst.getWorkspaceTree().getCurrentPage();
		
		if(seld_page != null){
			if(seld_page.getParent_doc().getOriginal() != null){
				seld_page = seld_page.getParent_doc()
				.getOriginal().getDoc().getPage(seld_page.toString());
			}
			MySlot slot = new MySlot(" ", this.slot_type);
			seld_page.addSlot(slot);
		}
		
		SwingUtilities.updateComponentTreeUI(MyMainFrame.getInstance().getWorkspaceTree());
		MyMainFrame.getInstance().getWorkspaceTree().click_helper(null);
	}
	
	public int gen_idx(ArrayList<Integer> free_indexes, ArrayList<MyElement> elements){
		if(free_indexes.size() == 1){
			int min_idx_val = free_indexes.get(0);
			free_indexes.remove(0);
			return min_idx_val;
		}
		else if(free_indexes.size() >= 2){
			int min_idx = free_indexes.indexOf(
				Collections.min(free_indexes)
			);
			int min_idx_val = free_indexes.get(min_idx);
			free_indexes.remove(min_idx);
			return min_idx_val;
		}
		else return elements.size()+1;
	}
}
