package controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.MyWorkspace;
import app_main.MyMainFrame;
import view.MyDocumentView;
import view.MyProjectView;


public class MyProjViewListeners implements InternalFrameListener, ChangeListener {
	private MyProjectView view;
	
	public MyProjViewListeners(MyProjectView view) {
		this.view = view;
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		if(this.view.getProject().getDocumentCount() > 0) {
			MyDocumentView seld_tab = (MyDocumentView) this.view.getTabs().getSelectedComponent();
			if(seld_tab != null) {
				MyMainFrame mfinst = MyMainFrame.getInstance();
				MyWorkspace mws = (MyWorkspace) mfinst.getWorkspaceTree().getModel().getRoot();
				
				DefaultMutableTreeNode[] path2 = {
					(DefaultMutableTreeNode) mws,
					(DefaultMutableTreeNode) this.view.getProject(),
					(DefaultMutableTreeNode) seld_tab.getDocument()
				};
				TreePath tp = new TreePath(path2);
				mfinst.getWorkspaceTree().expandPath(tp);
				mfinst.getWorkspaceTree().setSelectionPath(tp);
			}
		}
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		MyMainFrame mfinst = MyMainFrame.getInstance();
		MyWorkspace mws = (MyWorkspace) mfinst.getWorkspaceTree().getModel().getRoot();
		
		DefaultMutableTreeNode[] path = {
			(DefaultMutableTreeNode) mws, 
			(DefaultMutableTreeNode) this.view.getProject()
		};
		TreePath tp = new TreePath(path);
		mfinst.getWorkspaceTree().expandPath(tp);
		mfinst.getWorkspaceTree().setSelectionPath(tp);
	}

	@Override public void internalFrameClosed(InternalFrameEvent arg0) {
		this.view.getProject().set_open(false);
	}
	
	@Override public void internalFrameClosing(InternalFrameEvent arg0) {}
	@Override public void internalFrameDeactivated(InternalFrameEvent arg0) {}
	@Override public void internalFrameDeiconified(InternalFrameEvent arg0) {}
	@Override public void internalFrameIconified(InternalFrameEvent arg0) {}
	@Override public void internalFrameOpened(InternalFrameEvent arg0) {}
}
