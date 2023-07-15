package graph;

import graph.ListGraph;
import java.util.*;

public class DFS {

	public static void dfs(ArrayList<ArrayList<Integer>> graph,int visit[],int vertex) {
		visit[vertex] = 1;
		System.out.print("V"+vertex+" ");
		ArrayList<Integer> node = graph.get(vertex);
		for(int i=0;i<node.size();i++) {
			if(visit[node.get(i)] == 0) {
				dfs(graph,visit,node.get(i));
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
		dfs(graph,visited,1);
	}

}
