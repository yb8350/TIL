package com.ssafy.st0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S4_10157_자리배정 {
	public static void main(String[] args) throws IOException {
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(R);
		for (int i = 1, cnt = R; cnt != R * C; i++) {
			arr.add(C-i);
			arr.add(R-i);
			cnt += (C-i) + (R-i);
		}
		int nr = 1, nc = 0;
		for (int i = 0; i < arr.size(); i++) {
			int n = arr.get(i);
			if(N - n > 0) {
				N -= n;
				nr += dr[i % 4] * n;
				nc += dc[i % 4] * n;
			}
			else {
				nr += dr[i % 4] * N;
				nc += dc[i % 4] * N;
				sb.append(nr).append(" ").append(nc);
				System.out.println(sb);
				return;
			}
		}
		System.out.println(0);
	}
}