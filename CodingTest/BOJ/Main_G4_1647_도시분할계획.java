package com.ssafy.st0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1647_도시분할계획 { //325044kb	1904ms
	
	static class Node implements Comparable<Node>{ //Node Class 생성
		int sp, ep, weight;

		public Node(int sp, int ep, int weight) {
			super();
			this.sp = sp;
			this.ep = ep;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}

		@Override
		public String toString() {
			return "Node [sp=" + sp + ", ep=" + ep + ", weight=" + weight + "]";
		}
		
	}
	
	static int[] arr; //정점과 연결 위치 저장
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1]; //정점 채우기
		for (int i = 0; i < N; i++) {
			arr[i] = i;
		}
		
		//풀이
		PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐 생성

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int sp = Integer.parseInt(st.nextToken());
			int ep = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.offer(new Node(sp, ep, weight)); //우선순위 큐 채우기
		}
		
		int res = 0, lr = 0;
		while(!pq.isEmpty()) { //최소 weight부터 정점 연결
			Node tmp = pq.poll();
			if(find(tmp.sp) != find(tmp.ep)) {
				union(tmp.sp, tmp.ep);
				res += tmp.weight;
				lr = tmp.weight;
			}
		}
		
		System.out.println(res - lr); //마지막으로 연결한 정점의 weight 제외
	}


	private static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if(ra == rb) return;
		arr[rb] = ra;
	}
	
	private static int find(int n) {
		if(arr[n] == n) return n;
		return arr[n] = find(arr[n]);
	}
	
}
