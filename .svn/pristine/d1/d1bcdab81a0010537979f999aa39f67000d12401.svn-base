package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MyProject;
import view.MyTreeCellEditor;

public class MyTCEListeners implements ActionListener {
	private MyTreeCellEditor editor;
	
	public MyTCEListeners(MyTreeCellEditor editor) {
		this.editor = editor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((MyProject) this.editor.getObj()).setName(e.getActionCommand());
	}

}
