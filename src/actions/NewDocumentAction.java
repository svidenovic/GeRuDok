package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.SwingUtilities;

import app_main.MyMainFrame;
import model.MyDocument;
import model.MyPage;
import model.MyProject;

public class NewDocumentAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public NewDocumentAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/Book.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/Book.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnNewDocument"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnNewDocument"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyMainFrame mfinst = MyMainFrame.getInstance();
		MyProject sel_proj = mfinst.getWorkspaceTree().getCurrentProject();
		
		if(sel_proj != null) {
			MyDocument doc = new MyDocument(" ");
			sel_proj.addDocument(doc);
		}
		
		SwingUtilities.updateComponentTreeUI(MyMainFrame.getInstance().getWorkspaceTree());
		MyMainFrame.getInstance().getWorkspaceTree().click_helper(null);
	}
	
	public int gen_idx(ArrayList<Integer> free_indexes, ArrayList<MyPage> pages){
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
		else return pages.size()+1;
	}
}












