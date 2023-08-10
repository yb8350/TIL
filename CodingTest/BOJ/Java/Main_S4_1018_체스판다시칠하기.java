package com.pttdv.st0804;
import java.util.*;
import java.io.*;
public class Main_S4_1018_체스판다시칠하기 { //	12288kb	104ms
	static int res = 64;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split("");
			for (int j = 0; j < M; j++) {
				if(tmp[j].equals("W")) map[i][j] = true;
				else map[i][j] = false;
			}
		}
		
		for(int i = 0; i < N-7; i++) {
			for(int j = 0; j < M-7; j++) {
				Paint(map, i, j);
			}
		}
		
		System.out.println(res);
	}
	private static void Paint(boolean[][] map, int i, int j) {
		int cnt = 0;
		boolean isWhite = true;
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if(isWhite != map[i+x][j+y]) cnt++;
				isWhite = !isWhite;
			}
			isWhite = !isWhite;
		}
		int min = Math.min(cnt, 64-cnt);
		res = Math.min(res, min);
	}
}
