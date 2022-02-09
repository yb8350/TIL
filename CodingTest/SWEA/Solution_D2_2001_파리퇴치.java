package com.ssafy.hw0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D2_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int temp = 0;
			int res = 0;
			String s = in.readLine();
			int N = Integer.parseInt(s.split(" ")[0]);
			int M = Integer.parseInt(s.split(" ")[1]);
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for (int n1 = 0; n1 < N-M+1; n1++) {
				for (int n2 = 0; n2 < N-M+1; n2++) {
					for (int m1 = n1; m1 < n1+M; m1++) {
						for (int m2 = n2; m2 < n2+M; m2++) {
							temp += map[m1][m2];
						}
					}
					if(temp > res) res = temp;
					temp = 0;
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}
