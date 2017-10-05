package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import app_main.MyMainFrame;
import controller.MyPageViewListeners;
import model.MyPage;
import model.MySlot;
import model.MyWorkspace;
import model.ObservableInfo;
import net.miginfocom.swing.MigLayout;

public class MyPageView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	
	private MyPage page;
	private JPanel page_panel; // white
	private Dimension page_panel_size;
	private JTextField txt;
	private JScrollPane jsp;
	
	public MyPageView(MyPage page) {
		super();
		this.page = page;
		this.page.getObservable().addObserver(this);
		this.addComponentListener(new MyPageViewListeners(this));
		
		// outpan:
		this.setLayout(new MigLayout("wrap 1"));
		this.setBackground(Color.BLACK);
		this.addMouseListener(new MyPageViewListeners(this));
		
		// inpan:
		this.page_panel = new JPanel();
		this.page_panel.setLayout(new MigLayout("wrap 1"));
		this.page_panel.setBackground(Color.WHITE);
		this.page_panel.addMouseListener(new MyPageViewListeners(this));
		this.page_panel.validate();
		
		// txtfld:
		this.txt = new JTextField(this.page.toString());
		this.txt.setEditable(false);
		this.txt.addMouseListener(new MyPageViewListeners(this));
		this.txt.setHorizontalAlignment(JTextField.CENTER);
		
		jsp = new JScrollPane(this.page_panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	        	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	    );
		jsp.getVerticalScrollBar().setUnitIncrement(8);
		
		this.make_deselected();
		this.add(jsp, "dock north");
		this.add(this.txt, "dock south");
		
		this.setVisible(false);
		this.setVisible(true);
	}
	
	public void make_selected() {
		this.txt.setForeground(Color.decode("#1B6798"));
		this.txt.setBackground(Color.decode("#DCDCDC"));
		this.page_panel.setBackground(Color.decode("#96B8CD"));
	}
	
	public void make_deselected() {
		this.txt.setForeground(Color.decode("#000000"));
		this.txt.setBackground(Color.decode("#DEDEDE"));
		this.page_panel.setBackground(Color.decode("#FFFFFF"));
	}

	public MyPage getPage() {
		return page;
	}

	public void setPage(MyPage page) {
		this.page = page;
	}

	public JPanel getPage_panel() {
		return page_panel;
	}

	public void setPage_panel(JPanel page_panel) {
		this.page_panel = page_panel;
	}

	public Dimension getPage_panel_size() {
		return page_panel_size;
	}

	public void setPage_panel_size(Dimension page_panel_size) {
		this.page_panel_size = page_panel_size;
	}

	public JTextField getTxt() {
		return txt;
	}

	public void setTxt(JTextField txt) {
		this.txt = txt;
	}

	public JScrollPane getJsp() {
		return jsp;
	}

	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}
	
	public void updateAllSlots() {
		MySlotView view = null;
		for(int i = 0; i < this.page_panel.getComponentCount(); i++) {
			view = (MySlotView) this.page_panel.getComponent(i);
			this.page_panel.revalidate();
			Dimension op_size = new Dimension((int) this.page_panel.getWidth()-30,
											  (int) this.page_panel.getHeight()-30
			);
			Dimension txt_size = this.txt.getSize();
			view.setPreferredSize(op_size);
			view.getSlot_panel().setPreferredSize( new Dimension(
					(int) op_size.getWidth(),
					(int)(op_size.getHeight()-txt_size.getHeight())
			));
			view.getTxt().setPreferredSize(txt_size);
			view.revalidate();
			this.page_panel.revalidate();
		}
	}

	@Override
	public void update(Observable o, Object object) {
		ObservableInfo observableInfo = (ObservableInfo) object;
		MySlot slot = (MySlot) observableInfo.getObject();
		MySlotView view = new MySlotView(slot);
		
		if(observableInfo.getID() ==  1) {
			this.page_panel.add(view);
		} else if (observableInfo.getID() == 2) {
			for(int i = 0; i < this.page_panel.getComponentCount(); i++) {
				MySlotView sView = (MySlotView) this.page_panel.getComponent(i);
				if(sView.getSlot().equals(slot)) {
					this.page_panel.remove(sView);
					this.page_panel.setVisible(false);
					this.page_panel.setVisible(true);
				}
			}
		}
		
		DefaultMutableTreeNode[] path = {
			(MyWorkspace) MyMainFrame.getInstance().getWorkspaceTree().getModel().getRoot(),
			slot.getParent_page().getParent_doc().getParent_proj(),
			slot.getParent_page().getParent_doc(),
			slot.getParent_page(),
			slot
		};
		
		TreePath tp = new TreePath(path);
		MyMainFrame.getInstance().getWorkspaceTree().expandPath(tp);
		MyMainFrame.getInstance().getWorkspaceTree().setSelectionPath(tp);
		
		MyMainFrame.getInstance().getWorkspaceTree().click_helper(null);
		
		this.page_panel.revalidate();
		Dimension op_size = new Dimension((int) this.page_panel.getWidth()-30,
										  (int) this.page_panel.getHeight()-30
		);
		Dimension txt_size = this.txt.getSize();
		view.setPreferredSize(op_size);
		view.getSlot_panel().setPreferredSize( new Dimension(
				(int) op_size.getWidth(),
				(int)(op_size.getHeight()-txt_size.getHeight())
		));
		view.getTxt().setPreferredSize(txt_size);
		view.revalidate();
		this.page_panel.revalidate();
	}
}
