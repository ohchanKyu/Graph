package graph;

import java.util.*;
import graph.ListGraph;
import graph.Edge;

public class AOENetwork {

	public static void AOE(ArrayList<ArrayList<Integer>> graph,Edge edge[],int ee[],int le[],
			ArrayList<ArrayList<Integer>> newGraph,ListGraph tool) {
		
		ee[1] = 0;
		Edge copyEdge[] = new Edge[edge.length];
		for(int i=0;i<copyEdge.length;i++) {
			
			copyEdge[i] = new Edge(edge[i].vertex1,edge[i].vertex2,edge[i].cost);
		}
		for(int i=1;i<=graph.size()-1;i++) {
			ArrayList<Integer> node = graph.get(i);
			for(int j=0;j<node.size();j++) {
				for(int k=0;k<edge.length;k++) {
					int from = edge[k].vertex1;
					int to = edge[k].vertex2;
					int cost = edge[k].cost;
					if(i==from && node.get(j)==to) {
						if(ee[node.get(j)] < cost) {
							ee[node.get(j)] = ee[i]+cost;
						}
					}
				}
			}
		}
		System.out.print("Earliest Event Occurrence time : ");
		for(int i=1;i<ee.length;i++) {
			System.out.print("V"+i+":"+ee[i]+" ");
		}
		le[ee.length-1] = ee[ee.length-1];
		for(int i=graph.size()-1;i>=1;i--) {
			ArrayList<Integer> node = graph.get(i);
			for(int j=0;j<node.size();j++) {
				for(int k=0;k<edge.length;k++) {
					int from = edge[k].vertex2;
					int to = edge[k].vertex1;
					int cost = edge[k].cost;
					if(i==to && node.get(j)==from) {
						if(le[i] != -1) {
							int newPath = le[node.get(j)]-cost;
							if(le[i] > newPath) {
								le[i] = newPath;
							}
						}else {
							le[i] = le[node.get(j)]-cost;
						}
					}
				}
			}
		}
		System.out.println();
		System.out.print("Latest Event Occurrence time : ");
		for(int i=1;i<le.length;i++) {
			System.out.print("V"+i+":"+le[i]+" ");
		}
		
		for(int i=1;i<ee.length;i++) {
			for(int j=0;j<edge.length;j++) {
				int adjustEdge = edge[j].vertex1;
				if(adjustEdge == i) {
					edge[j].cost = ee[i];
				}
			}
		}
		
		System.out.println();
		System.out.println("Earliest Start time");
		for(int i=0;i<edge.length;i++) {
			System.out.println("V"+edge[i].vertex1+"->"+"V"+edge[i].vertex2+" : "+edge[i].cost);
		}
		
		for(int i=le.length-1;i>=1;i--) {
			for(int j=0;j<copyEdge.length;j++) {
				int adjustEdge = copyEdge[j].vertex2;
				if(adjustEdge == i) {
					copyEdge[j].cost = le[i]-copyEdge[j].cost;
				}
			}
		}
		System.out.println();
		System.out.println("Latest time");
		for(int i=0;i<copyEdge.length;i++) {
			System.out.println("V"+copyEdge[i].vertex1+"->"+"V"+copyEdge[i].vertex2+" : "+copyEdge[i].cost);
		}
		
		System.out.print("Critical Path : ");
		for(int i=0;i<edge.length;i++) {
			
			int cost = edge[i].cost-copyEdge[i].cost;
			if(cost == 0) {
				System.out.print("V"+edge[i].vertex1+"->"+"V"+edge[i].vertex2+" ");
				tool.arrowPutEdge(newGraph,edge[i].vertex1,edge[i].vertex2);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int vertex = 9;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		ArrayList<ArrayList<Integer>> criticalPath = new ArrayList<>();
		
		ListGraph tool = new ListGraph();
		
		int earliestEvent[] = new int[vertex+1];
		int latestEvent[] = new int[vertex+1];
		for(int i=0;i<latestEvent.length;i++) {
			latestEvent[i] = -1;
		}
		
		for(int i=0;i<=vertex;i++) {
			graph.add(new ArrayList<Integer>());
			criticalPath.add(new ArrayList<Integer>());
		}
		tool.arrowPutEdge(graph,1,2);
		tool.arrowPutEdge(graph,1,3);
		tool.arrowPutEdge(graph,1,4);
		tool.arrowPutEdge(graph,2,5);
		tool.arrowPutEdge(graph,3,5);
		tool.arrowPutEdge(graph,4,6);
		tool.arrowPutEdge(graph,5,7);
		tool.arrowPutEdge(graph,5,8);
		tool.arrowPutEdge(graph,6,8);
		tool.arrowPutEdge(graph,7,9);
		tool.arrowPutEdge(graph,8,9);
		tool.printGraph(graph);
		
		Edge edge[] = new Edge[11];
		edge[0] = new Edge(1,2,6);
		edge[1] = new Edge(1,3,4);
		edge[2] = new Edge(1,4,5);
		edge[3] = new Edge(2,5,1);
		edge[4] = new Edge(3,5,1);
		edge[5] = new Edge(4,6,2);
		edge[6] = new Edge(5,7,9);
		edge[7] = new Edge(5,8,7);
		edge[8] = new Edge(7,9,2);
		edge[9] = new Edge(8,9,4);
		edge[10] = new Edge(6,8,4);
		AOE(graph,edge,earliestEvent,latestEvent,criticalPath,tool);
		tool.printGraph(criticalPath);
		
	}

}
