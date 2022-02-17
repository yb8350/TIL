package com.ssafy.hw0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G4_1987_알파벳 {
	static int R, C, max;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[] visited = new boolean[26];
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		//문제풀이
		check(0, 0, 1);
		
		//출력
		System.out.println(max);
	}
	
	private static void check(int r, int c, int cnt) {
		visited[map[r][c] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			if(r + dr[i] > -1 && c + dc[i] > -1 && r + dr[i] < R && c + dc[i] < C) {
				if(!visited[map[r+dr[i]][c+dc[i]] - 'A']) check(r+dr[i], c+dc[i], cnt + 1);
			}
		}
		if(cnt > max) max = cnt;
		visited[map[r][c] - 'A'] =false;
	}
	
}