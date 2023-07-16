package com.ssafy.ws0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			String[] s = new String[N];
			for (int i = 0; i < N; i+=2) {
				s[i] = st.nextToken();
			}
			for (int i = 1; i < N; i+=2) {
				s[i] = st.nextToken();
			}
			for (int i = 0; i < N; i++) {
				sb.append(s[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
