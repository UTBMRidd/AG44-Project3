package fr.cedric.GUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.mxgraph.layout.mxParallelEdgeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import fr.cedric.components.Edge;
import fr.cedric.components.FlowNetwork;
import fr.cedric.components.Graph;
import fr.cedric.components.Node;
import fr.cedric.components.NodeType;

public class DrawGraph extends JPanel{
	
	private Graph graph;
	private FlowNetwork fn;
	private mxGraphComponent graphC;
    private double[][] coord = {
    		{50, 450},//1
    		
    		{250, 50},//2
    		{250, 300},//3
    		{250, 550},//4
    		{250,750},//5
    		
    		{500,150},//6
    		{500, 400},//7
    		{500, 650},//8
    		
    		{750, 300},//9
    		{750, 550},//10
    		
    		{950, 150},//11
    		{950,400},//12
    		{950,650},//13
    		
    		{1150,450},//14
    		
    		
    		{1150,600},
    		{1150,600},
    		{1150,600},
    		{1150,600},
    		{1150,600},
    		{1150,600},
    		{1150,600},
    		{1150,600},
    		{1150,600},
    		{1150,600},
    		{1150,600},
    };
	
	public DrawGraph(Graph g, FlowNetwork fn){
		this.graph = g;
		this.fn = fn;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(1200, 920);
        this.setBackground(Color.BLUE);
        this.setVisible(true);
        this.initGraph(drawGraph());

	}
	public void initGraph(mxGraph graph){
		//ImageIcon image = new ImageIcon("res/wallpaper.jpg");
		mxParallelEdgeLayout layout = new mxParallelEdgeLayout(graph);
		layout.execute(graph.getDefaultParent());
		graphC = new mxGraphComponent(graph);
		//graphComponent.setBackgroundImage(image);
		removeAll();
        add(graphC);
		
	}
	public mxGraph drawGraph(){
		mxGraph mgraph = new mxGraph();
		
	    Object parent = mgraph.getDefaultParent();
	    ArrayList<Object> vertices = new ArrayList<Object>();
	    
	    double h = 30;
	    double l = 80;

	    mgraph.getModel().beginUpdate();
	    try {
	      for(int i =0;i<graph.getNumberOfNodes();i++){
	    	  Node n = graph.getNode(i);
	    	  switch(n.getType().getId()){
	    	  	case 0 :
	    	  		vertices.add(mgraph.insertVertex(parent, null, n.getNodeID(), coord[i][0] - l/2, coord[i][1] - h/2, l, h, mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_HEXAGON+";fillColor=#41AF41"));
	    	  		break;
	    	  	case 1:
	    	  		vertices.add(mgraph.insertVertex(parent, null, n.getNodeID(), coord[i][0] - l/2, coord[i][1] - h/2, l, h, mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_HEXAGON+";fillColor=#2CB9CE"));
	    	  		break;
	    	  	case 2 :
	    	  		vertices.add(mgraph.insertVertex(parent, null, n.getNodeID(), coord[i][0] - l/2, coord[i][1] - h/2, l, h, mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_HEXAGON+";fillColor=#AD6FEA"));
	    	  		break;
	    	  	case 3 :
	    	  		vertices.add(mgraph.insertVertex(parent, null, "Start", coord[i][0] - l/2, coord[i][1] - h/2, l, h, mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_HEXAGON+";fillColor=#E6EC31"));
	    	  		break;
	    	  	case 4 :
	    	  		vertices.add(mgraph.insertVertex(parent, null, "End", coord[i][0] - l/2, coord[i][1] - h/2, l, h, mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_HEXAGON+";fillColor=#DCAC4B"));
	    	  		break;
	    	  }
	      }
	      for(int i =0;i<graph.getNumberOfEdges();i++){
	    	Edge e = graph.getEdge(i);
	    	if(fn.isCut(i)){
	    		mgraph.insertEdge(parent, null,fn.resValue(e.getStart(), e.getArrival()) + " / " + e.getFlow(), vertices.get(e.getStart()), vertices.get(e.getArrival()),mxConstants.STYLE_STROKECOLOR+"="+ "#FB2121");
	    	}
	    	else{
	    		mgraph.insertEdge(parent, null, fn.resValue(e.getStart(), e.getArrival()) + " / " + e.getFlow(), vertices.get(e.getStart()), vertices.get(e.getArrival()));
	    	}
	    	
	      }
	      
	    } finally {
	      mgraph.getModel().endUpdate();
	    }
	    
		return mgraph;
	}
	public void setGraph(Graph gr){
		this.graph = gr;
	}


}
