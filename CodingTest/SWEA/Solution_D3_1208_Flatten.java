package com.ssafy.ws0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_1208_Flatten {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int cnt = Integer.parseInt(in.readLine());
			int[] box = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(box);
			for(int i = 0; i < cnt; i++) {
				box[0]++;
				box[box.length-1]--;
				Arrays.sort(box);
			}
			sb.append(box[box.length-1]-box[0]).append("\n");
		}
		System.out.println(sb);
	}
}
