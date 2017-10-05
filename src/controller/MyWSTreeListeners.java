package controller;

import gui.MyWorkspaceTree;
import model.MyDocument;
import model.MyPage;
import model.MyProject;
import model.MySlot;
import view.MyDocumentView;
import view.MyPageView;
import view.MyProjectView;
import view.MySlotView;
import view.MyWorkspaceView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import app_main.MyMainFrame;

public class MyWSTreeListeners implements MouseListener, TreeSelectionListener {
	private MyWorkspaceTree workspaceTree;
	
	public MyWSTreeListeners(MyWorkspaceTree workspaceTree) {
		super();
		this.workspaceTree = workspaceTree;
	}

	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// linux:
		this.workspaceTree.click_helper(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// widnows:
//		this.workspaceTree.click_helper(e);
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		TreePath path = e.getNewLeadSelectionPath();
		if(path == null) return;
		
		MyWorkspaceView view = MyMainFrame.getInstance().getDesktop();
		for(int i = 0; i < path.getPathCount(); i++) {
			if(path.getPathComponent(i) instanceof MyProject) {
				MyProject project = (MyProject) path.getPathComponent(i);
				for(int j = 0; j < view.getComponentCount(); j++) {
					MyProjectView pView = (MyProjectView) view.getComponent(j);
					if(pView.getProject().equals(project)) {
						try {
							pView.setSelected(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
					}
				}
			} else if(path.getPathComponent(i) instanceof MyDocument) {
				MyDocument document = (MyDocument) path.getPathComponent(i);
				for(int j = 0; j < view.getComponentCount(); j++) {
					MyProjectView pView = (MyProjectView) view.getComponent(j);
					for(int k = 0; k < pView.getTabs().getComponentCount(); k++) {
						MyDocumentView dView = (MyDocumentView) pView.getTabs().getComponent(k);
						if(dView.getDocument().equals(document)) {
							pView.getTabs().setSelectedComponent(dView);
						}
					}
				}
			} else if(path.getPathComponent(i) instanceof MyPage) {
				MyPage page = (MyPage) path.getPathComponent(i);
				for(int j = 0; j < view.getComponentCount(); j++) {
					MyProjectView pView = (MyProjectView) view.getComponent(j);
					for(int k = 0; k < pView.getTabs().getComponentCount(); k++) {
						MyDocumentView dView = (MyDocumentView) pView.getTabs().getComponent(k);
						for(int h = 0; h < dView.getMain_panel().getComponentCount(); h++) {
							MyPageView pageView = (MyPageView) dView.getMain_panel().getComponent(h);
							if(pageView.getPage().equals(page)) {
								pageView.make_selected();
							} else {
								pageView.make_deselected();
							}
						}
					}
				}
			} else if(path.getPathComponent(i) instanceof MySlot) {
				MySlot slot = (MySlot) path.getPathComponent(i);
				for(int j = 0; j < view.getComponentCount(); j++) {
					MyProjectView pView = (MyProjectView) view.getComponent(j);
					for(int k = 0; k < pView.getTabs().getComponentCount(); k++) {
						MyDocumentView dView = (MyDocumentView) pView.getTabs().getComponent(k);
						for(int h = 0; h < dView.getMain_panel().getComponentCount(); h++) {
							MyPageView pageView = (MyPageView) dView.getMain_panel().getComponent(h);
							for(int g = 0; g < pageView.getPage_panel().getComponentCount(); g++) {
								MySlotView sView = (MySlotView) pageView.getPage_panel().getComponent(g);
								if(sView.getSlot().equals(slot)) {
									sView.make_selected();
								} else {
									sView.make_deselected();
								}
							}
						}
					}
				}
			}
		}
		this.workspaceTree.setSelectionPath(path);
	}
}
