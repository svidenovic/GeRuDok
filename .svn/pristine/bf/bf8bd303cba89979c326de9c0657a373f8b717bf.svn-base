package app_main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import actions.MyActionManager;
import gui.MyMenu;
import gui.MyStatusBar;
import gui.MyToolbar;
import gui.MyWorkspaceTree;
import model.MyDocument;
import model.MyPage;
import model.MyProject;
import model.MySlot;
import model.MyWorkspace;
import model.ObservableInfo;
import view.MyWorkspaceView;

public class MyMainFrame extends JFrame implements ClipboardOwner {
	private static final long serialVersionUID = 1L;
	
	private static MyMainFrame instance = null;
	private MyActionManager actionManager;
	private MyMenu menu;
	private MyToolbar toolbar;
	private MyStatusBar statusBar;
	private MyWorkspaceTree workspaceTree;
	private MyWorkspace workspace;
	private MyWorkspaceView desktop;
	private File workspace_file;
	
	public File get_Workspace_file(){ return this.workspace_file; }
	public void set_Workspace_file(File workspace_file) {
		this.workspace_file = workspace_file;
	}

	private ResourceBundle resourceBundle;
	
	private Clipboard clipboard = new Clipboard("GeRuDok clipboard");
	
	public MyMainFrame() {
		/*String[] languages = {"en_US", "sr_RS"};
		String seld_langs = (String) JOptionPane.showInputDialog(null, "Select a language: ", "Input", 
				JOptionPane.QUESTION_MESSAGE, null, languages, languages[0]
		);*/
		
		Locale.setDefault(new Locale("en", "US"));
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
		System.out.println(Locale.getDefault().toString());
	}
	
	private void init_() {
		actionManager = new MyActionManager();
		
		this.init_GUI();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
	
	private void init_GUI() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		setTitle(resourceBundle.getString("appTitle"));
		//this.setTitle(" GeRuDok (Tim-5.8) ");
		Image img = kit.getImage("src/images/Stack.png");
		this.setIconImage(img);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.menu = new MyMenu();
		this.setJMenuBar(this.menu);
		
		this.toolbar = new MyToolbar();
		this.getContentPane().add(this.toolbar, BorderLayout.NORTH);
		
		MyWorkspace workspace = this.init_WorkspaceTree();
		
		this.desktop = new MyWorkspaceView(workspace);
		desktop.setBackground(Color.white);
		
		JScrollPane scroll = new JScrollPane(this.workspaceTree);
		scroll.setMinimumSize(new Dimension(200, 150));
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, this.desktop);
		getContentPane().add(split, BorderLayout.CENTER);
		split.setDividerLocation(250);
		split.setOneTouchExpandable(true);
		
		this.statusBar = new MyStatusBar();
		this.getContentPane().add(this.statusBar, BorderLayout.SOUTH);
		
		// open everything:
		ObservableInfo observableInfo = null;
		for(int p = 0; p < workspace.getProjectsCount(); p++){
			MyProject project = workspace.getProject(p);
			observableInfo = new ObservableInfo(project, 1);
			workspace.getObservable().setChanged();
			workspace.getObservable().notifyObservers(observableInfo);
			for(int i = 0; i < project.getDocumentCount(); i++) {
		    	MyDocument document = project.getDocument(i);
		    	observableInfo = new ObservableInfo(document, 1);
		    	project.getObservable().setChanged();
		    	project.getObservable().notifyObservers(observableInfo);
		    	for(int j = 0; j < document.getPageCount(); j++) {
		    		MyPage page = document.getPage(j);
		    		observableInfo = new ObservableInfo(page, 1);
		    		document.getObservable().setChanged();
			    	document.getObservable().notifyObservers(observableInfo);
			    	for(int k = 0; k < page.getSlotCount(); k++) {
			    		MySlot slot = page.getSlot(k);
			    		observableInfo = new ObservableInfo(slot, 1);
			    		page.getObservable().setChanged();
				    	page.getObservable().notifyObservers(observableInfo);
				    	/*for(int l = 0; l < slot.getElementsCount(); l++) {
				    		MyElement element = slot.getElement(l);
				    		observableInfo = new ObservableInfo(element, 1);
				    		slot.getObservable().setChanged();
					    	slot.getObservable().notifyObservers(observableInfo);
				    	}*/
			    	}
		    	}
		    }
		}
		
	}
	
	private ArrayList<File> get_workspaces(File folder){
		ArrayList<File> workspaces = new ArrayList<File>();
		for (File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory()){
	        	if(fileEntry.getName().matches("\\w+[.]gws$"))
	        		workspaces.add(fileEntry);
	        }
	    }
		return workspaces;
	}
	private String select_ws_combobox(ArrayList<File> workspaces){
		String[] ws_names = new String[ workspaces.size()+1 ];
		for(int w=0; w<workspaces.size(); w++){
			ws_names[w] = workspaces.get(w).getName();
		}
		String nwsl = MyMainFrame.getInstance().getResourceBundle().getString("newWS_label");
		String nwsTxt = MyMainFrame.getInstance().getResourceBundle().getString("newWS_text");
		ws_names[ws_names.length-1] = nwsl;
		String selected_ws = (String) JOptionPane.showInputDialog(
	    	null, nwsTxt+":", "Input", 
	    	JOptionPane.QUESTION_MESSAGE,
	    	null, ws_names, ws_names[0]
	    );
		return selected_ws;
	}
	
	private MyWorkspace create_new_ws(File folder){
		this.workspace = new MyWorkspace("workspace");
		this.workspace.setWs_folder(folder);
		this.workspaceTree = new MyWorkspaceTree(this.workspace);
		return this.workspace;
	}
	
	private MyWorkspace work_with_this( File selected_ws_file ){
		try {
			ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream( selected_ws_file )
			);
			this.workspace = null;
			this.workspace = (MyWorkspace) ois.readObject();
			ois.close();
			this.workspaceTree = new MyWorkspaceTree(this.workspace);
			return this.workspace;
		}
		catch (Exception e){ e.printStackTrace(); }
		return null; // temp solution
	}
	
	private MyWorkspace init_WorkspaceTree() {
		File folder;
		try {
			folder = new File(
				new File(".").getCanonicalPath()+"/workspaces"
			);
			if(folder.listFiles().length == 0){
				return create_new_ws(folder);
			}
			else{
				ArrayList<File> workspaces = get_workspaces(folder);
				String selected_ws = select_ws_combobox(workspaces);
				if(selected_ws == null){
					this.dispose();
					System.exit(DISPOSE_ON_CLOSE);
					return null;
				}
				else if(selected_ws.equals( MyMainFrame.getInstance().getResourceBundle().getString("newWS_label") )){
					return create_new_ws(folder);
				}
				else{
					// work with selected workspace:
					int selected_ws_idx = 0;
					while (selected_ws_idx < workspaces.size()){
						if (workspaces.get(selected_ws_idx).getName()
						.equals(selected_ws)) break; else selected_ws_idx++;
					}
					File selected_ws_file = workspaces.get(selected_ws_idx);
					return work_with_this( selected_ws_file );
				}
			}
		} catch (IOException e){ e.printStackTrace(); }
		return null;
	}

	public static MyMainFrame getInstance() {
		if (instance == null) {
			instance = new MyMainFrame();
			instance.init_();
		}
		return instance;
	}
	
	public int gen_idx(ArrayList<Integer> free_indexes, ArrayList<MyProject> projects) {
		if(free_indexes.size() == 1){
			int min_idx_val = free_indexes.get(0);
			free_indexes.remove(0);
			return min_idx_val;
		}
		else if(free_indexes.size() >= 2){
			int min_idx = free_indexes.indexOf(
				Collections.min(free_indexes)
			);
			int min_idx_val = free_indexes.get(min_idx);
			free_indexes.remove(min_idx);
			return min_idx_val;
		}
		else return projects.size() + 1;
	}

	public MyWorkspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(MyWorkspace workspace) {
		this.workspace = workspace;
	}

	public void setWorkspaceTree(MyWorkspaceTree workspaceTree) {
		this.workspaceTree = workspaceTree;
	}

	public MyActionManager getActionManager() {
		return actionManager;
	}

	public MyWorkspaceTree getWorkspaceTree() {
		return workspaceTree;
	}

	public MyWorkspaceView getDesktop() {
		return desktop;
	}

	public MyStatusBar getStatusBar() {
		return statusBar;
	}

	public void setStatusBar(MyStatusBar statusBar) {
		this.statusBar = statusBar;
	}
	
	public Clipboard getClipboard() {
		return clipboard;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		System.out.println("lostOwnership");
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public void changeLanguage() {
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	    setTitle(resourceBundle.getString("appTitle"));
		menu.initComponents();
		toolbar.initComponents();
		statusBar.initComponents();
	}
}
