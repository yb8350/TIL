package com.ssafy.ws0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_16926_배열돌리기1 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N, M, R;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = in.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++) {
			turn(0, 0, M-1, N-1);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void turn(int sr, int sc, int move1, int move2) {
		
		if(sr == N/2 || sc == M/2) {
			return;
		}
		int r = sr;
		int c = sc;
		int temp = arr[sr][sc];
		int mode = 0;
		for(int j = 0; j < 2; j++) {
			for(int k = 0; k < move1; k++) {
				int rr=r + dr[mode%4];
				int cc=c + dc[mode%4];
				arr[r][c] = arr[rr][cc];
				r = rr;
				c = cc;
			}
			mode++;
			for(int k = 0; k < move2; k++) {
				int rr=r + dr[mode%4];
				int cc=c + dc[mode%4];
				arr[r][c] = arr[rr][cc];
				r = rr;
				c = cc;
			}
			mode++;
		}
		arr[r+1][c] = temp;
		turn(sr + 1, sc + 1, move1 - 2, move2 - 2);
	}
}
