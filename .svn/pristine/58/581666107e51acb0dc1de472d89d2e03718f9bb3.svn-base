package actions;

import java.awt.event.ActionEvent;
import app_main.MyMainFrame;
import model.MyDocument;
import model.MyPage;
import model.MyProject;
import model.MySlot;
import model.MyWorkspace;
import model.ObservableInfo;

public class OpenProjectAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public OpenProjectAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/Open.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/Open.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnOpenP"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnOpenP"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyWorkspace workspace = (MyWorkspace) MyMainFrame.getInstance().getWorkspaceTree().getModel().getRoot();
		MyProject project = MyMainFrame.getInstance().getWorkspaceTree().getCurrentProject();
		ObservableInfo observableInfo = null;
		
		if(!project.is_open()) {
			observableInfo = new ObservableInfo(project, 1);
			workspace.getObservable().setChanged();
			workspace.getObservable().notifyObservers(observableInfo);
			for(int i = 0; i < project.getDocumentCount(); i++) {
		    	MyDocument document = project.getDocument(i);
		    	observableInfo = new ObservableInfo(document, 1);
		    	project.getObservable().setChanged();
		    	project.getObservable().notifyObservers(observableInfo);
		    	for(int j = 0; j < document.getPageCount(); j++) {
		    		MyPage page = document.getPage(j);
		    		observableInfo = new ObservableInfo(page, 1);
		    		document.getObservable().setChanged();
			    	document.getObservable().notifyObservers(observableInfo);
			    	for(int k = 0; k < page.getSlotCount(); k++) {
			    		MySlot slot = page.getSlot(k);
			    		observableInfo = new ObservableInfo(slot, 1);
			    		page.getObservable().setChanged();
				    	page.getObservable().notifyObservers(observableInfo);
			    	}
		    	}
			}
		}
	}
}
