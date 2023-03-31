package com.ssafy.st0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2178_미로탐색 { //12284kb	88ms
	public static void main(String[] args) throws IOException {
		//입력
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M]; //미로찾기 지도
		int[][] res = new int[N][M]; //이동 거리를 계산할 맵
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		//풀이
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0}); //시작점을 큐에 추가
		map[0][0] = '0'; //시작점을 0으로 바꾸어 방문 표시
		res[0][0] = 1;
		while(!q.isEmpty()) { //bfs
			int[] tmp = q.poll();
			for (int k = 0; k < 4; k++) {
				int dx = tmp[0] + dr[k];
				int dy = tmp[1] + dc[k];
				if(dx > -1 && dx < N && dy > -1 && dy < M && map[dx][dy] == '1') {
					map[dx][dy] = '0';
					res[dx][dy] = res[tmp[0]][tmp[1]] + 1; //이동거리 계산
					q.offer(new int[] {dx, dy});
					
				}
			}
		}
		System.out.println(res[N-1][M-1]);
	}
}
