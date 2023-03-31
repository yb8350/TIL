package com.ssafy.ws0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1249_보급로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] s = in.readLine().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			//풀이
			int[][] res = new int[N][N];
			for(int[] r : res) {
				Arrays.fill(r, Integer.MAX_VALUE);
			}
			Queue<int[]> q = new LinkedList<>();
			res[0][0] = 0;
			q.offer(new int[] {0, 0});
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				for (int i = 0; i < 4; i++) {
					int dx = tmp[0] + dr[i];
					int dy = tmp[1] + dc[i];
					if(dx > -1 && dx < N && dy > -1 && dy < N && 
							res[dx][dy] > res[tmp[0]][tmp[1]] + map[dx][dy]) {
						q.offer(new int[] {dx, dy});
						res[dx][dy] = res[tmp[0]][tmp[1]] + map[dx][dy];
					}
				}
			}
			sb.append(res[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
