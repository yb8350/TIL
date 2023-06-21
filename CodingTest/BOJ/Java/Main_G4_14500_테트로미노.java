package com.pttdv.st0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_14500_테트로미노 {
	static int N, M, max;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] tmp = new int[4][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[0][0] = i;
				tmp[0][1] = j;
				visited[i][j] = true;
				dfs(map, visited, tmp, 1, map[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
	}
	private static void dfs(int[][] map, boolean[][] visited, int[][] tmp, int cnt, int sum) {
		if(cnt == 4) {
			max = sum > max ? sum : max;
			return;
		}
		
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < 4; j++) {
				int dx = tmp[i][0] + dr[j];
				int dy = tmp[i][1] + dc[j];
				if(dx > -1 && dx < N && dy > -1 && dy < M && !visited[dx][dy]) {
					tmp[cnt][0] = dx;
					tmp[cnt][1] = dy;
					visited[dx][dy] = true;
					dfs(map, visited, tmp, cnt+1, sum+map[dx][dy]);
					visited[dx][dy] = false;
				}
			}
		}
	}
}
