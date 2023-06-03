package com.pttdv.st0602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1189_컴백홈 {
	static int N, M, K, result = 0; 
	static int[] dr, dc;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dr = new int[] {0, 1, 0, -1};
		dc = new int[] {-1, 0, 1, 0};
		
		String[][] map = new String[N][M];
		boolean[][] isVisited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			map[i] = st.nextToken().split("");
		}
		isVisited[0][M-1] = true;
		goHome(0, M-1, map, isVisited, 1);
		System.out.println(result);
		
	}
	private static void goHome(int r, int c, String[][] map, boolean[][] isVisited, int cnt) {
		//종료조건
		if(cnt == K) {
			if(r == N - 1 && c == 0) {
				result++;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];
			if(dx > -1 && dx < N && dy > -1 && dy < M && !isVisited[dx][dy] && map[dx][dy].equals(".")) {
				isVisited[dx][dy] = true;
				goHome(dx, dy, map, isVisited, cnt+1);
				isVisited[dx][dy] = false;
			}
		}
	}
}
