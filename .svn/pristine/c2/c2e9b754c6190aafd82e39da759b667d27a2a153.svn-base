package actions;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFileFilter_ws extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || 
                f.getName().toLowerCase().endsWith(".gws"));
	}

	@Override
	public String getDescription() {
		return "GeRuDok workspace files (*.gws)";
	}
}