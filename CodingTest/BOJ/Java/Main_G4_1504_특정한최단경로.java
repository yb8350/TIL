package com.ssafy.st0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1504_특정한최단경로 { //67328kb	660ms
	
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
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node(e, w));
			list.get(e).add(new Node(s, w));
		}
		st = new StringTokenizer(in.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		//풀이 : 답이 되는 경로는 1-v1-v2-N or 1-v2-v1-N 둘 중 하나이므로,
		//다익스트라를 통해 두 경로 중 최소를 탐색
		//경로가 없는 경우를 고려하여 long타입으로 해주기
		
		//1-v1-v2-N
		long s1 = dijk(1, v1);
		s1 += dijk(v1, v2);
		s1 += dijk(v2, N);
		
		//1-v2-v1-N
		long s2 = dijk(1, v2);
		s2 += dijk(v2, v1);
		s2 += dijk(v1, N);
		
		long r = Math.min(s1, s2);
		System.out.println(r >= Integer.MAX_VALUE ? -1 : r);
	}
	
	//다익스트라
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
