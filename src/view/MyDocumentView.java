package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import app_main.MyMainFrame;
import controller.MyDocViewListeners;
import model.MyDocument;
import model.MyPage;
import model.ObservableInfo;
import net.miginfocom.swing.MigLayout;

public class MyDocumentView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	
	private MyDocument document;
	private MyToolBar toolbar;
	private JPanel main_panel;
	private Dimension main_panel_size;
	private Dimension outpan, inpan, txtfld;
	
	public MyDocumentView(MyDocument document) {
		super();
		this.document = document;
		this.document.getObservable().addObserver(this);
		this.addComponentListener(new MyDocViewListeners(this));
		this.setLayout(new BorderLayout());
		
		toolbar = new MyToolBar(16);
        this.add(toolbar, BorderLayout.NORTH);
		
        this.main_panel = new JPanel();
        this.main_panel.setBackground(Color.gray);
        this.main_panel.setLayout(new MigLayout("wrap 3"));
        this.main_panel.validate();
        
        JScrollPane jsp = new JScrollPane(
        	this.main_panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        jsp.getVerticalScrollBar().setUnitIncrement(8);
        this.add(jsp, BorderLayout.CENTER); 
	}

	public MyDocument getDocument() {
		return document;
	}

	public void setDocument(MyDocument document) {
		this.document = document;
	}

	public MyToolBar getToolbar() {
		return toolbar;
	}

	public void setToolbar(MyToolBar toolbar) {
		this.toolbar = toolbar;
	}

	public JPanel getMain_panel() {
		return main_panel;
	}

	public void setMain_panel(JPanel main_panel) {
		this.main_panel = main_panel;
	}

	public Dimension getMain_panel_size() {
		return main_panel_size;
	}

	public void setMain_panel_size(Dimension main_panel_size) {
		this.main_panel_size = main_panel_size;
	}

	public Dimension getOutpan() {
		return outpan;
	}

	public void setOutpan(Dimension outpan) {
		this.outpan = outpan;
	}

	public Dimension getInpan() {
		return inpan;
	}

	public void setInpan(Dimension inpan) {
		this.inpan = inpan;
	}

	public Dimension getTxtfld() {
		return txtfld;
	}

	public void setTxtfld(Dimension txtfld) {
		this.txtfld = txtfld;
	}
	
	public void updateAllPages() {
		MyPageView view = null;
		for(int i = 0; i < this.main_panel.getComponentCount(); i++) {
			view = (MyPageView) this.getMain_panel().getComponent(i);
			this.main_panel.revalidate();
    		view.setPreferredSize(this.outpan);
    		view.setPage_panel_size(this.inpan);
    		view.getTxt().setPreferredSize(this.txtfld);
    		view.getJsp().setPreferredSize(this.inpan);
        	view.setVisible(false);
        	view.setVisible(true);
		}
	}

	@Override
	public void update(Observable o, Object object) {
		ObservableInfo observableInfo = (ObservableInfo) object;
		MyPage page = (MyPage) observableInfo.getObject();
		MyPageView view = new MyPageView(page);
		
		if(observableInfo.getID() == 1) {
			this.main_panel.add(view);
		} else if(observableInfo.getID() == 2) {
			for(int i = 0; i < this.main_panel.getComponentCount(); i++) {
				MyPageView pView = (MyPageView) this.main_panel.getComponent(i);
				if(pView.getPage().equals(page)) {
					this.main_panel.remove(pView);
					this.main_panel.setVisible(false);
					this.main_panel.setVisible(true);
				}
			}
		}
		
		MyMainFrame mfinst = MyMainFrame.getInstance();
		DefaultMutableTreeNode ws = (DefaultMutableTreeNode) mfinst.getWorkspaceTree().getModel().getRoot();
		
		DefaultMutableTreeNode[] path = {
				ws, page.getParent_doc().getParent_proj(), page.getParent_doc(), page
		};
		TreePath tp = new TreePath(path);
		mfinst.getWorkspaceTree().expandPath(tp);
		mfinst.getWorkspaceTree().setSelectionPath(tp);
		
		mfinst.getWorkspaceTree().click_helper(null);
		
    	this.main_panel.revalidate();
		view.setPreferredSize(this.outpan);
		view.setPage_panel_size(this.inpan);
		view.getTxt().setPreferredSize(this.txtfld);
		view.getJsp().setPreferredSize(this.inpan);
    	view.setVisible(false);
    	view.setVisible(true);
	}
}
