package com.ssafy.ws0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_14502_연구소 {
	static int N, M, max, vc = Integer.MAX_VALUE, bc;
	static ArrayList<int[]> virus;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) virus.add(new int[] {i, j});
				if(map[i][j] == 0) bc++;
			}
		}
		
		//풀이
		// 1. 벽을 3개 세운 후
		// 2. 바이러스 퍼뜨려보기
		// 3. 남은 빈칸의 갯수를 센다.
		// 4. 위 과정을 반복하여 남은 빈칸의 수 최댓값 찾기
		createWall(map, 0);
		System.out.println(max);
		
	}

	private static void createWall(int[][] map, int cnt) {
		if(cnt == 3) {
			goVirus(map);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					createWall(map, cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static void goVirus(int[][] map) {
		int vcnt = 0, res = 0;
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		int[][] tm = new int[N][M];
		for (int i = 0; i < N; i++) {
			tm[i] = Arrays.copyOf(map[i], M);
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		for(int[] v : virus) {
			q.offer(new int[] {v[0], v[1]});			
		}
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int dx = tmp[0] + dr[i];
				int dy = tmp[1] + dc[i];
				
				if(dx > -1 && dx < N && dy > -1 && dy < M && tm[dx][dy] == 0) {
					tm[dx][dy] = 2;
					if(++vcnt > vc) return;
					q.offer(new int[] {dx, dy});
				}
			}
		}
		
		if(bc == vcnt) return;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tm[i][j] == 0) res++;
			}
		}
		
		if(res > max) {
			max = res;
			vc = vcnt;
		}
	}
}
