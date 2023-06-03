package com.ssafy.ws0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2636_치즈 {
	public static void main(String[] args) throws IOException {
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		int cnt = 0, time = 0;
		int rcnt = 0, rtime = 0;
		boolean tf = false;
		do {
			rcnt = cnt;
			rtime = time;
			cnt = 0;
			tf = false;
			q.offer(new int[] {0, 0});
			boolean[][] visited = new boolean[N+2][M+2];
			
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int i = 0; i < 4; i++) {
					int dx = tmp[0] + dr[i];
					int dy = tmp[1] + dc[i];
					if(dx > -1 && dx < N + 2 && dy > -1 && dy < M + 2 && !visited[dx][dy]) {
						if(map[dx][dy] == 0) {
							q.offer(new int[] {dx, dy});
							visited[dx][dy] = true;
						}
						else if(map[dx][dy] == 1) {
							map[dx][dy] = 0;
							visited[dx][dy] = true;
							cnt++;
						}
					}
				}
				
			}
			time++;
		} while(cnt != 0);
		System.out.println(rtime);
		System.out.println(rcnt);
	}
}
