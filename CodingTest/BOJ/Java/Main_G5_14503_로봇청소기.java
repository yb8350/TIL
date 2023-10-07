package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_G5_14503_로봇청소기 { // 11836kb	84ms
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0, -1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1, 0, 1, 0, -1};
	static int N, M, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		// 입력: 맵 전체
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) visited[i][j] = true;
			}
		}
		
		while(true) {
			// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(!visited[r][c]) {
				visited[r][c] = true;
				res++;
			}
			
			// 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int dx = r + dr[i];
				int dy = c + dc[i];
				if(dx > -1 && dx < N && dy > -1 && dy < M && !visited[dx][dy]) {
					cnt++;
				}
			}

			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
			if(cnt == 0) {
				int dx = r + dr[d + 2];
				int dy = c + dc[d + 2];
				if(dx > -1 && dx < N && dy > -1 && dy < M && map[dx][dy] == 0) {
					r = dx;
					c = dy;
				}
				else {
					break;
				}
			}
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
			else {
				d = d == 0 ? 3 : d - 1;
				int dx = r + dr[d];
				int dy = c + dc[d];
				if(dx > -1 && dx < N && dy > -1 && dy < M && !visited[dx][dy]) {
					r = dx;
					c = dy;
				}
			}
		}

		System.out.println(res);

	}
}
