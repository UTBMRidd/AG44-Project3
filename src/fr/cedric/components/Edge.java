package fr.cedric.components;

public class Edge {
	
	private int edgeID;
	private String name;
	private int start;
	private int arrival;
	private int flow;
	
	public Edge(int id,String name,int start,int arrival, int flow){
		this.setEdgeID(id);
		this.setName(name);
		this.setStart(start);
		this.setArrival(arrival);
		this.setFlow(flow);
	}

	public int getEdgeID() {
		return edgeID;
	}

	public void setEdgeID(int edgeID) {
		this.edgeID = edgeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getArrival() {
		return arrival;
	}

	public void setArrival(int arrival) {
		this.arrival = arrival;
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}


}
