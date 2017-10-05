package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

import app_main.MyMainFrame;

public class MyPage extends DefaultMutableTreeNode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private MyObservable observable;
	private ArrayList<MySlot> slots;
	private ArrayList<Integer> free_indexes;
	private MyDocument parent_doc;
	private int ID;
	
	public MyPage(String name) {
		super(name);
		this.name = name;
		this.slots = new ArrayList<MySlot>();
		this.free_indexes = new ArrayList<Integer>();
		this.observable = new MyObservable();
	}
	public MyPage( MyPage _page ){
		super( new String(_page.name) );
		this.name = new String(_page.name);
		this.slots = new ArrayList<MySlot>();
		this.observable = new MyObservable();
		this.free_indexes = new ArrayList<Integer>(_page.free_indexes);
	}
	
	public void addSlot(MySlot slot) {
		slot.setParent_page(this);
		slot.setID(MyMainFrame.getInstance().getActionManager().getNewPageAction().gen_idx(free_indexes, slots));
		if( slot.getName().equals(" ") ){
			slot.setName( 
				slot.getType() + "-Slot-" + 
				Integer.toString( slot.getID() )
			);
		}
		this.slots.add(slot);
		this.add((DefaultMutableTreeNode) slot);
		
		ObservableInfo observableInfo = new ObservableInfo(slot, 1);
		this.observable.setChanged();
		this.observable.notifyObservers(observableInfo);
		
		MyDocument pdoc = this.getParent_doc();
		if(pdoc.getOriginal() == null){// case this doc is original:
			for(int i=0; i<pdoc.get_doc_shares().size(); i++){
				MyProject proj = pdoc.get_doc_shares().get(i).getProj();
				MyDocument doc = pdoc.get_doc_shares().get(i).getDoc();
				
				MyDocument _doc = proj.getDocument(
					(new MyDocShare( pdoc.getParent_proj(), doc )).toString()
				);
				MyPage _page = _doc.getPage( slot.getParent_page().toString() );
				
				MySlot _slot = new MySlot( slot );
				_slot.setParent_page(_page);
				_page.slots.add(_slot );
				_page.add((DefaultMutableTreeNode)_slot);
				
				observableInfo = new ObservableInfo(_slot,1 );
				_page.observable.setChanged();
				_page.observable.notifyObservers(observableInfo);
			}
		}
	}
	
	public void removeSlot(MySlot slot) {
		for(int i = 0; i < slot.getElementsCount(); i++)
			slot.removeElement(slot.getElement(i));
		
		Integer tmp = Integer.valueOf(slot.getID());
		
		this.slots.remove(slot);
		this.remove(slot);
		this.free_indexes.add(tmp);
		
		this.parent_doc.getParent_proj().setChanged(true);
		
		ObservableInfo observableInfo = new ObservableInfo(slot, 2);
		
		this.observable.setChanged();
		this.observable.notifyObservers(observableInfo);
		
		MyDocument pdoc = this.getParent_doc();
		if(pdoc.getOriginal() == null){// case this doc is original:
			for(int i=0; i<pdoc.get_doc_shares().size(); i++){
				MyProject proj = pdoc.get_doc_shares().get(i).getProj();
				MyDocument doc = pdoc.get_doc_shares().get(i).getDoc();
				
				MyDocument _doc = proj.getDocument(
					(new MyDocShare( pdoc.getParent_proj(), doc )).toString()
				);
				MyPage _page = _doc.getPage( slot.getParent_page().toString() );
				MySlot _slot = _page.getSlot( slot.toString() );
				for(int e=0; e<_slot.getElementsCount(); e++){
					_slot.removeElement(_slot.getElement(e));
				}
				_page.slots.remove(_slot);
				_page.remove(_slot);
				_page.free_indexes.add( Integer.valueOf(_slot.getID()) );
				
				observableInfo = new ObservableInfo(_slot, 2);
				_page.observable.setChanged();
				_page.observable.notifyObservers(observableInfo);
			}
		}
	}
	
	public MySlot getSlot(int index) {
		return this.slots.get(index);
	}
	public MySlot getSlot(String name) {
		for(MySlot slotit : this.slots){
			if(slotit.toString().equals(name))
				return slotit;
		}
		return null;
	}
	
	public int getSlotIndex(MySlot slot) {
		return this.slots.indexOf(slot);
	}
	
	public int getSlotCount() {
		return this.slots.size();
	}
	
	@Override
	public String toString() {
		return (this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyObservable getObservable() {
		return observable;
	}

	public void setObservable(MyObservable observable) {
		this.observable = observable;
	}

	public MyDocument getParent_doc() {
		return parent_doc;
	}

	public void setParent_doc(MyDocument parent_doc) {
		this.parent_doc = parent_doc;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
