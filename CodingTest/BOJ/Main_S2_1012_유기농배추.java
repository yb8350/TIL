package com.ssafy.st0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1012_유기농배추 { //13652kb	120ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			//풀이
			int cnt = 0; //배추흰지렁이 개수 카운트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) { //배추를 발견했을 경우
						map[i][j] = 0; //현재 위치 0으로 변환
						//bfs
						Queue<int[]> q = new LinkedList<>();
						q.offer(new int[] {i, j});
						while(!q.isEmpty()) {
							int[] t = q.poll();
							
							for (int k = 0; k < 4; k++) {
								int dx = t[0]+ dr[k];
								int dy = t[1] + dc[k];
								if(dx > -1 && dx < N && dy > -1 && dy < M && map[dx][dy] == 1 ) {
									map[dx][dy] = 0;
									q.offer(new int[] {dx, dy});
								}
							}
						}
						cnt++; //배추흰지렁이 개수 추가
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
