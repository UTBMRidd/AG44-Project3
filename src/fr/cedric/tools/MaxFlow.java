package fr.cedric.tools;

import java.util.ArrayList;
import java.util.LinkedList;

import fr.cedric.components.Edge;
import fr.cedric.components.FlowNetwork;
import fr.cedric.components.Graph;

public class MaxFlow {

	private static boolean bfs(int rGraph[][], int s, int t, int parent[], int V)
    {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;
 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;
 
        while (queue.size()!=0)
        {
            int u = queue.poll();
 
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        
        return (visited[t] == true);
    }
	private static boolean[] getMinCut(int rGraph[][], int s, int t, int V)
    {
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        while (queue.size()!=0)
        {
            int u = queue.poll();
 
            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
        
        return visited;
    }
    public static FlowNetwork fordFulkerson(Graph g, int s, int t)
    {
        int u, v;
        int V = g.getNumberOfNodes();
        int rGraph[][] = new int[V][V];
 
        for (u = 0; u < V; u++){
            for (v = 0; v < V; v++){
                rGraph[u][v] = getFlowValue(g,u,v);
            }
        }
        int parent[] = new int[V];
 
        int max_flow = 0;
        while (bfs(rGraph, s, t, parent,V))
        {
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
            max_flow += path_flow;
        }
        ArrayList<Edge> cut = new ArrayList<Edge>();
        boolean[] stat = getMinCut(rGraph, s, t,V);
        for(int i=0;i<V;i++){
        	System.out.println(stat[i]);
        	for(Edge e : g.getNode(i).getSuccessors()){
        		if((!stat[e.getArrival()] && stat[i])){
        			cut.add(e);
  
        		}
        	}
        }
        
        FlowNetwork fn = new FlowNetwork(g,max_flow,cut, rGraph);
        return fn;
    }
    private static int getFlowValue(Graph g,int s, int t){
    	int flow = 0;
    	for(Edge ed : g.getNode(s).getSuccessors()){
    		if(ed.getArrival() == t){
    			flow = ed.getFlow();
    		}
    	}
    	return flow;
    }
	

}
