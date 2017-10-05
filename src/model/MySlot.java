package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

import app_main.MyMainFrame;

public class MySlot extends DefaultMutableTreeNode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private char type;
	private String name;
	private MyPage parent_page;
	private ArrayList<MyElement> elements;
	private ArrayList<Integer> free_indexes;
	private MyObservable observable;
	private MySlotModel model;
	private int ID;
	private MyGraphicSlotSelectionModel selectionModel;
	
	public  MySlot(String name, char type) {
		super();
		this.name = name;
		this.type = type;
		this.elements = new ArrayList<MyElement>();
		this.free_indexes = new ArrayList<Integer>();
		this.observable = new MyObservable();
		this.model = new MySlotModel(this);
	}
	public MySlot( MySlot _slot ){
		this.name = new String(_slot.name);
		this.type = _slot.type;
		this.elements = new ArrayList<MyElement>();
		this.observable = _slot.getObservable();
		this.model = _slot.getModel();
//		this.free_indexes = new ArrayList<Integer>(_slot.free_indexes );
		this.free_indexes = new ArrayList<Integer>();
		this.free_indexes.addAll(_slot.free_indexes );
	}
	
	public MyElement addElement(MyElement element) {
//		MyDocument d = this.getParent_page().getParent_doc();
//		String s = "original";
//		if(d.getOriginal() != null) s = d.getOriginal().toString();
//		JOptionPane.showMessageDialog(null,s);
		
		element.setParent_slot(this);
		element.setID(MyMainFrame.getInstance().getActionManager().getNewGSlotAction().gen_idx(free_indexes, elements));
		element.setName(
			element.getType() + "-" + 
			Integer.toString(element.getID())
		);
		this.elements.add(element);
		this.add((DefaultMutableTreeNode) element);
		
		ObservableInfo observableInfo = new ObservableInfo(element, 1);
		this.observable.setChanged();
		this.observable.notifyObservers(observableInfo);
		
//		MyDocument ppdoc = this.getParent_page().getParent_doc();
//		if(ppdoc.getOriginal() == null){// case this doc is original:
//			for(int i=0; i<ppdoc.get_doc_shares().size(); i++){
//				MyProject proj = ppdoc.get_doc_shares().get(i).getProj();
//				MyDocument doc = ppdoc.get_doc_shares().get(i).getDoc();
//				
//				MyDocument _doc = proj.getDocument(
//					(new MyDocShare( ppdoc.getParent_proj(), doc )).toString()
//				);
//				MyPage _page = _doc.getPage( this.getParent_page().toString() );
//				MySlot _slot = _page.getSlot( element.getParent_slot().toString() );
//				
//				MyElement _elem = new MyElement(element);
//				_elem.setParent_slot(_slot);
//				_slot.elements.add(_elem);
//				_slot.add((DefaultMutableTreeNode)_elem);
//				
//				observableInfo = new ObservableInfo(_elem,1 );
//				_slot.observable.setChanged();
//				_slot.observable.notifyObservers(observableInfo);
//			}
//		}
		
		return element;
	}
	
	public void removeElement(MyElement element) {
		int tmp; 
		ObservableInfo observableInfo;
		int idx;
		
//		MyDocument pdoc = this.getParent_page().getParent_doc();
//		if(pdoc.getOriginal() == null){// case this doc is original:
//			for(int i=0; i<pdoc.get_doc_shares().size(); i++){
//				MyProject proj = pdoc.get_doc_shares().get(i).getProj();
//				MyDocument doc = pdoc.get_doc_shares().get(i).getDoc();
//				
//				MyDocument _doc = proj.getDocument(
//					(new MyDocShare( pdoc.getParent_proj(), doc )).toString()
//				);
//				MyPage _page = _doc.getPage(
//					element.getParent_slot().getParent_page().toString()
//				);
//				MySlot _slot = _page.getSlot(
//					element.getParent_slot().toString()
//				);
//				MyElement _elem = _slot.getElement(
//					element.toString()
//				);
//				
//				tmp = Integer.valueOf(_elem.getID());
//				idx=0; while (idx<_elem.getParent_slot().getElementsCount()){
//					if (_elem.getParent_slot().getElement(idx).getID()
//					== _elem.getID()) break; else idx++;
//				}
//				try{
//					_slot.model.removeElement( 
//						_slot.model.getDeviceAt(idx), false
//					);
//				}catch(IndexOutOfBoundsException ex){
//					System.out.println( "----------\n"+ ex.getMessage() );
//				}
//				_slot.elements.remove(_elem);
//				_slot.remove(_elem);
//				_slot.free_indexes.add(tmp);
//				
//				observableInfo = new ObservableInfo(_elem, 2);
//				_slot.observable.setChanged();
//				_slot.observable.notifyObservers(observableInfo);
//			}
//		}
		
		tmp = (int) Integer.valueOf(element.getID());
		idx=0; while (idx < element.getParent_slot().getElementsCount()){
			if(element.getParent_slot().getElement(idx).getID()
			== element.getID()) break; else idx++;
		}
		try{
			this.model.removeElement( 
				this.model.getDeviceAt(idx), false
			);
		}catch(IndexOutOfBoundsException ex){
			System.out.println( "----------\n"+ ex.getMessage() );
		}
		this.elements.remove(element);
		this.remove(element);
		this.free_indexes.add(tmp);
		
		observableInfo = new ObservableInfo(element, 2);
		this.observable.setChanged();
		this.observable.notifyObservers(observableInfo);
	}
	
	public void removeElements(ArrayList<MyElement> elements) {
		this.elements.removeAll(elements);
	}
	
	public MyElement getElement(int index) {
		return this.elements.get(index);
	}
	public MyElement getElement(String name) {
		for(MyElement elem_it : this.elements){
			if(elem_it.toString().equals(name))
				return elem_it;
		}
		return null;
	}
	
	public int getElementIndex(MyElement element) {
		return this.elements.indexOf(element);
	}
	
	public int getElementsCount() {
		return this.elements.size();
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

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public MyPage getParent_page() {
		return parent_page;
	}

	public void setParent_page(MyPage parent_page) {
		this.parent_page = parent_page;
	}

	public MySlotModel getModel() {
		return model;
	}

	public void setModel(MySlotModel model) {
		this.model = model;
	}

	public MyObservable getObservable() {
		return observable;
	}

	public void setObservable(MyObservable observable) {
		this.observable = observable;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public MyGraphicSlotSelectionModel getSelectionModel() {
		if(selectionModel == null)
			selectionModel = new MyGraphicSlotSelectionModel();
		return selectionModel;
	}
}
