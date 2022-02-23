package com.ssafy.hw0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리의개수 {
	static int[] cy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			cy = new int[N+1];
			for (int i = 1; i <= N; i++) {
				cy[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if(cy[i] == i) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void union(int i, int j) {
		int rootA = findset(i);
		int rootB = findset(j);
		if(rootA == rootB) return;
		cy[rootB] = rootA;
	}

	private static int findset(int i) {
		if(cy[i] == i) return i;
		return cy[i] = findset(cy[i]);
	}
}
