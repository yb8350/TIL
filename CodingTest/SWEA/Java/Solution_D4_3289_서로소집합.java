package com.ssafy.ws0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합 {
	static int[] par;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			par = new int[N+1];
			for (int i = 1; i <= N; i++) {
				par[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int select = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(select == 0) union(a, b);
				else {
					if(findset(a) == findset(b)) sb.append("1");
					else sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void union(int i, int j) {
		int rootA = findset(i);
		int rootB = findset(j);
		if(rootA == rootB) return;
		par[rootB] = rootA;
	}

	private static int findset(int i) {
		if(par[i] == i) return i;
		return par[i] = findset(par[i]);
	}
}
