package com.ssafy.ws0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_1600_말이되고픈원숭이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[] hr = { 2, 2, 1, 1, -1, -1, -2, -2 };
		int[] hc = { 1, -1, 2, -2, 2, -2, 1, -1 };
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[W][H];
		boolean[][][] visited = new boolean[W][H][K+1];
		
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < H; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//풀이
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0, 0, 0, 0});
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			if(tmp[0] == W-1 && tmp[1] == H-1) { //도착점에 왔을 경우
				System.out.println(tmp[3]);
				return;
			}
			
			if(tmp[2] < K) {
				for (int i = 0; i < 8; i++) {
					int dx = tmp[0] + hr[i];
					int dy = tmp[1] + hc[i];
					if(dx > -1 && dx < W && dy > -1 && dy < H && map[dx][dy] == 0 && !visited[dx][dy][tmp[2]+1]) {
						visited[dx][dy][tmp[2]+1] = true;
						q.offer(new int[] {dx, dy, tmp[2]+1, tmp[3]+1});
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int dx = tmp[0] + dr[i];
				int dy = tmp[1] + dc[i];
				if(dx > -1 && dx < W && dy > -1 && dy < H && map[dx][dy] == 0 && !visited[dx][dy][tmp[2]]) {
					visited[dx][dy][tmp[2]] = true;
					q.offer(new int[] {dx, dy, tmp[2], tmp[3]+1});
				}
			}
		}
		System.out.println(-1);
	}
}
