package actions;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || 
                f.getName().toLowerCase().endsWith(".gdf"));
	}

	@Override
	public String getDescription() {
		return "GeRuDok Files (*.gdf)";
	}
}
