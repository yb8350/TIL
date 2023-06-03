package com.ssafy.st0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_10163_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[1001][1001];
		int[] res = new int[N + 1];
		for (int tc = 1; tc <= N; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int xp = Integer.parseInt(st.nextToken());
			int yp = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x + xp; i++) {
				for (int j = y; j < y + yp; j++) {
					map[i][j] = tc;
				}
			}
		}
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				res[map[i][j]]++;
			}
		}
		for (int i = 1; i < res.length; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.println(sb);
	}
}
