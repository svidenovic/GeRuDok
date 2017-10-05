package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app_main.MyMainFrame;

public class MyStatusBar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private StatusPane status = new StatusPane(MyMainFrame.getInstance().getResourceBundle().getString("sBState"));
	private StatusPane elementType = new StatusPane(MyMainFrame.getInstance().getResourceBundle().getString("sBEType"));
	private StatusPane elementName = new StatusPane(MyMainFrame.getInstance().getResourceBundle().getString("sBEName"));
	private StatusPane position = new StatusPane(MyMainFrame.getInstance().getResourceBundle().getString("sBPosition"));
	private StatusPane dimension = new StatusPane(MyMainFrame.getInstance().getResourceBundle().getString("sBDimension"));
	
	public MyStatusBar(){
		setLayout(new GridLayout());
		add(status);
		add(elementType);
		add(elementName);
		add(position);
		add(dimension);
	}
	
	private class StatusPane extends JLabel{
		private static final long serialVersionUID = 1L;

		public StatusPane (String text){
			setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
			setBackground(Color.GRAY);
			setPreferredSize(new Dimension(170,20));
			setHorizontalAlignment(CENTER);
			setText(text);
		}
	}
	
	public void setStatus(String status){
		this.status.setText(status);
	}
	
	public void setElementType(String elementType){
		this.elementType.setText(elementType);
	}
	
	public void setElementName(String elementName){
		this.elementName.setText(elementName);
	}
	
	public void setPosition(String position){
		this.position.setText(position);
	}
	
	public void setDimension(String dimension){
		this.dimension.setText(dimension);
	}
	
	public void initComponents() {
		status.setText(MyMainFrame.getInstance().getResourceBundle().getString("sBState"));
		elementType.setText(MyMainFrame.getInstance().getResourceBundle().getString("sBEType"));
		elementName.setText(MyMainFrame.getInstance().getResourceBundle().getString("sBEName"));
		position.setText(MyMainFrame.getInstance().getResourceBundle().getString("sBPosition"));
		dimension.setText(MyMainFrame.getInstance().getResourceBundle().getString("sBDimension"));
	}
}
