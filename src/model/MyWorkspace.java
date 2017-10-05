package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import app_main.MyMainFrame;

public class MyWorkspace extends DefaultMutableTreeNode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<MyProject> projects;
	private ArrayList<Integer> free_indexes;
	private String name;
	private File ws_folder;
	
	public File getWs_folder(){ return ws_folder; }
	public void setWs_folder(File ws_folder) {
		this.ws_folder = ws_folder;
	}
	
	public String getName(){ return name; }
	public void setName(String name){ this.name = name; }

	//Naslediti DefaultMutableTreeNode i u njoj staviti protected observable i get i set.
	private MyObservable observable;
	
	public MyWorkspace(String name) {
		super();
		this.projects = new ArrayList<MyProject>();
		this.free_indexes = new ArrayList<Integer>();
		this.observable = new MyObservable();
		this.name = name;
	}
	
	@Override public String toString() { return this.name; }
	
	public void addProject(MyProject project) {
		project.setID(MyMainFrame.getInstance().gen_idx(free_indexes, projects));
		if( project.getName().equals(" ") )
			project.setName("Project " + Integer.toString(project.getID()) );
		this.projects.add(project);
		this.add((DefaultMutableTreeNode) project);
		project.set_open(true);
		
		ObservableInfo observableInfo = new ObservableInfo(project, 1);
		this.observable.setChanged();
		this.observable.notifyObservers(observableInfo);
	}
	
	public void removeProject(MyProject project) {
		MyDocument _doc = null;
		for(int i = 0; i < project.getDocumentCount(); i++) {
			_doc = project.getDocument(i);
			
			project.removeDocument(_doc);
		}
		
		Integer tmp = Integer.valueOf(project.getID());
		
		this.projects.remove(project);
		this.remove(project);
		this.free_indexes.add(tmp);
		
		ObservableInfo observableInfo = new ObservableInfo(project, 2);
		this.observable.setChanged();
		this.observable.notifyObservers(observableInfo);
	}
	
	public MyProject getProject(int index) {
		return projects.get(index);
	}
	public MyProject getProject(String name) {
		for (MyProject pit : this.projects){
			if(pit.toString().equals(name))
				return pit;
		}
		return null;
	}
	
	public int getProjectIndex(MyProject proj) {
		return projects.indexOf(proj);
	}
	
	public int getProjectsCount() {
		return projects.size();
	}

	public MyObservable getObservable() {
		return observable;
	}

	public void setObservable(MyObservable observable) {
		this.observable = observable;
	}
}
