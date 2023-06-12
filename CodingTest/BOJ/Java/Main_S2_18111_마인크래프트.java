package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_18111_마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j]) max = map[i][j];
				if(min > map[i][j]) min = map[i][j];
			}
		}
		
		int res = Integer.MAX_VALUE, height = 0;
		for (int h = min; h <= max; h++) {
			int plus = 0, minus = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > h) {
						minus += map[i][j] - h;
					}
					else if(map[i][j] < h) {
						plus += h - map[i][j];
					}
				}
			}
			
			if(plus <= B+minus) {
				int tmp = plus + (minus * 2);
				if(tmp <= res) {
					res = tmp;
					height = h;
				}
			}
		}
		
		System.out.println(res + " " + height);
	}
}
