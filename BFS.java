package graph;

import java.util.*;
import graph.ListGraph;

public class BFS {

	public static void bfs(ArrayList<ArrayList<Integer>> graph,int visit[],int startVertex) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		visit[startVertex] = 1;
		queue.add(startVertex);
		System.out.print("V"+startVertex+" ");
		while(!queue.isEmpty()) {
			
			int vertex = queue.remove();
			ArrayList<Integer> node = graph.get(vertex);
			for(int i=0;i<node.size();i++) {
				if(visit[node.get(i)] == 0) {
					queue.add(node.get(i));
					System.out.print("V"+node.get(i)+" ");
					visit[node.get(i)] = 1;
				}
			}
		}
	
	}
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		ListGraph tool = new ListGraph();
		
		int vertex = 8;
		for(int i=0;i<=8;i++) {
			graph.add(new ArrayList<Integer>());
		}
		int visited[] = new int[vertex+1];
		for(int i=1;i<visited.length;i++) {
			visited[i] = 0;
		}
		
		tool.notArrowPutEdge(graph, 1, 2);
		tool.notArrowPutEdge(graph, 1, 3);
		tool.notArrowPutEdge(graph, 2, 4);
		tool.notArrowPutEdge(graph, 2, 5);
		tool.notArrowPutEdge(graph, 3, 6);
		tool.notArrowPutEdge(graph, 3, 7);
		tool.notArrowPutEdge(graph, 4, 8);
		tool.notArrowPutEdge(graph, 5, 8);
		tool.notArrowPutEdge(graph, 6, 8);
		tool.notArrowPutEdge(graph, 7, 8);
		tool.printGraph(graph);
		bfs(graph,visited,3);
	}

}
