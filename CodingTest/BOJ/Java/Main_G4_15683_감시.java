package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G4_15683_감시 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static LinkedList<int[]> cctv;
	static LinkedHashMap<Integer, int[][]> dir;
	static int N, M, res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] office = new int[N][M];
		int blank = 0;
		cctv = new LinkedList<>();
		dir = new LinkedHashMap<>();
		dir.put(1, new int[][] {{0},{1},{2},{3}});
		dir.put(2, new int[][] {{0,2},{1,3}});
		dir.put(3, new int[][] {{0,1},{1,2},{2,3},{3,0}});
		dir.put(4, new int[][] {{0,1,2},{1,2,3},{2,3,0},{3,0,1}});
		dir.put(5, new int[][] {{0,1,2,3}});
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				office[i][j] = tmp;
				
				if(tmp == 0) blank++;
				else if(tmp >= 1 && tmp <= 5) {
					cctv.add(new int[] {i,j,tmp});
				}
			}
		}
		
		BlankCheck(office, 0, blank);
		System.out.println(res);
		
	}
	private static void BlankCheck(int[][] office, int idx, int blank) {
		if(cctv.size() == idx) {
			res = res > blank ? blank : res;
			return;
		}
		
		int[][] map = new int[N][M];
	
		int nowcctv = cctv.get(idx)[2];
		int[][] dircctv = dir.get(nowcctv);
		
		for (int i = 0; i < dircctv.length; i++) {
			int b = blank;
			for (int j = 0; j < N; j++) {
				map[j] = office[j].clone();
			}
			for (int j = 0; j < dircctv[i].length; j++) {
				int r = cctv.get(idx)[0];
				int c = cctv.get(idx)[1];
				while(true) {
					r = r + dr[dircctv[i][j]];
					c = c + dc[dircctv[i][j]];
					if(r > -1 && r < N && c > -1 && c < M && map[r][c] != 6) {
//					if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 6) {
						if(map[r][c] == 0) {
							b--;
							map[r][c] = -1;
						}
					}
					else break;
				}
			}
			BlankCheck(map, idx+1, b);
		}
	}
}
