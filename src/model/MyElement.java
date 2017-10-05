package model;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyElement extends DefaultMutableTreeNode {
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String name;
	private int ID;
	private MySlot parent_slot;
	
	public MyElement(String name) {
		super();
		this.name = name;
	}
	public MyElement( MyElement _elem){
		super();
		this.name = new String(_elem.name);
		this.type = new String(_elem.type);
		this.ID = _elem.ID;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MySlot getParent_slot() {
		return parent_slot;
	}

	public void setParent_slot(MySlot parent_slot) {
		this.parent_slot = parent_slot;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
