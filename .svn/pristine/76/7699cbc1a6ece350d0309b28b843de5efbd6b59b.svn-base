package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.EventListenerList;

import app_main.MyMainFrame;
import events.MyUpdateEvent;
import events.MyUpdateListener;
import model.element.MySlotElement;

public class MySlotModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static int count = 0;
	private String name;
	private MySlot relevant_slot;
	private boolean element_removed;
	
	protected ArrayList<MySlotElement> slotElements = new ArrayList<MySlotElement>();
	EventListenerList listenerList = new EventListenerList();
	MyUpdateEvent updateEvent = null;
	private ArrayList<MyElement> undone_elems;
	
	public MySlotModel(MySlot slot) { 
		this.relevant_slot = slot; 
		this.undone_elems = new ArrayList<MyElement>();
		this.element_removed = false;
	}
	public MySlotModel(MySlotModel model) {
		this.relevant_slot = new MySlot( model.relevant_slot); 
		this.undone_elems = new ArrayList<MyElement>();
		this.element_removed = false;
	}
	
	private Object readResolve() {
		listenerList = new EventListenerList();	
		return this;
	}
	
	public int getUndoElementCount() { return undone_elems.size(); }
	
	public static int getCount() { return count; }
	public static void setCount(int count) { MySlotModel.count = count; }
	public int getElementCount() { return slotElements.size(); }
	public String toString() { return name; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public MySlotElement getDeviceAt(int i) { return slotElements.get(i); }
	
	public Iterator<MySlotElement> getDeviceIterator() {
		return slotElements.iterator();
	}
	
	public int getDeviceAtPosition(Point point) {
		for(int i = getElementCount() - 1; i >= 0; i-- ) {
			MySlotElement device = getDeviceAt(i);
			if(device.getElementPainter().elementAt(point)) {
				return i;
			}
		}
		return -1;
	}
	
	public MySlotElement getElementAt(int i){
		return slotElements.get(i);
	}
	
	public void addSlotElements(MySlotElement element, boolean redo) {
		if(redo) {
			MyMainFrame mmf = MyMainFrame.getInstance();
			MySlot slot = mmf.getWorkspaceTree().getCurrentSlot();
			if(this.undone_elems.size() > 0) {
				MyElement elem = this.undone_elems.get(
					this.undone_elems.size()-1
				);
				this.undone_elems.remove(
					this.undone_elems.size()-1
				);
				slot.addElement(elem); // add to tree
				slotElements.add(element); // add to view
			}
		} else {
			slotElements.add(element); // add to view
			this.element_removed = false;
		}
		fireUpdatePerformed();
	}
	
	public void removeElement(MySlotElement element, boolean undo) {
		if(undo) {
			MyMainFrame mmf = MyMainFrame.getInstance();
			MySlot slot = mmf.getWorkspaceTree().getCurrentSlot();
			MyElement elem = null;
			int idx = 0;
			while(idx < slot.getElementsCount()) {
				elem = slot.getElement(idx);
				if(elem.getID() == element.relevant_element_ID) break;
				else idx++;
			}
			
			this.undone_elems.add(elem);
			slot.removeElement(elem);
			slotElements.remove(element);
			this.element_removed = false;
		} else {
			slotElements.remove(element); // remove from view
			this.element_removed = true;
		}
		fireUpdatePerformed();
	}
	
	/*public void addAllSelectedElements() {
		slotElements.addAll(this.relevant_slot.getSelectionModel().getSelected());
	}*/
	
	public void removeAllSelectedElements() {
		slotElements.removeAll(this.relevant_slot.getSelectionModel().getSelected());
	}
	
	public void addUpdateListener(MyUpdateListener l) {
		listenerList.add(MyUpdateListener.class, l);
	}
	
	public void removeUpdateListener(MyUpdateListener l) {
		listenerList.remove(MyUpdateListener.class, l);
	}
	
	protected void fireUpdatePerformed() {
		Object[] listeners = listenerList.getListenerList();
		for(int i = listeners.length - 1; i >= 0; i -= 1) {
			if(listeners[i] == MyUpdateListener.class) {
				if(updateEvent == null)
					updateEvent = new MyUpdateEvent(this);
				((MyUpdateListener)listeners[i+1]).updatePerformed(updateEvent);
			}
		}
	}
	
	public MySlot getRelevant_slot() {
		return relevant_slot;
	}

	public void setRelevant_slot(MySlot relevant_slot) {
		this.relevant_slot = relevant_slot;
	}

	public boolean isElement_removed() {
		return element_removed;
	}

	public void setElement_removed(boolean element_removed) {
		this.element_removed = element_removed;
	}
}
