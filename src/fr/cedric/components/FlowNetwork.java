package fr.cedric.components;

import java.util.ArrayList;

public class FlowNetwork {
	
	private Graph g;
	private int maxFlow;
	private ArrayList<Edge> cut;
	private int rGraph[][];
	
	public FlowNetwork(Graph g, int maxFlow, ArrayList<Edge> c, int rG[][]){
		this.g = g;
		this.maxFlow =  maxFlow;
		this.cut = c;
		this.rGraph = rG;
	}
	public void printAll(){
		System.out.println("MaxFlow : " + maxFlow);
		System.out.println("EDGES CUT : ");
		for(Edge e : cut){
			System.out.println(e.getStart() + " - " + e.getArrival());
		}
				
	}
	public boolean isCut(int eID){
		boolean b = false;
		for(Edge e : cut){
			if(e.getEdgeID() == eID){
				b = true;
			}
		}
		return b;
	}
	public int resValue(int s, int t){
		return rGraph[t][s];
	}
	public int getFlow(){
		return maxFlow;
	}

}
