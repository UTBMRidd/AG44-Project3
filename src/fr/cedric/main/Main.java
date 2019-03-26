package fr.cedric.main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.cedric.GUI.Frame;
import fr.cedric.components.FlowNetwork;
import fr.cedric.components.Graph;
import fr.cedric.files.FileLoader;
import fr.cedric.tools.MaxFlow;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Select input file");
		String name = JOptionPane.showInputDialog(frame, "Enter file name");
		Graph t = FileLoader.getGraph(name);
		t.printNodes();
		t.printEdges();
		FlowNetwork fn = MaxFlow.fordFulkerson(t, 0, t.getNumberOfNodes()-1);
		Frame f = new Frame(t,fn);
		fn.printAll();
		
	}

}
