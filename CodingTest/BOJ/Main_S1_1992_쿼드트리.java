package com.ssafy.hw0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S1_1992_쿼드트리 {
	static int[][] v;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		v = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			v[i] = Arrays.stream(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		QuadTree(N, 0, 0);
		System.out.println(sb);

	}

	private static void QuadTree(int n, int r, int c) {
		
		int value = v[r][c];
		boolean b = true;
		out: for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (v[i][j] != value) {
					b = false;
					break out;
				}
			}
		}

		if (b)sb.append(value);
		else {
			sb.append("(");
			QuadTree(n / 2, r, c);
			QuadTree(n / 2, r, c + n / 2);
			QuadTree(n / 2, r + n / 2, c);
			QuadTree(n / 2, r + n / 2, c + n / 2);
			sb.append(")");
		}
		
	}

}
