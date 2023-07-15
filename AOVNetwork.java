package graph;

import graph.ListGraph;
import java.util.*;

public class AOVNetwork {

	public static void AOV(ArrayList<ArrayList<Integer>> graph) {
		
		Stack<Integer> stack = new Stack<>();
		for(int i=1;i<=graph.size();i++) {
			if(graph.get(i).get(0) == 0) {
				stack.push(i);
				break;
			}
		}
		System.out.print("Cycle : ");
		int totalCount = 0;
		for(int i=1;i<=graph.size();i++) {
			
			totalCount++;
			if(stack.isEmpty()) {
				System.out.print(" End");
				break;
			}
			int vertex = stack.pop();
			if(totalCount == graph.size()-1) {
				System.out.print("V"+vertex);
			}else {
				System.out.print("V"+vertex+"->");
			}
			
			ArrayList<Integer> node = graph.get(vertex);
			for(int j=1;j<node.size();j++) {
				int nodeVertex = node.get(j);
				int count = graph.get(nodeVertex).get(0)-1;
				graph.get(nodeVertex).set(0,count);
				if(count == 0) {
					stack.push(nodeVertex);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int vertex = 6;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		ListGraph tool = new ListGraph();
		
		for(int i=0;i<=vertex;i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=1;i<=vertex;i++) {
			graph.get(i).add(0); //predecessor count
		}
		
		tool.arrowPutEdge(graph,1,2);
		tool.arrowPutEdge(graph,1,3);
		tool.arrowPutEdge(graph,1,4);
		tool.arrowPutEdge(graph,2,5);
		tool.arrowPutEdge(graph,3,5);
		tool.arrowPutEdge(graph,3,6);
		tool.arrowPutEdge(graph,4,5);
		tool.arrowPutEdge(graph,4,6);
		tool.predecessorCount(graph);
		tool.printGraph(graph);
		AOV(graph);
		
	}

}
