package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.MyTBListeners;
import net.miginfocom.swing.MigLayout;


public class MyToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	private int cols;
	
	public MyToolBar(int n) {
		super(SwingConstants.HORIZONTAL);
		this.cols = 1;
		setFloatable(true);
		for(int i = 1; i <= n; i++) {
			JButton btn = new JButton(" " + Integer.toString(i) + " ");
			btn.addMouseListener(new MyTBListeners(this));
			add(btn);
		}
	}
	
	public void holder_update() {
		MyDocumentView holder = (MyDocumentView) this.getParent();

		int w = (int) (holder.getMain_panel_size().getWidth()
				-((this.cols+1)*5 + 20) )/this.cols;
		holder.setOutpan(new Dimension(w, w));
		
		holder.setTxtfld(new Dimension( (int)holder.getOutpan().getWidth(), 20 ));
        holder.setInpan(new Dimension( 
			(int) holder.getOutpan().getWidth(),
			(int) (holder.getOutpan().getHeight() - holder.getTxtfld().getHeight())
		));
        
        holder.updateAllPages();
		holder.getMain_panel().setLayout(new MigLayout( "wrap " + Integer.toString(this.cols) ));
		
		holder.getMain_panel().revalidate();
		holder.getMain_panel().setVisible(false);
		holder.getMain_panel().setVisible(true);
	}
	
	public int getCols() {
		return cols;
	}
	
	public void setCols(int cols) {
		this.cols = cols;
	}
}
