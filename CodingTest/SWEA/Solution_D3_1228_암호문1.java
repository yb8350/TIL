package com.ssafy.ws0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int C = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < C; i++) {
				if (st.nextToken().equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						list.add(x + j, Integer.parseInt(st.nextToken()));
					}
				}
			}
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
