package com.ssafy.st0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G3_1238_파티 { //16480kb	148ms
	static class Node implements Comparable<Node>{
		int idx;
		int time;
		
		public Node(int idx, int time) {
			super();
			this.idx = idx;
			this.time = time;
		}

		@Override
		public int compareTo(Node e) {
			return this.time - e.time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		ArrayList<ArrayList<Node>> rvlist = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
			rvlist.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node(e, t));
			rvlist.get(e).add(new Node(s, t));
		}
		
		//풀이 : 다익스트라를 정방향과 역방향 모두 입력받아 두번 돌리기
		int[] t1 = dijk(list, X);
		int[] t2 = dijk(rvlist, X);
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, t1[i] + t2[i]);
		}
		
		System.out.println(max);
	}

	private static int[] dijk(ArrayList<ArrayList<Node>> list, int x) {
		int N = list.size() - 1;
		
		boolean[] visited = new boolean[N+1]; //방문 체크
		int[] times = new int[N+1]; //시작점부터 각 노드까지의 최단시간
		Arrays.fill(times, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(x, 0));
        times[x] = 0;
        while(!pq.isEmpty()) {
        	Node tmp = pq.poll();
        	if(visited[tmp.idx]) continue;
        	visited[tmp.idx] = true;
        	for (Node n : list.get(tmp.idx)) {
				if(times[n.idx] > times[tmp.idx] + n.time) { 
					times[n.idx] = times[tmp.idx] + n.time;
					pq.offer(new Node(n.idx, times[n.idx]));
				}
			}
        }
        
        return times;
	}
}
