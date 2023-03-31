package com.ssafy.st0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1197_최소스패닝트리 { //49584kb	548ms
	static class Edge implements Comparable<Edge>{
		int v1, v2, weight;

		public Edge(int v1, int v2, int weight) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return weight - e.weight;
		}
	}
	
	static int[] parent;
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parent = new int[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(v1, v2, w));
		}
		
		//풀이
		int res = 0;
		while(!pq.isEmpty()) {
			Edge tmp = pq.poll();
			if(find(tmp.v1) != find(tmp.v2)) {
				union(tmp.v1, tmp.v2);
				res += tmp.weight;
			}
		}
		System.out.println(res);
		
	}
    
    private static void union(int i, int j) {
		int rootA = find(i);
		int rootB = find(j);
		if(rootA == rootB) return;
		parent[rootB] = rootA;
	}

	private static int find(int i) {
		if(parent[i] == i) return i;
		return parent[i] = find(parent[i]);
	}
}
