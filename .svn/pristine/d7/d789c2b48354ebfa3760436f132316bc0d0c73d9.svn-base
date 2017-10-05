package commands;

import java.util.ArrayList;

import model.MySlot;
import app_main.MyMainFrame;

public class MyCommandManager {
	private ArrayList<MyAbstractCommand> commands = new ArrayList<MyAbstractCommand>();
	private int currentCommand = 0;
	
	public void addCommand(MyAbstractCommand command) {
		while(currentCommand < commands.size()) {
			commands.remove(currentCommand);
		}
		commands.add(command);
		doCommand();
	}
	
	public void doCommand() {
		if(currentCommand < commands.size()) {
			commands.get(currentCommand++).doCommand();
			MyMainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
		}
		if(currentCommand == commands.size()) {
			MyMainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
		}
	}
	
	public void undoCommand() {
		// after delete press reset commands:
		MySlot slot = MyMainFrame.getInstance().getWorkspaceTree().getCurrentSlot(); 
		if(slot.getModel().isElement_removed()) {
			commands = new ArrayList<MyAbstractCommand>();
			currentCommand = 0;
			slot.getModel().setElement_removed(false);
		}
		
		if(currentCommand > 0) {
			MyMainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
			commands.get(--currentCommand).undoCommand();
		}
		
		if(currentCommand == 0) {
			MyMainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
		}
	}

	public ArrayList<MyAbstractCommand> getCommands() {
		return commands;
	}

	public void setCommands(ArrayList<MyAbstractCommand> commands) {
		this.commands = commands;
	}

	public int getCurrentCommand() {
		return currentCommand;
	}

	public void setCurrentCommand(int currentCommand) {
		this.currentCommand = currentCommand;
	}
}
