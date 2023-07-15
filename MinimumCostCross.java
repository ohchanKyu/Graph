package graph;

import java.util.*;

class Edge
{
	int vertex1;
	int vertex2;
	int cost;
	public Edge() {
		
	}
	public Edge(int x,int y){
		vertex1 = x;
		vertex2 = y;
	}
	public Edge(int x,int y,int cost) {
		vertex1 = x;
		vertex2 = y;
		this.cost = cost;
	}
}

public class MinimumCostCross {

	public static void crossAlgorithm(ArrayList<ArrayList<Integer>> graph,HashMap<Edge,Integer> map,ArrayList<ArrayList<Integer>> spanningTree,ListGraph tool) {
		
		LinkedList<Integer> vertex = new LinkedList<>();
		
		int totalCost = 0;
		int min = 0;
		Edge minEdge = new Edge();
		boolean check1 = false;
		boolean check2 = false;
		while(vertex.size()<= graph.size()-2) {
			
			check1 = false;
			check2 = false;
			Set<Edge> set = map.keySet();
			Iterator<Edge> it = set.iterator();
			min = 0;
			while(it.hasNext()) {
				Edge newEdge = it.next();
				int cost = map.get(newEdge);
				if(min==0) {
					minEdge = newEdge;
					min = cost;
				}else if(min != 0 && cost < min) {
					minEdge = newEdge;
					min = cost;
				}
			}
			map.remove(minEdge);
			if(!vertex.contains(minEdge.vertex1)) {
				vertex.add(minEdge.vertex1);
				check1 = true;
			}
			if(!vertex.contains(minEdge.vertex2)) {
				vertex.add(minEdge.vertex2);
				check2 = true;
			}
			if(check1 == true || check2 == true) {
				tool.notArrowPutEdge(spanningTree, minEdge.vertex1, minEdge.vertex2);
				totalCost += min;
			}
		}
		System.out.println("TotalCost : "+totalCost);
	}
	
	public static void main(String[] args) {
		
		HashMap<Edge,Integer> map = new HashMap<>();
		map.put(new Edge(1,2),16); 
		map.put(new Edge(2,3),5);  
		map.put(new Edge(1,6),21); 
		map.put(new Edge(2,6),11); 
		map.put(new Edge(1,5),19); 
		map.put(new Edge(5,6),33); 
		map.put(new Edge(4,5),18); 
		map.put(new Edge(4,6),14); 
		map.put(new Edge(2,4),6);  
		map.put(new Edge(3,4),10); 
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		ArrayList<ArrayList<Integer>> spanningTree = new ArrayList<>();
		ListGraph tool = new ListGraph();
		
		int vertex = 6;
		for(int i=0;i<=vertex;i++) {
			graph.add(new ArrayList<Integer>());
			spanningTree.add(new ArrayList<Integer>());
		}
		
		tool.notArrowPutEdge(graph, 1, 2);
		tool.notArrowPutEdge(graph, 1, 5);
		tool.notArrowPutEdge(graph, 1, 6);
		tool.notArrowPutEdge(graph, 2, 3);
		tool.notArrowPutEdge(graph, 2, 4);
		tool.notArrowPutEdge(graph, 2, 6);
		tool.notArrowPutEdge(graph, 3, 4);
		tool.notArrowPutEdge(graph, 4, 5);
		tool.notArrowPutEdge(graph, 4, 6);
		tool.notArrowPutEdge(graph, 5, 6);
		tool.printGraph(graph);
		crossAlgorithm(graph,map,spanningTree,tool);
		tool.printGraph(spanningTree);
	}

}
