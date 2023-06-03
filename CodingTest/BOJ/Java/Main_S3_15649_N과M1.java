package com.ssafy.st0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_15649_N과M1 { //21212kb	176ms
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N+1];
		res(N, M, 0);
		System.out.println(sb);
	}

	private static void res(int n, int m, int cnt) {
		if(cnt == m) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(!visited[i]) {
				arr[cnt] = i;
				visited[i] = true;
				res(n, m, cnt+1);
				visited[i] = false;
			}
		}
	}
}
