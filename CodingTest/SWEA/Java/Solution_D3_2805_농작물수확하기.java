package com.ssafy.ws0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Solution_D3_2805_농작물수확하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				map[i] = Stream.of(in.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}

			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int skip = 0;
				if(i < N/2) {
					cnt = 2 * i + 1;
					skip = N / 2 - i;
				}
				else if(i > N/2) {
					cnt = 2 * Math.abs((i+1) - N) + 1;
					skip = N / 2 - Math.abs((i+1) - N);
				}
				else cnt = N;

				for (int j = 0; j < N; j++) {
					if(skip <= j) {
						if(cnt >= 0) {
							sum += map[i][j];
							cnt--;
						}
					}
					if(cnt == 0) break;
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
