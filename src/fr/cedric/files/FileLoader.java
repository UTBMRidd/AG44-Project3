package fr.cedric.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import fr.cedric.components.Graph;
import fr.cedric.components.NodeType;

public class FileLoader {
	
    public static Graph getGraph(String path){

    	Graph g = new Graph();
        String csvFile = "res/" + path + ".csv";
        String line = "";
        String cvsSplitBy = ",";
        int nbCat = -1;
        int nbL[] = new int[3];
        ArrayList<String[]> allLines = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] lineContent = line.split(cvsSplitBy);
                if(lineContent[0].charAt(0) == '['){
                	nbCat++;
                }else{
                	nbL[nbCat]++;
                	allLines.add(lineContent);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        int nodeNb = 0;
        int lineC=0;
        g.addNode(nodeNb, "Start", NodeType.START);
        for(int i=0;i<2;i++){
        	for(int j=0;j<nbL[i];j++){
        		switch(i){
        			case 0:
        				g.addNode(Integer.parseInt(allLines.get(lineC)[0]), "", NodeType.SOURCE);
        				break;
        			case 1:
        				g.addNode(Integer.parseInt(allLines.get(lineC)[0]), "", NodeType.CITY);
        				break;
        		}
        		lineC++;
        	}
        }
        int start = Integer.parseInt(allLines.get(nbL[0] - 1)[0]) + 1;
        int end = Integer.parseInt(allLines.get(nbL[0])[0]);
        while(start<end){
        	g.addNode(start, "", NodeType.PIPE);
        	start++;
        }
        g.addNode(Integer.parseInt(allLines.get(nbL[0]+nbL[1] -1)[0]) + 1, "End", NodeType.END);
        
        int matT = Integer.parseInt(allLines.get(nbL[0] + nbL[1] - 1)[0]);
        int matS = nbL[0] + nbL[1];
        int eID =0;
        for(int i=0;i<matT;i++){
        	for(int j=0;j<matT;j++){
        		int val = Integer.parseInt(allLines.get(matS+i)[j]);
        		if(val > 0){
            		g.addEdge(eID, "", i+1, j+1, val);
            		eID++;
        		}
        	}
        }
        for(int i=0;i<nbL[0];i++){
        	g.addEdge(eID, "", 0, (Integer.parseInt(allLines.get(i)[0])), (Integer.parseInt(allLines.get(i)[1])));
        	eID++;
        }
        for(int i=0;i<nbL[1];i++){
        	g.addEdge(eID, "", (Integer.parseInt(allLines.get(nbL[0]+i)[0])), Integer.parseInt(allLines.get(nbL[0]+nbL[1] -1)[0]) + 1, (Integer.parseInt(allLines.get(nbL[0]+i)[1])));
        	eID++;
        }
        
        
        
        
        
        
        return g;
        
    }

}
