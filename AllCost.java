package graph;

import graph.ArrayGraph;


public class AllCost {

	public static void main(String[] args) {
		
		int vertex = 3;
		int cost[][] = {
				{-1,-1,-1,-1},
				{-1,0,4,11},
				{-1,6,0,2},
				{-1,3,-1,0}
		};
		int allCostArray[][] = new int[vertex+1][vertex+1];
		for(int i=1;i<allCostArray.length;i++) {
			for(int j=1;j<allCostArray[i].length;j++) {
				allCostArray[i][j] = cost[i][j];
			}
		}
		for(int k=1;k<vertex+1;k++) {
			for(int i=1;i<vertex+1;i++) {
				for(int j=1;j<vertex+1;j++) {
					if(allCostArray[i][j] != -1) {
						if(allCostArray[i][k] != -1 && allCostArray[k][j]!=-1) {
							int newPath = allCostArray[i][k]+allCostArray[k][j];
							allCostArray[i][j] = allCostArray[i][j] < newPath ? allCostArray[i][j] : newPath;
						}
						
					}else if(allCostArray[i][j] == -1) {
						if(allCostArray[i][k] != -1 && allCostArray[k][j]!=-1) {
							allCostArray[i][j] = allCostArray[i][k]+allCostArray[k][j];
						}
					}
				}
			}
		}
		System.out.println("AllCost");
		for(int i=1;i<cost.length;i++) {
			for(int j=1;j<cost[i].length;j++) {
				System.out.println(i+"->"+j+" "+allCostArray[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
