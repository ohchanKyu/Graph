package graph;

public class ArrayGraph {

	public void arrowPutEdge(int graph[][],int frowVertex,int toVertex) {
		graph[frowVertex][toVertex] = 1;
	}
	public void notArrowPutEdge(int graph[][],int vertex1,int vertex2) {
		graph[vertex1][vertex2] = 1;
		graph[vertex2][vertex1] = 1;
	}
	public void printGraph(int graph[][]) {
		
		for(int i=1;i<graph.length;i++) {
			System.out.print("Vertex["+i+"] : ");
			for(int j=1;j<graph[i].length;j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
}
