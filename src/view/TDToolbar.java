package view;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.text.StyledEditorKit;

import app_main.MyMainFrame;

public class TDToolbar extends JToolBar {
	private static final long serialVersionUID = 1L;

	public static JButton btnB;
	public static JButton btnI;
	public static JButton btnU;
	
	public TDToolbar() {
		super(SwingConstants.HORIZONTAL);
		setFloatable(true);
		
		btnB = new JButton();
		ImageIcon iconB = new ImageIcon("src/images/size22/bold.png");
		btnB.setToolTipText(MyMainFrame.getInstance().getResourceBundle().getString("btnBold"));
		btnB.setIcon(iconB);
		btnB.setBorderPainted(false);
		Action actionB = new StyledEditorKit.BoldAction();
		btnB.addActionListener(actionB);
		this.add(btnB);
		
		btnI = new JButton();
		ImageIcon iconI = new ImageIcon("src/images/size22/italic.png");
		btnI.setToolTipText(MyMainFrame.getInstance().getResourceBundle().getString("btnItalic"));
		btnI.setIcon(iconI);
		btnI.setBorderPainted(false);
		Action actionI = new StyledEditorKit.ItalicAction();
		btnI.addActionListener(actionI);
		this.add(btnI);
		
		btnU = new JButton();
		ImageIcon iconU = new ImageIcon("src/images/size22/underline.png");
		btnU.setToolTipText(MyMainFrame.getInstance().getResourceBundle().getString("btnUnderline"));
		btnU.setIcon(iconU);
		btnU.setBorderPainted(false);
		Action actionU = new StyledEditorKit.UnderlineAction();
		btnU.addActionListener(actionU);
		this.add(btnU);
	}
}
