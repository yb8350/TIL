package com.ssafy.ws0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_17144_미세먼지안녕 {
	static int R, C;
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		int[] ap = new int[2];
		Queue<int[]> mimun = new LinkedList<>();
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			if(map[i][0] == -1) {
				ap[0] = i;
				ap[1] = i + 1;
				break;
			}
		}
		
		//풀이
		for (int t = 0; t < T; t++) {
			//0. 미세먼지 위치를 찾아 큐에 추가
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] > 0) mimun.offer(new int[] {i, j});
				}
			}
			//1. 미세먼지 확산(bfs) - 동시에 이루어지므로, 임시맵에 확산 결과 표기
			int[][] tmap = new int[R][C];
			tmap[ap[0]][0] = tmap[ap[1]][0] = -1; //임시맵에 공기청정기 설치
			while(!mimun.isEmpty()) {
				int cnt = 0;
				int[] tmp = mimun.poll();
				for (int i = 0; i < 4; i++) {
					int dx = tmp[0] + dr[i];
					int dy = tmp[1] + dc[i];
					if(dx > -1 && dx < R && dy > -1 && dy < C && map[dx][dy] > -1) {
						tmap[dx][dy] += map[tmp[0]][tmp[1]] / 5;
						cnt++;
					}
				}
				tmap[tmp[0]][tmp[1]] += map[tmp[0]][tmp[1]] - (map[tmp[0]][tmp[1]] / 5) * cnt;
			}
			
			//2. 공기청정기 작동
			tmap[ap[0]][0] = tmap[ap[1]][0] = 0; //계산의 편의를 위해 공기청정기 표시 삭제
			wind1(tmap, ap[0]);
			wind2(tmap, ap[1]);
			
			//임시맵을 원래 맵에 복사
			map = tmap;
		}
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
		
	}
	private static void wind1(int[][] map, int ap) {
		for (int i = ap - 1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			map[0][j] = map[0][j+1];
		}
		for (int i = 0; i < ap; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for (int j = C - 1; j > 0; j--) {
			map[ap][j] = map[ap][j-1];
		}
	}
	
	private static void wind2(int[][] map, int ap) {
		for (int i = ap + 1; i < R - 1; i++) {
			map[i][0] = map[i+1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			map[R-1][j] = map[R-1][j+1];
		}
		for (int i = R - 1; i > ap; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for (int j = C - 1; j > 0; j--) {
			map[ap][j] = map[ap][j-1];
		}
	}
	
}
