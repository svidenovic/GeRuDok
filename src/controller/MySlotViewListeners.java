package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.MyPage;
import app_main.MyMainFrame;
import view.MySlotView;

public class MySlotViewListeners implements MouseListener {
	private MySlotView view;
	
	public MySlotViewListeners(MySlotView view) {
		super();
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() >= 2) {
			if(this.view.getSlot().getType() == 'T') {
				this.view.getTsd().setVisible(true);
			} else if(this.view.getSlot().getType() == 'G') {
				this.view.getGsd().setVisible(true);
			}
		}
		
		MyPage page = this.view.getSlot().getParent_page();
		
		// set selected in JTree:
		MyMainFrame mfinst = MyMainFrame.getInstance();
		DefaultMutableTreeNode ws = (DefaultMutableTreeNode) mfinst.getWorkspaceTree().getModel().getRoot();
		
		SwingUtilities.updateComponentTreeUI(mfinst.getWorkspaceTree());
		
		DefaultMutableTreeNode[] path = {
			ws, page.getParent_doc().getParent_proj(),
			page.getParent_doc(), page, this.view.getSlot()
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
