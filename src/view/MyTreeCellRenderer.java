package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.MyDocument;
import model.MyElement;
import model.MyPage;
import model.MyProject;
import model.MySlot;
import model.MyWorkspace;

@SuppressWarnings("serial")
public class MyTreeCellRenderer extends DefaultTreeCellRenderer {
	public MyTreeCellRenderer(){}
	
	public Component getTreeCellRendererComponent(
		JTree tree,
		Object value,
		boolean sel,
		boolean expanded,
		boolean leaf,
		int row,
		boolean hasFocus
	) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		JLabel iconLabel = null;
		if(value instanceof MyWorkspace) {
			iconLabel = changingImageSize(16, 16, "src/images/stack.png");
			setIcon(iconLabel.getIcon());
		} else if(value instanceof MyProject) {
			iconLabel = changingImageSize(16, 16, "src/images/project.png");
			setIcon(iconLabel.getIcon());	
		} else if(value instanceof MyDocument) {
			iconLabel = changingImageSize(16, 16, "src/images/Book.png");
			setIcon(iconLabel.getIcon());
		} else if(value instanceof MyPage) {
			iconLabel = changingImageSize(16, 16, "src/images/page_blank.png");
			setIcon(iconLabel.getIcon());
		} else if(value instanceof MySlot) {
			if( ((MySlot) value).getType() == 'T' ){
				iconLabel = changingImageSize(
					16, 16, "src/images/TextSlot.png"
				);
			}else if( ((MySlot) value).getType() == 'G' ){
				iconLabel = changingImageSize(
					16, 16, "src/images/GraphicSlot.png"
				);
			}
			setIcon(iconLabel.getIcon());
		} else if(value instanceof MyElement) {
			if(((MyElement) value).getType().equals("Rectangle")) {
				iconLabel = changingImageSize(16, 16, "src/images/rectangle.png");
				setIcon(iconLabel.getIcon());
			} else if(((MyElement) value).getType().equals("Circle")) {
				iconLabel = changingImageSize(16, 16, "src/images/circle.png");
				setIcon(iconLabel.getIcon());
			}
		}
		return this;
	}
	
	JLabel changingImageSize(int height, int width, String s) {
		ImageIcon icon = new ImageIcon(s);
		Image img = icon.getImage().getScaledInstance(height, width, Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(img));
		return label;
	}
}
