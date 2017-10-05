package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import app_main.MyMainFrame;
import controller.MyProjViewListeners;
import model.MyDocument;
import model.MyProject;
import model.MyWorkspace;
import model.ObservableInfo;

public class MyProjectView extends JInternalFrame implements Observer {
	private static final long serialVersionUID = 1L;
	
	private static int openFrameCount = 0;
	private final int x_Offset = 10, y_Offset = 10;
	private MyProject project;
	private JTabbedPane tabs;
	
	public MyProjectView(MyProject project) {
		super(project.toString(), true, true, true, true);
		//this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
		this.project = project;
		project.getObservable().addObserver(this);
		this.addInternalFrameListener(new MyProjViewListeners(this));
		
		openFrameCount++;
		
		this.setLocation(x_Offset*(-1+2*openFrameCount), y_Offset*(-1+2*openFrameCount));
		this.setIconifiable(true);
		this.setClosable(true);
		this.setSize(600, 450);
 	    this.setVisible(true);
 	    ImageIcon img = new ImageIcon("src/images/img-trans.png");
		setFrameIcon(img);
		
		tabs = new JTabbedPane();
		tabs.addChangeListener(new MyProjViewListeners(this));
 	    this.add(tabs);
	}
	
	public int getX_Offset() {
		return x_Offset;
	}

	public int getY_Offset() {
		return y_Offset;
	}

	public MyProject getProject() {
		return project;
	}

	public void setProject(MyProject project) {
		this.project = project;
	}

	public JTabbedPane getTabs() {
		return tabs;
	}

	public void setTabs(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	@Override
	public void update(Observable o, Object object) {
		ObservableInfo observableInfo = (ObservableInfo) object;
		MyDocument document = (MyDocument) observableInfo.getObject();
		MyDocumentView view = new MyDocumentView(document);
		
		if(observableInfo.getID() == 1) {
			this.tabs.add(document.toString(), view);
			this.tabs.setSelectedComponent(view);
		} else if (observableInfo.getID() == 2) {
			for(int i = 0; i < this.tabs.getComponentCount(); i++) {
				MyDocumentView dView = (MyDocumentView) this.tabs.getComponent(i);
				if(dView.getDocument().equals(document)) {
					this.tabs.remove(dView);
					this.setVisible(false);
					this.setVisible(true);
				}
			}
		}
		
		MyMainFrame mfinst = MyMainFrame.getInstance();
		DefaultMutableTreeNode[] path = {
			(MyWorkspace) mfinst.getWorkspaceTree().getModel().getRoot(),
			document.getParent_proj(),
			document
		};
		TreePath tp = new TreePath(path);
		mfinst.getWorkspaceTree().expandPath(tp);
		mfinst.getWorkspaceTree().setSelectionPath(tp);
		
		mfinst.getWorkspaceTree().click_helper(null);
	}
}
