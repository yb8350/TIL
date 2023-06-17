package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] line = in.readLine().split("");
			int cnt = 0;
			int res = 0;
			for (int i = 0; i < line.length; i++) {
				if(line[i].equals(("O"))) {
					res += 1 + cnt;
					cnt++;
				} else {
					cnt = 0;
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}
