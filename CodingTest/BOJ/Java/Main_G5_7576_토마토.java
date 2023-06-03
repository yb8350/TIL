package com.ssafy.ws0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_7576_토마토 {
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) q.offer(new int[] {i, j}); //토마토 위치를 큐에 추가
			}
		}
		
		//풀이
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int dx = tmp[0] + dr[i];
				int dy = tmp[1] + dc[i];
				if(dx > -1 && dx < N && dy > -1 && dy < M && map[dx][dy] == 0) {
					map[dx][dy] = map[tmp[0]][tmp[1]] + 1;
					q.offer(new int[] {dx, dy});
				}
			}
		} //bfs
		
		//익을 수 있는 모든 토마토가 익은 상태에서
		//0이 발견될 경우 -1출력, 그게 아니면 max값 찾기
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = max < map[i][j] ? map[i][j] : max;
			}
		}
		System.out.println(max-1);
	}
}
