package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.MyDocShare;
import model.MyDocument;
import model.MyProject;
import model.MyWorkspace;
import app_main.MyMainFrame;

@SuppressWarnings("serial")
public class ShareAction extends MyAbstractAction {
	
	public ShareAction(){
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/ShareBtn.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/ShareBtn.png"));
		putValue(NAME, "Share");
		putValue(SHORT_DESCRIPTION, "Share");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MyMainFrame mfinst = MyMainFrame.getInstance();
		MyDocument sel_doc = mfinst.getWorkspaceTree().getCurrentDocument();
		
		if(sel_doc != null){
			MyWorkspace ws = mfinst.getWorkspace();
			
			if(sel_doc.getOriginal() != null){
				// sharing a "link" object, traces it back to the original
				MyProject proj_temp = sel_doc.getOriginal().getProj();
				MyDocument doc_temp = sel_doc.getOriginal().getDoc();
				loop1: 
				for( int p=0; p<ws.getProjectsCount(); p++ ){
					if( proj_temp.equals(ws.getProject(p)) ){
						for( int d=0; d<proj_temp.getDocumentCount(); d++ ){
							if( doc_temp.equals(proj_temp.getDocument(d)) ){
								sel_doc = doc_temp;
								break loop1;
							}
						}
					}
				}
			}
			MyDocShare mds_sel_path = new MyDocShare(
				sel_doc.getParent_proj(), sel_doc
			);
			ArrayList<MyProject> legit_projs = new ArrayList<MyProject>();
			boolean doc_shared = false;
			
			MyProject proj = null;
			MyDocument doc = null;
			for( int p=0; p<ws.getProjectsCount(); p++ ){
				doc_shared = false;
				proj = ws.getProject(p);
				for( int d=0; d<proj.getDocumentCount(); d++ ){
					doc = proj.getDocument(d);
					if(doc.getOriginal() != null){
						if(doc.getOriginal().eq2(mds_sel_path) ){
							doc_shared = true; break;
						}
					}
				}
				if(!doc_shared) legit_projs.add( proj );
			}
			
			if(legit_projs.size() == 0){
				JOptionPane.showMessageDialog(
					null,"Already shared with all available projects, \n"
					+ "(One Project can not have multiple shares of the same Document) "
				);
				return;
			}
			
			String sprojs[] = new String[legit_projs.size()];
		    for (int i=0; i<legit_projs.size(); i++){
		    	sprojs[i] = legit_projs.get(i).toString();
		    }
		    
		    String proj2shareWith = (String) JOptionPane.showInputDialog(
		    	null, "Available projects:", "Input", 
		    	JOptionPane.QUESTION_MESSAGE,
		    	null, sprojs, sprojs[0]
		    );
		    
		    if(proj2shareWith != null){
		    	for(MyProject it : legit_projs){
		    		if( it.toString().equals(proj2shareWith) ){
		    			proj = it; break;
		    		}
		    	}
		    	doc = new MyDocument( mds_sel_path.toString());
		    	doc.setOriginal( mds_sel_path);
		    	proj.addDocument( doc);
		    	sel_doc.copy_this_content_to( doc);
		    	sel_doc.add_docShare(
		    		new MyDocShare( proj, sel_doc )
		    	);
		    	mfinst.getWorkspaceTree().updateUI();
		    }
			
		}
	}
	
}
