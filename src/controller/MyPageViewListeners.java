package controller;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.MyDocument;
import app_main.MyMainFrame;
import view.MyPageView;

public class MyPageViewListeners implements ComponentListener, MouseListener {
	private MyPageView view;
	
	public MyPageViewListeners(MyPageView view) {
		super();
		this.view = view;
	}
	
	@Override
	public void componentShown(ComponentEvent e) {
		view.updateAllSlots();
		view.revalidate();
		view.setVisible(false);
		view.setVisible(true);
	}

	@Override public void componentHidden(ComponentEvent e) {}
	@Override public void componentMoved(ComponentEvent e) {}
	@Override public void componentResized(ComponentEvent e) {}

	@Override public void mouseClicked(MouseEvent e) {
		MyDocument doc = this.view.getPage().getParent_doc();
		
		// set selected in JTree:
		MyMainFrame mfinst = MyMainFrame.getInstance();
		DefaultMutableTreeNode ws = (DefaultMutableTreeNode) mfinst.getWorkspaceTree().getModel().getRoot();
		
		SwingUtilities.updateComponentTreeUI(mfinst.getWorkspaceTree());
		
		DefaultMutableTreeNode[] path = {
			ws, doc.getParent_proj(), doc, this.view.getPage()
		};
		
		TreePath tp = new TreePath(path);
		mfinst.getWorkspaceTree().expandPath(tp);
		mfinst.getWorkspaceTree().setSelectionPath(tp);
		
		this.view.revalidate();
		mfinst.getWorkspaceTree().click_helper(null);
	}
	
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
}
