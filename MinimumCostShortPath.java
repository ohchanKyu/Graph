package graph;

import java.util.*;
import graph.ListGraph;

public class MinimumCostShortPath {

	public static void shortPath(int startVertex,int checkArray[],int dist[],int cost[][]) {
		
		for(int i=1;i<checkArray.length;i++) {
			dist[i] = cost[startVertex][i];
		}
		checkArray[startVertex] = 1;
		
		int num = 2;
		int min = 0;
		int updateNumber = 0;
		
		while(num < checkArray.length-1) {
			
			min = 0;
			for(int i=1;i<dist.length;i++) {
				
				if(checkArray[i]!=1) {
					if(dist[i] != -1 && min == 0) {
						min = dist[i];
						updateNumber = i;
					}else if(dist[i] != -1 && min > dist[i]) {
						min = dist[i];
						updateNumber = i;
					}
					
				}
			}
			checkArray[updateNumber] = 1;
			num++;
			for(int i=1;i<checkArray.length;i++) {
				if(checkArray[i]!=1) {
					if(cost[updateNumber][i] != -1) {
						if(dist[i] != -1) {
							int updatePath = min+cost[updateNumber][i];
							dist[i] = dist[i] < updatePath ? dist[i]:updatePath;
						}else if(dist[i] == -1){
							dist[i] = min+cost[updateNumber][i];
						}
					}
				}
			}
		}
		System.out.println(startVertex+"에서 출발하는 최단 경로");
		for(int i=1;i<dist.length;i++) {
			
			System.out.println(startVertex+"->"+i+" : "+dist[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		
		int vertex = 8;
		
		int cost[][] = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,0,-1,-1,-1,-1,-1,-1,-1},
				{-1,300,0,-1,-1,-1,-1,-1,-1},
				{-1,1000,800,0,-1,-1,-1,-1,-1},
				{-1,-1,-1,1200,0,-1,-1,-1,-1},
				{-1,-1,-1,-1,1500,0,250,-1,-1},
				{-1,-1,-1,-1,1000,-1,0,900,1400},
				{-1,-1,-1,-1,-1,-1,-1,0,1000},
				{-1,1700,-1,-1,-1,-1,-1,-1,0}	
		};
		
		int checkArray[] = new int[vertex+1];
		int dist[] = new int[vertex+1];
		for(int i=1;i<checkArray.length;i++) {
			checkArray[i] = 0;
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("거리를 찾고싶은 시작 정점을 입력해주세요: ");
		int startVertex = scanner.nextInt();
		shortPath(startVertex,checkArray,dist,cost);
	}

}
