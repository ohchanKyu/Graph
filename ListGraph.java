package graph;

import java.util.*;

public class ListGraph {
	
	public void arrowPutEdge(ArrayList<ArrayList<Integer>> graph, int fromVertex,int toVertex) {
		
		graph.get(fromVertex).add(toVertex);
	}
	
	public void notArrowPutEdge(ArrayList<ArrayList<Integer>> graph, int vertex1,int vertex2) {
		if(!graph.get(vertex1).contains(vertex2)) {
			graph.get(vertex1).add(vertex2);
		}
		if(!graph.get(vertex2).contains(vertex1)) {
			graph.get(vertex2).add(vertex1);
		}
	}
	
	public void predecessorCount(ArrayList<ArrayList<Integer>> graph) {
		
		for(int i=1;i<graph.size();i++) {
			ArrayList<Integer> node = graph.get(i);
			for(int j=1;j<node.size();j++) {
				int predecessor = node.get(j);
				int count = graph.get(predecessor).get(0);
				graph.get(predecessor).set(0,count+1);
			}
		}
	}
	
	public void printGraph(ArrayList<ArrayList<Integer>> graph) {
		
		for(int i=1;i<graph.size();i++) {
			ArrayList<Integer> vertex = graph.get(i);
			System.out.print("Vertex["+i+"] : ");
			for(int j=0;j<vertex.size()-1;j++) {
				System.out.print(vertex.get(j)+"->");
			}
			if(vertex.size()!=0) {
				System.out.print(vertex.get(vertex.size()-1));
			}
			System.out.println();
		}
		
	}
}
