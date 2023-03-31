package com.ssafy.st0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_1916_최소비용구하기 { //52028kb	464ms
	static class Node implements Comparable<Node>{
		int idx;
		int weight;
		
		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
		
	}
	static int N;
	static ArrayList<ArrayList<Node>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node(e, w));
		}
		StringTokenizer st = new StringTokenizer(in.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		//풀이 : v1부터 v2까지 다익스트라 돌려보기
		System.out.println(dijk(v1, v2));
	}
	private static int dijk(int i, int j) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int[] res = new int[N+1];
		Arrays.fill(res, Integer.MAX_VALUE);
		pq.offer(new Node(i, 0));
		res[i] = 0;
		while(!pq.isEmpty()) {
			int tmp = pq.poll().idx;
			if(visited[tmp]) continue;
			visited[tmp] = true;
			for (Node n : list.get(tmp)) {
				if(res[n.idx] > res[tmp] + n.weight) {
					res[n.idx] = res[tmp] + n.weight;
					pq.offer(new Node(n.idx, res[n.idx]));
				}
			}
		}
		return res[j];
	}
}
