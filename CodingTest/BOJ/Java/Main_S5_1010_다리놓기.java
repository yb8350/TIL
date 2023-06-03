package com.pttdv.st0602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_1010_다리놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(Combination(N, M)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static long Combination(int r, int n) {
		long up = 1;
		long down = 1;
		
		if(n - r < r) {
			for (int i = r+1; i <= n; i++) {
				up *= i;
			}
			for (int i = 2; i <= n - r; i++) {
				down *= i;
			}
		}
		else {
			for (int i = n-r+1; i <= n; i++) {
				up *= i;
			}
			for (int i = 2; i <= r; i++) {
				down *= i;
			}
		}

		return up / down;
	}
}
