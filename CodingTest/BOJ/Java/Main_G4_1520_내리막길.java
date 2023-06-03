package com.ssafy.st0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1520_내리막길 { //38884kb	312ms
	static int R, C;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] dp = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			} 
		}
		
		//풀이
		System.out.println(dfs(map, dp, 0, 0));
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	private static int dfs(int[][] map, int[][] dp, int r, int c) {
		if(r == R - 1 && c == C - 1) return 1;
		if(dp[r][c] != -1) return dp[r][c];

		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];
			if(dx > -1 && dx < R && dy > -1 && dy < C && map[r][c] > map[dx][dy]) {
				dp[r][c] += dfs(map, dp, dx, dy);
			}
		}

		return dp[r][c];
	}
}
