package com.pttdv.st0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_15663_N과M9 {
	static int N, M;
	static int[] tmp;
	static StringBuilder sb;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N; i++) {
			arr[i] = pq.poll();
		}
		
		tmp = new int[M];
		visited = new boolean[N];
		makeList(arr, 0);
		System.out.println(sb);
	}
	private static void makeList(int[] arr, int n) {
		if(n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i] && tmp[n] != arr[i]) {
				visited[i] = true;
				tmp[n] = arr[i];
				if(n+1 < M) tmp[n+1] = 0;
				makeList(arr, n+1);
				visited[i] = false;
			}
		}
		
	}
}
