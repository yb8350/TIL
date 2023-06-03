package com.ssafy.hw0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G5_10026_적록색약 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(map, visited, i, j);
					cnt1++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(map, visited, i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
		
	}

	private static void bfs(char[][] map, boolean[][] visited, int a, int b) {
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {a, b});
		char color = map[a][b];
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int dx = tmp[0]+dr[i];
				int dy = tmp[1]+dc[i];
				if(dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
				else if(!visited[dx][dy] && map[dx][dy] == color) {
					visited[dx][dy] = true;
					q.offer(new int[] {dx, dy});
				}
			}
		}
	}
}
