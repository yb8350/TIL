package com.ssafy.ws0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int[] LIS = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int res = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				res = Math.max(LIS[i], res);
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}
