package fr.cedric.components;

import java.util.ArrayList;

public class Node {

	private int nodeID;
	private String name;
	private ArrayList<Edge> successors = new ArrayList <Edge>();
	private NodeType type;
	
	public Node(int id, String name, NodeType type){
		this.nodeID = id;
		this.name = name;
		this.type = type;
	}
	
	
	public ArrayList<Edge> getSuccessors(){
		
		return this.successors;
	}
	public void addSuccessors(Edge succ){
		
		this.successors.add(succ);
	}

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public NodeType getType() {
		return type;
	}

}
