package com.ssafy.st0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2206_벽부수고이동하기 { //163844kb	784ms
	static int N, M;
	static ArrayList<int[]> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(N == 1 & M == 1) { //시작과 끝이 같을 때
			System.out.println(1);
			return;
		}
		
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		// 풀이
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] test = new int[N][M]; //거리 측정 배열
		boolean[][][] visited = new boolean[N][M][2]; //방문 체크 배열
		q.offer(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int dx = tmp[0] + dr[i];
				int dy = tmp[1] + dc[i];
				if (dx > -1 && dx < N && dy > -1 && dy < M) {
					if (map[dx][dy] == '1') { //벽을 만났을 경우
						if (tmp[2] == 0 && !visited[dx][dy][1]) { //벽을 부순 적 없으면서 방문한적 없을 때
							visited[dx][dy][tmp[2]] = true; //방문처리
							test[dx][dy] = test[tmp[0]][tmp[1]] + 1;
							q.offer(new int[] { dx, dy, 1 });
						}
					} else { //벽이 아닌 경우
						if (!visited[dx][dy][tmp[2]]) { //방문한 적 없을 때
							visited[dx][dy][tmp[2]] = true; //방문 체크
							test[dx][dy] = test[tmp[0]][tmp[1]] + 1;
							q.offer(new int[] { dx, dy, tmp[2] });
						}
					}
					
					if(dx== N-1 && dy == M-1) { //도착점에 왔을 경우
						System.out.println(test[dx][dy] + 1);
						return;
					}
				}
			}
		}
		System.out.print(-1); //도착점을 못 찾았을 경우
	}
//	int max = bfs1(map);
//	for(int[] a : arr) {
//		map[a[0]][a[1]] = '0';
//		int t = bfs2(map);
//		max = t > max ? t : max;
//		map[a[0]][a[1]] = '1';
//	}
//	max = max == 0 ? -1 : max;
//	System.out.println(max);

	private static int bfs1(char[][] map) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] test = new int[N][M];
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int dx = tmp[0] + dr[i];
				int dy = tmp[1] + dc[i];
				if (dx > -1 && dx < N && dy > -1 && dy < M) {
					if (map[dx][dy] == '0' && test[dx][dy] == 0) {
						q.offer(new int[] { dx, dy });
						test[dx][dy] = test[tmp[0]][tmp[1]] + 1;
					} else if (i == 1 || i == 2) {
						arr.add(new int[] { dx, dy });
					}
				}
			}
		}
		return test[N - 1][M - 1];
	}

	private static int bfs2(char[][] map) {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] test = new int[N][M];
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int dx = tmp[0] + dr[i];
				int dy = tmp[1] + dc[i];
				if (dx > -1 && dx < N && dy > -1 && dy < M) {
					if (map[dx][dy] == '0' && test[dx][dy] == 0) {
						q.offer(new int[] { dx, dy });
						test[dx][dy] = test[tmp[0]][tmp[1]] + 1;
					}
				}
			}
		}
		return test[N - 1][M - 1];
	}
}
