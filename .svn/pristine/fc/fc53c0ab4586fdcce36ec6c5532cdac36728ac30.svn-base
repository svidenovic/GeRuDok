package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public AboutDialog(Frame owner) {
		super(owner, "About", true);
		setLocationRelativeTo(null);
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(owner);
		
		JLabel lbl = new JLabel();
		ImageIcon img = new ImageIcon("src/images/About.png");
		lbl.setIcon(img);
		
		/*JLabel lbl1 = new JLabel();
		ImageIcon img1 = new ImageIcon("src/images/About.png");
		lbl1.setIcon(img1);*/
		
	    JPanel p = new JPanel();
	    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	    
	    p.add(lbl);
	    //p.add(lbl1);
	    getContentPane().add(p, BorderLayout.WEST);
	    
	    p = new JPanel();
	    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	    
	    JTextArea txt = new JTextArea("\n");
	    txt = new JTextArea(" Zarko Petrovic \n RA169/2013 \n zarkoorion@gmail.com");
	    txt.setFont(new Font("Times New Roman", Font.BOLD, 24));
	    txt.setEditable(false);
	    txt.setBackground(getBackground());
	    
	    p.add(txt);
	    getContentPane().add(p, BorderLayout.EAST);
	    
	    txt = new JTextArea(" Stefan Videnovic \n RA173/2013 \n OISISI - Tim 5.8");
	    txt.setFont(new Font("Times New Roman", Font.BOLD, 24));
	    txt.setEditable(false);
	    txt.setBackground(getBackground());
	    
	    p.add(txt);
	    getContentPane().add(p, BorderLayout.EAST);
	    
		JButton button = new JButton("  Ok  ");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    p = new JPanel();
	    
	    button.setAlignmentX(CENTER_ALIGNMENT);
	    p.add(button);
	    button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getMe().dispose();
			}
		});
	    
	    getContentPane().add(p, BorderLayout.SOUTH);
	}
	
	private AboutDialog getMe() {
		return this;
	}
}
