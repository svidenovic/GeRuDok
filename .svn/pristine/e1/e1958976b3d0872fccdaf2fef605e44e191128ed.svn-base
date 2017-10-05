package model;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultSingleSelectionModel;
import javax.swing.event.EventListenerList;

import events.MyUpdateEvent;
import events.MyUpdateListener;
import model.element.MySlotElement;

public class MyGraphicSlotSelectionModel extends DefaultSingleSelectionModel {
	private static final long serialVersionUID = 1L;

	private ArrayList<MySlotElement> selectionList = new ArrayList<MySlotElement>();
	
	EventListenerList listenerList = new EventListenerList();
	MyUpdateEvent updateEvent = null;	
	
	public void addToSelectionList(MySlotElement element) {
		selectionList.add(element);
		fireUpdatePerformed();
	}
	
	public void addToSelectionList(ArrayList<MySlotElement> list) {
		selectionList.addAll(list);
		fireUpdatePerformed();
	}
	
	public int getSelectionListSize() {
		return selectionList.size();
	}
	
	public MySlotElement getElementFromSelectionListAt(int index) {
		return (MySlotElement)selectionList.get(index);
	}
	
	public int getIndexByObject(MySlotElement element) {
		return selectionList.indexOf(element);
	}
	
	public void removeFromSelectionList(MySlotElement element) {
		selectionList.remove(element);
		fireUpdatePerformed();
	}
	
	public void removeAllFromSelectionList() {
		selectionList.clear();
		fireUpdatePerformed();
	}
	
	public ArrayList<MySlotElement> getSelectionList() {
		return selectionList;
	}
	
	public Iterator<MySlotElement> getSelectionListIterator(){
		return selectionList.iterator();
	}
	
	public boolean isElementSelected(MySlotElement element){
		return selectionList.contains(element);
	}
	
	public void selectElements(Rectangle2D rec, ArrayList<MySlotElement> elements) {
		Iterator<MySlotElement> it = elements.iterator();
		
		while(it.hasNext()) {
			MySlotElement element = it.next();
			if (element instanceof MySlotElement) {
				MySlotElement device = (MySlotElement)element;
				if(rec.intersects(device.getPosition().getX(), device.getPosition().getY(),
						device.getSize().getWidth(), device.getSize().getHeight())) {
					if(!isElementSelected(device))
						selectionList.add(device);
				}
			}
		}
	}
	
	public ArrayList<MySlotElement> getSelected() {
		ArrayList<MySlotElement> selected = new ArrayList<MySlotElement>();
		selected.addAll(selectionList);
		
		return selected;
	}

	public void addUpdateListener(MyUpdateListener l) {
		listenerList.add(MyUpdateListener.class, l);
	}
	
	public void removeUpdateListener(MyUpdateListener l) {
	    listenerList.remove(MyUpdateListener.class, l);
	}
	 
	public void fireUpdatePerformed() {
		Object[] listeners = listenerList.getListenerList();
	    for (int i = listeners.length-2; i >= 0; i -= 2) {
	    	if (listeners[i] == MyUpdateListener.class) {
	    		if (updateEvent == null)
	    			updateEvent = new MyUpdateEvent(this);
	    		((MyUpdateListener)listeners[i+1]).updatePerformed(updateEvent);
	         }
	     }
	}
}
