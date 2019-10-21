package com.jv.OopsDesign.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jv.OopsDesign.observer.Exception.InvalidPathException;

/**
 * This class represents our file system
 * It is nothing but n-array tree.
 * @author jeevi.natarajan
 *
 */
public class FileSystem {
	
//	private static final Logger log = LoggerFactory.getLogger(FileSystem.class);
	
	private Node root;
	
	public FileSystem() {
		root = new Node("/",NodeType.FOLDER);  //Everything we create is children of this root.
	}
	
	public void pwd() { //My magical pwd print all paths 
		List<String> path = new ArrayList<>();
		pwdUtil(root, path, 0);
	}
	
	private void pwdUtil(Node root , List<String> path , int index) { //Print root to leaf path.
		
		if(root!=null) {
			
			if(root.getChildren()==null) {  //TODO Printing the result here may not be a good coding practice.. consider returning it.  
				path.add(index,root.getData());
				//Print the path
				String finalPath = path.stream().collect(Collectors.joining("/"));
				System.out.println(finalPath.substring(1));//Root has to been taken care..  
				path.remove(index);
			}
			else {
				path.add(index,root.getData()); 
				
				if(root.getChildren()!=null) {
					root.getChildren().forEach(child->{
						pwdUtil(child, path, index+1);
					});
				}
				
				path.remove(index);
			}
			
		}
	}
	
	
	public void vi(String path) {
		//So the expectations are 1. Always absolute path is given. 2. we are supposed to create only the last directory.
		//example : /opt/deploy
		
		path = path.substring(1);
		
		String [] folders = path.split("/");
		
		addNode(root, folders, 0,NodeType.FILE);
		
		
	}
	
	public void mkdir(String path) {
		//So the expectations are 1. Always absolute path is given. 2. we are supposed to create only the last directory.
		//example : /opt/deploy
		
		path = path.substring(1);
		
		String [] folders = path.split("/");
		
		addNode(root, folders, 0,NodeType.FOLDER);
		
		
	}

	private void addNode(Node root , String [] folders,int index , NodeType fileType) { //Except the last one.. others exists...
		
		if(index==folders.length-1) {
			//add it to the root
			Node node = new Node(folders[index],fileType);
			root.addChild(node);
		}
		else {// traverse along the path..
			if(root.getChildren()!=null) {
				
				List<Node> matches = root.getChildren().stream().filter(child-> child.getData().equals(folders[index])).collect(Collectors.toList());//Expected to return only one value.
				
				if(matches.size()<=0) {
					throw new InvalidPathException("Invalid Path!! Folder " + folders[index] + "does not exists!");
				}
				
			  addNode(matches.get(0), folders, index+1 , fileType);
			 
			}
			
		}
		
		
		
	}
}
