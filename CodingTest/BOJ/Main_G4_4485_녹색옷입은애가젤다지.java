package com.ssafy.ws0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_4485_녹색옷입은애가젤다지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(true) {
			int N = Integer.parseInt(in.readLine());
			if(N == 0) break;
			sb.append("Problem ").append(cnt++).append(": ");
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] rupee = new int[N][N];
			for(int[] r : rupee) {
				Arrays.fill(r, Integer.MAX_VALUE);
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->(a[2]-b[2]));
			rupee[0][0] = map[0][0];
			pq.offer(new int[] {0, 0, rupee[0][0]});
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				for (int i = 0; i < 4; i++) {
					int dx = tmp[0] + dr[i];
					int dy = tmp[1] + dc[i];
					
					if(dx > -1 && dx < N && dy > -1 && dy < N) {
						if(rupee[dx][dy] > rupee[tmp[0]][tmp[1]] + map[dx][dy]) {
							rupee[dx][dy] = rupee[tmp[0]][tmp[1]] + map[dx][dy];
							pq.offer(new int[] {dx, dy, rupee[dx][dy]});
						}
					}
				}
			}
			sb.append(rupee[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
