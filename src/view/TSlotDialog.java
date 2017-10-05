package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import controller.MyTSDListeners;
import app_main.MyMainFrame;
import net.miginfocom.swing.MigLayout;

public class TSlotDialog extends JDialog implements Observer {
	private static final long serialVersionUID = 1L;

	private JPanel p;
	private JTextPane textPane;
	private MySlotView view;

	public TSlotDialog(MySlotView view) {
		super();
		this.view = view;
		this.view.getSlot().getObservable().addObserver(this);
		this.setVisible(false);
		this.setTitle(this.view.getSlot().getName());
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		
		this.setLocation(
			(int) MyMainFrame.getInstance()
				.getDesktop().getLocation().getX()+10,
			(int) MyMainFrame.getInstance()
				.getDesktop().getLocation().getY()+100
		);
		
		this.setSize(400, 400);
		
		p = new JPanel(new MigLayout("wrap 1"));
		
		TDToolbar toolbar = new TDToolbar();
        p.add(toolbar, "dock north");
        
        textPane = new JTextPane();
        textPane.addKeyListener(new MyTSDListeners(this));
        textPane.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JScrollPane jsp = new JScrollPane(textPane, 
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		);
		jsp.setPreferredSize(new Dimension(
			(int) this.getWidth(),
			(int) this.getHeight()-toolbar.getHeight()
		));
		p.add(jsp, "dock south");
		
		this.add(p);
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}

	public JPanel getP() {
		return p;
	}

	public void setP(JPanel p) {
		this.p = p;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

	@Override
	public void update(Observable o, Object object) {
		
	}
}
