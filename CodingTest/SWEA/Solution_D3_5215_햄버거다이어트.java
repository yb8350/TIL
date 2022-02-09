package com.ssafy.ws0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_5215_햄버거다이어트 {
	static int N, L, max;
	static boolean isSelected[];
	static int[] score, kal;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = in.readLine();
			N = Integer.parseInt(s.split(" ")[0]);
			L = Integer.parseInt(s.split(" ")[1]);
			score = new int[N];
			kal = new int[N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				s = in.readLine();
				score[i] = Integer.parseInt(s.split(" ")[0]);
				kal[i] = Integer.parseInt(s.split(" ")[1]);
			}
			hamburger(0, 0, 0);
			sb.append(max).append("\n");
			max = 0;
		}
		System.out.println(sb);
	}
	public static void hamburger(int cnt, int res, int check) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					res += score[i];
					check += kal[i];
				}
			}
			if(max < res && check <= L) max = res;
			res = 0;
			check = 0;
			return;
		}
		isSelected[cnt] = true;
		hamburger(cnt+1, res, check);
		isSelected[cnt] = false;
		hamburger(cnt+1, res, check);
	}
}