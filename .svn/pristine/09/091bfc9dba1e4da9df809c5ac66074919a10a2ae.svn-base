package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import app_main.MyMainFrame;

public class MyProject extends DefaultMutableTreeNode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<MyDocument> documents;
	private ArrayList<Integer> free_indexes;
	private String name;
	private transient boolean changed;
	private transient boolean _open;
	private MyObservable observable;
	private File projectFile;
	private int ID;
	
	public MyProject(String name) {
		super(name);
		this.name = name;
		this.observable = new MyObservable();
		this.documents = new ArrayList<MyDocument>();
		this.free_indexes = new ArrayList<Integer>();
		this.projectFile = null;
	
	}
	public MyProject(MyProject proj) {
		super( new String(proj.name) );
		this.name = new String( proj.name);
		this.observable = new MyObservable();
		this.documents = new ArrayList<MyDocument>( proj.documents);
		this.free_indexes = new ArrayList<Integer>( proj.free_indexes);
		this.projectFile = new File( proj.projectFile.getPath() );
	}
	
	public void addDocument(MyDocument doc) {
		doc.setParent_proj(this);
		doc.setID(MyMainFrame.getInstance().getActionManager().getNewProjectAction().gen_idx(free_indexes, documents));
		if(doc.getName().equals(" "))
			doc.setName("Doc " + Integer.toString(doc.getID()));
		
		this.documents.add(doc);
		this.add((DefaultMutableTreeNode) doc);
		
		this.changed = true;
		
		ObservableInfo observableInfo = new ObservableInfo(doc, 1);
		
		this.observable.setChanged();
		this.observable.notifyObservers(observableInfo);
	}

	private void removeDocument_(MyDocument doc){
		if(doc == null) return;
		for(int i = 0; i < doc.getPageCount(); i++) {
			doc.removePage(doc.getPage(i));
		}
		Integer tmp = Integer.valueOf(doc.getID());
		
		this.documents.remove(doc);
		this.remove(doc);
		this.free_indexes.add( tmp );
		
		this.changed = true;
		
		ObservableInfo observableInfo = new ObservableInfo(doc, 2);
		this.observable.setChanged();
		this.observable.notifyObservers(observableInfo);
	}
	public void removeDocument(MyDocument doc) {
		if(doc.getOriginal() != null){
			// dos is a copy
			doc.getOriginal().getDoc().remoce_docShare(
				new MyDocShare( doc.getParent_proj(), doc )
			);
			this.removeDocument_(doc);
		}else{
			// doc is the original
			String[] options = {"(1) Remove all shares too", "(2) Select a new original", "Cancel"};
			int choice = JOptionPane.showOptionDialog(null, 
				"This document is the original and has been shared, Do you want to: \n"+
				" (1) Remove all shares as well as this document \n"+
				" (2) Set one of the shares as the new original and remove only this document", 
				"Removing the original document...",
				0, JOptionPane.QUESTION_MESSAGE, null, options, options[0]
			);
			MyDocShare mds; MyDocument shDoc;
			MyProject shDoc_parProj, oDoc_parProj;
			
			if(choice == 0){
				// remove all shares
				for (int i=0; i<doc.get_doc_shares().size(); i++){
					mds = doc.get_doc_shares().get(i);
					shDoc_parProj = mds.getProj();
					shDoc = mds.getDoc();
					oDoc_parProj = this;
					// shDoc_parProj/oDoc_parProj - shDoc
					shDoc_parProj.removeDocument_(
						shDoc_parProj.getDocument(
							new MyDocShare(oDoc_parProj,shDoc).toString()
						)
					);
				}
				doc.remove_all_docShares();
				this.removeDocument_(doc);
			}
			else if(choice == 1){
				// select a new original
				JOptionPane.showMessageDialog(null,"Not implemented.");
				
//				String[] s_doc_shares = new String[doc.get_doc_shares().size()];
//				for (int i=0; i<doc.get_doc_shares().size(); i++){
//					mds = doc.get_doc_shares().get(i);
//					shDoc_parProj = mds.getProj();
//					shDoc = mds.getDoc();
//					oDoc_parProj = this;
//					s_doc_shares[i] = shDoc_parProj+"/ "+
//					new MyDocShare(oDoc_parProj,shDoc).toString();
//				}
//				String s_newOrigDoc = (String) JOptionPane.showInputDialog(
//			    	null, "Select a new original", "Input", 
//			    	JOptionPane.QUESTION_MESSAGE,
//			    	null, s_doc_shares, s_doc_shares[0]
//			    );
//				int s_newOrigDoc_idx = 0;
//				while (s_newOrigDoc_idx < doc.get_doc_shares().size()){
//					if (s_newOrigDoc.equals(s_doc_shares[s_newOrigDoc_idx])) break;
//					else s_newOrigDoc_idx++;
//				}
//				mds = doc.get_doc_shares().get(s_newOrigDoc_idx);
//				MyDocument newOrigDoc = mds.getProj().getDocument(
//					new MyDocShare(this,doc).toString()
//				);
				
			}
		}
		
		
	}
	
	public MyDocument getDocument(int index) {
		return this.documents.get(index);
	}
	public MyDocument getDocument(String name) {
		for(MyDocument docit : this.documents){
			if(docit.toString().equals(name))
				return docit;
		}
		return null;
	}
	
	public int getDocumentIndex(MyDocument doc) {
		return this.documents.indexOf(doc);
	}
	
	public int getDocumentCount() {
		return this.documents.size();
	}

	@Override
	public String toString() {
		return ((changed ? "*" : "") + this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyObservable getObservable() {
		return observable;
	}

	public void setObservable(MyObservable observable) {
		this.observable = observable;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public boolean is_open() {
		return _open;
	}

	public void set_open(boolean _open) {
		this._open = _open;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		if (this.changed != changed){
		     this.changed = changed;
		     //SwingUtilities.updateComponentTreeUI(MyMainFrame.getInstance().getWorkspaceTree());
		}
	}
	
	public File getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}
}
