package com.ssafy.st0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_12865_평범한배낭 { //51300kb	156ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] item = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//풀이
		int[][] res = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				res[i][j] = res[i-1][j];
				if(item[i][0] <= j) {
					res[i][j] = Math.max(res[i-1][j], res[i-1][j-item[i][0]] + item[i][1]);
				}
			}
		}
		System.out.println(res[N][K]);
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
