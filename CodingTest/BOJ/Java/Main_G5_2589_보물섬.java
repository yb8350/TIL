package com.pttdv.st0912;
import java.util.*;
import java.io.*;
public class Main_G5_2589_보물섬 { //293944kb	696ms
	public static void main(String[] args) throws IOException {
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] map = new String[N][M];
		
		// map 입력
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().split("");
		}
		
		// 풀이 : L인 칸의 최단 거리를 모두 측정해서 그 중 최댓값을 출력
		int res = 0;
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				if(map[i][j].equals("L")) {
					int[][] visited = new int[N][M];
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] {i, j});
					visited[i][j] = 1;
					int max = 0;
					
					// bfs
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						for (int k = 0; k < 4; k++) {
							int dx = tmp[0] + dr[k];
							int dy = tmp[1] + dc[k];
							if(dx > -1 && dx < N && dy > -1 && dy < M && map[dx][dy].equals("L") && visited[dx][dy] == 0) {
								visited[dx][dy] = visited[tmp[0]][tmp[1]] + 1;
								max = Math.max(max, visited[dx][dy]);
								q.add(new int[] {dx, dy});
							}
						}
					}
					
					res = Math.max(max, res);
				}
			}
		}
		System.out.println(res - 1);
		
	}
}
