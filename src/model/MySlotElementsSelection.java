package model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import model.element.MySlotElement;

public class MySlotElementsSelection implements Transferable, ClipboardOwner {

	static public DataFlavor elementFlavor;

	private DataFlavor[] supportedFlavors = { elementFlavor };
	public ArrayList<MySlotElement> slotElements = new ArrayList<MySlotElement>();
	
	public MySlotElementsSelection(ArrayList<MySlotElement> elements) {
		slotElements = elements;
		
		try {
			elementFlavor = new DataFlavor(Class.forName("java.util.ArrayList"), "Elements");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elementFlavor))
			return (slotElements);
		else
			throw new UnsupportedFlavorException(elementFlavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return (supportedFlavors);
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(elementFlavor));
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		
	}
}
