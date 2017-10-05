package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import app_main.MyMainFrame;
import model.MyDocument;
import model.MyElement;
import model.MyPage;
import model.MyProject;
import model.MySlot;

@SuppressWarnings("serial")
public class DeleteAction extends MyAbstractAction {
	
	public DeleteAction() {
		super();
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		putValue(SMALL_ICON, loadIcon("src/images/size16/DeleteRed.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/DeleteRed.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnDelete"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnDelete"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyMainFrame mfinst = MyMainFrame.getInstance();
		TreePath path = mfinst.getWorkspaceTree().getSelectionPath();
		if (path == null) return;
		Object seld_obj = path.getPathComponent( path.getPathCount()-1 );
		if (seld_obj == null) return;
		
		if(seld_obj instanceof MyProject) {
			mfinst.getWorkspace().removeProject((MyProject) seld_obj);
		}
		else if(seld_obj instanceof MyDocument){
			MyDocument seld_doc = (MyDocument) seld_obj;
			seld_doc.getParent_proj().removeDocument(seld_doc);
		}
		else if(seld_obj instanceof MyPage){
			MyPage seld_page = (MyPage) seld_obj;
			if(seld_page.getParent_doc().getOriginal() != null){
				seld_page = seld_page.getParent_doc().getOriginal()
				.getDoc().getPage(seld_page.toString());
			}
			seld_page.getParent_doc().removePage(seld_page);
		}
		else if(seld_obj instanceof MySlot){
			MySlot seld_slot = (MySlot) seld_obj;
			if(seld_slot.getParent_page().getParent_doc().getOriginal() != null){
				String pageName = seld_slot.getParent_page().toString();
				seld_slot = seld_slot.getParent_page().getParent_doc().getOriginal()
				.getDoc().getPage(pageName).getSlot(seld_slot.toString());
			}
			seld_slot.getParent_page().removeSlot(seld_slot);
//			((MySlot) seld_obj).getParent_page().removeSlot((MySlot) seld_obj);
		}
		else if(seld_obj instanceof MyElement){
			MyElement seld_elem = (MyElement) seld_obj;
			if(seld_elem.getParent_slot().getParent_page().getParent_doc().getOriginal() != null){
				String pageName = seld_elem.getParent_slot().getParent_page().toString();
				String slotname = seld_elem.getParent_slot().toString();
				seld_elem = seld_elem.getParent_slot().getParent_page()
				.getParent_doc().getOriginal().getDoc().getPage(pageName).
				getSlot(slotname).getElement(seld_elem.toString());
			}
			seld_elem.getParent_slot().removeElement(seld_elem);
//			((MyElement) seld_obj).getParent_slot().removeElement( (MyElement) seld_obj );
		}
		
		SwingUtilities.updateComponentTreeUI(MyMainFrame.getInstance().getWorkspaceTree());
	}
}
