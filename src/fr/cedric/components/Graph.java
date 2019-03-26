package fr.cedric.components;

import java.util.HashMap;
import java.util.Map;

public class Graph {
	private HashMap<Integer,Node> nodes = new HashMap <Integer,Node>();
	private HashMap<Integer,Edge> edges = new HashMap <Integer,Edge>();
	
	
	private int nodeNb;
	private int edgeNb;
	
	public void addNode(int id, String name, NodeType t){
		nodes.put(id, new Node(id, name,t));
		this.setNumberOfNodes(this.getNumberOfNodes() + 1);
	}
	public void addNode(Node n){
		nodes.put(n.getNodeID(), n);
		this.setNumberOfNodes(this.getNumberOfNodes() + 1);
	}
	public void addEdge(int id,String name,int start,int arrival, int flow){
		Edge k = new Edge(id, name,start,arrival, flow);
		edges.put(id, k);
		nodes.get(start).addSuccessors(k);
		this.setNumberOfEdges(this.getNumberOfEdges() + 1);
	}
	public Node getNode(int index){
		return nodes.get(index);
	}
	public Edge getEdge(int index){
		return edges.get(index);
	}
	public void printNodes(){
		for(Map.Entry<Integer,Node> entry : nodes.entrySet()) {
		    int key = entry.getKey();
		    Node value = entry.getValue();
		    System.out.print("Node : " + key  + " / Nom : " + value.getName() + " / Successors : " );
		    for(Edge i : value.getSuccessors()){
		    	System.out.print(i.getArrival() + " ");
		    }
		    System.out.println("");
		}
	}
	public void printEdges(){
		for(Map.Entry<Integer,Edge> entry : edges.entrySet()) {
		    int key = entry.getKey();
		    Edge value = entry.getValue();
		    System.out.println("Edge : " + key  + " / Nom : " + value.getName() + " / Start : " + value.getStart() + " / Arrival : " + value.getArrival() + " / Flow : " + value.getFlow());
		}
	}
	//GETTER/SETTER
	
	public int getNumberOfNodes() {
		return nodeNb;
	}
	public void setNumberOfNodes(int nodeNb) {
		this.nodeNb = nodeNb;
	}
	public int getNumberOfEdges() {
		return edgeNb;
	}
	public void setNumberOfEdges(int edgeNb) {
		this.edgeNb = edgeNb;
	}
}
