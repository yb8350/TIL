package com.ssafy.st0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int map[][] = new int[101][101];
		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
}
