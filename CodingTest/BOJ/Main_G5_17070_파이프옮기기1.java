package com.ssafy.st0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_17070_파이프옮기기1 { //13532kb	168ms
	static int N, res;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//풀이
		dfs(0,1,0);
		System.out.println(res);
	}

	private static void dfs(int r, int c, int d) {
		if(r == N-1 && c == N-1) {
			res++;
			return;
		}
		
		if(d != 1 && c+1 < N && map[r][c+1] == 0) {
			dfs(r,c+1,0);
		}
		if(d != 0 && r+1 < N && map[r+1][c] == 0) {
			dfs(r+1,c,1);
		}
		if(r+1 < N && c+1 < N && map[r+1][c] == 0 && map[r][c+1] == 0 && map[r+1][c+1] == 0) {
			dfs(r+1,c+1,2);
		}
	}
}
