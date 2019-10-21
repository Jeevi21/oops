package com.jv.OopsDesign.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This represents a node in a tree.
 * @author jeevi.natarajan
 *
 */
public class Node {

	private String data; //Nothing but node name.
	private List<Node> children;
	private List<Iwatch> watchers;
	private NodeType nodeType;
	
	public Node(String data , NodeType nodeType) {
		this.data = data;
		this.nodeType = nodeType;
	}
	
	public void addChild(Node child) {
		if(this.children==null) {
			this.children=new ArrayList<Node>();
		}
		
		this.children.add(child);
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	public List<Iwatch> getWatchers() {
		return watchers;
	}
	public void setWatchers(List<Iwatch> watchers) {
		this.watchers = watchers;
	}
	public NodeType getNodeType() {
		return nodeType;
	}
	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}
	
	
	
}
