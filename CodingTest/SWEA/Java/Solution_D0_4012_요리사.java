package com.ssafy.ws0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D0_4012_요리사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] input = new int[N];
			for (int i = N-1; i > N/2 - 1; i--) {
				input[i] = 1;
			}
			int min = Integer.MAX_VALUE;
			do {
				int[] s1 = new int [N/2], s2 = new int [N/2];
				int s1cnt = 0, s2cnt = 0;
				int foodA = 0, foodB = 0;
				for (int i = 0; i < input.length; i++) {
					if(input[i] == 1) s1[s1cnt++] = i;
					else if(input[i] == 0) s2[s2cnt++] = i;
				}
				for (int i = 0; i < s1.length - 1; i++) {
					for (int j = i + 1; j < s1.length; j++) {
						foodA += map[s1[i]][s1[j]] + map[s1[j]][s1[i]];
					}
				}
				for (int i = 0; i < s2.length - 1; i++) {
					for (int j = i + 1; j < s2.length; j++) {
						foodB += map[s2[i]][s2[j]] + map[s2[j]][s2[i]];
					}
				}
				if(min > Math.abs(foodA - foodB)) min = Math.abs(foodA - foodB);
			} while (np(input));
			
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean np(int[] input) {
		int N = input.length;
		
		int i = N - 1;
		while(i > 0 && input[i-1] >= input[i]) i--;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(input[i-1] >= input[j]) j--;
		
		swap(input, i-1, j);
		
		int k = N-1;
		while(i < k) swap(input, i++, k--);
		
		return true;
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
	}
}
