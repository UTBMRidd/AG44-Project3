package fr.cedric.GUI;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import fr.cedric.components.FlowNetwork;
import fr.cedric.components.Graph;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = -8123406571694511514L;
	
	public Frame(Graph g,FlowNetwork fn){
		super("Maxflow problem : " + fn.getFlow());
		setSize(1500,920);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawGraph dg = new DrawGraph(g,fn);
		add(dg);
        setVisible(true);

	}

}
