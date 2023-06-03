package com.ssafy.ws0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1753_최단경로 {
	static class Node {
		int to;
		int weight;
		Node link;
		
		public Node(int to, int weight, Node link) {
			super();
			this.to = to;
			this.weight = weight;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());
		Node[] node = new Node[V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			node[u] = new Node(v, w, node[u]);
		}
		
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		for (int i = 1; i <= V; i++) {
			int min=Integer.MAX_VALUE, current=0;
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			for(Node n = node[current]; n != null; n = n.link) {
				if(!visited[n.to] && distance[n.to] > distance[current] + n.weight)
					distance[n.to] = distance[current] + n.weight;
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
}
