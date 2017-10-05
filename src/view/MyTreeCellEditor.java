package view;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import controller.MyTCEListeners;

public class MyTreeCellEditor extends DefaultTreeCellEditor {
	
	private Object obj; // tt
	private JTextField edit;
	
	public MyTreeCellEditor(JTree tree, DefaultTreeCellRenderer dtcr) {
		super(tree, dtcr);
	}

	public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
		super.getTreeCellEditorComponent(arg0, arg1, arg2, arg3, arg4, arg5);
		obj = arg1;
		edit = new JTextField(arg1.toString());
		edit.addActionListener(new MyTCEListeners(this));
		return edit;
	}

	public Object getCellEditorValue() { return null; }

	public boolean isCellEditable(EventObject eo) {
		if (eo instanceof MouseEvent) {
			if (((MouseEvent)eo).getButton() == 3){
				return true;
			}
			else return false;
		}
		return false;
	}
	
	public boolean shouldSelectCell(EventObject eo) { return true; }
	public boolean stopCellEditing() { return true; }
	public void cancelCellEditing() {}
	public void addCellEditorListener(CellEditorListener cel) {}
	public void removeCellEditorListener(CellEditorListener cel) {}
	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	/*public void actionPerformed(ActionEvent e){
      ((MyProject)obj).setName(e.getActionCommand());	
    }*/
}
