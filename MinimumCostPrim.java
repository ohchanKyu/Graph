package graph;

import java.util.*;

import graph.MinimumCostCross;

public class MinimumCostPrim {
	
	public static void primAlgorithm(ArrayList<ArrayList<Integer>> graph,HashMap<Edge,Integer> map,
			ArrayList<ArrayList<Integer>> spanningTree,ListGraph tool,int startVertex) {
		
		LinkedList<Integer> vertex = new LinkedList<>();
		vertex.add(startVertex);
		int edgeCount = 0;
		int totalCost = 0;
		int min = 0;
		int vertex1 = 0;
		int vertex2 = 0;
		Edge minEdge = new Edge();

		while(edgeCount != graph.size()-2) {
			
			min = 0;
			for(int j=0;j<vertex.size();j++) {

				ArrayList<Integer> node = graph.get(vertex.get(j));
				for(int i=0;i<node.size();i++) {
					Set<Edge> set = map.keySet();
					Iterator<Edge> it = set.iterator();
					if(!vertex.contains(node.get(i))) {
						while(it.hasNext()) {
							Edge newEdge = it.next();
							vertex1 = newEdge.vertex1;
							vertex2 = newEdge.vertex2;
							if(vertex1 == vertex.get(j) && vertex2 == node.get(i)) {
								int cost = map.get(newEdge);
								if(min==0) {
									minEdge = newEdge;
									min = cost;
								}else if(min != 0 && cost < min) {
									minEdge = newEdge;
									min = cost;
								}
								
							}else if(vertex2 == vertex.get(j) && vertex1 == node.get(i)) {
								int cost = map.get(newEdge);
								if(min==0) {
									minEdge = newEdge;
									min = cost;
								}else if(min != 0 && cost < min) {
									minEdge = newEdge;
									min = cost;
								}
							}
						}
					}
				}
			}

			map.remove(minEdge);
			if(!vertex.contains(minEdge.vertex1)) {
				vertex.add(minEdge.vertex1);
			}
			if(!vertex.contains(minEdge.vertex2)) {
				vertex.add(minEdge.vertex2);
			}
			
			tool.notArrowPutEdge(spanningTree, minEdge.vertex1, minEdge.vertex2);
			totalCost += min;
			edgeCount++;
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
		primAlgorithm(graph,map,spanningTree,tool,5);
		tool.printGraph(spanningTree);
	}

}
