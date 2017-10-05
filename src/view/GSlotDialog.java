package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.MyGSCListeners;
import net.miginfocom.swing.MigLayout;
import app_main.MyMainFrame;

public class GSlotDialog extends JDialog implements Observer {
	private static final long serialVersionUID = 1L;
	
	private JPanel p;
	private MySlotView view;
	private GDToolbar toolbar;
	private MyGslotCanvas canvas;
	
	public GSlotDialog(MySlotView view) {
		super();
		this.view = view;
		this.view.getSlot().getObservable().addObserver(this);
		this.setTitle(this.view.getSlot().getName());
		this.setSize(400, 400);
		this.setResizable(false);
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		
		this.setLocation(
			(int) MyMainFrame.getInstance()
				.getDesktop().getLocation().getX()+10,
			(int) MyMainFrame.getInstance()
				.getDesktop().getLocation().getY()+100
		);
		
		p = new JPanel(new MigLayout("wrap 1"));
		
		this.toolbar = new GDToolbar(this);
        p.add(this.toolbar, "dock north");
        
        this.canvas = new MyGslotCanvas(this.view);
        this.canvas.addMouseListener(new MyGSCListeners(this.view));
        this.canvas.addMouseMotionListener(new MyGSCListeners(this.view));
        this.canvas.addMouseWheelListener(new MyGSCListeners(this.view));
        this.canvas.setBackground(Color.WHITE);
        this.canvas.setPreferredSize(new Dimension(
        		(int) this.getWidth(),
    			(int) this.getHeight()-toolbar.getHeight()
        ));
        p.add(this.canvas, "dock south");
        
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

	public GDToolbar getToolbar() {
		return toolbar;
	}

	public void setToolbar(GDToolbar toolbar) {
		this.toolbar = toolbar;
	}

	public MyGslotCanvas getCanvas() {
		return canvas;
	}

	public void setCanvas(MyGslotCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void update(Observable o, Object object) {
		
	}
}
