package com.ssafy.hw0203;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1954_달팽이숫자 {
	public static void main(String[] args) throws Exception {
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(in.readLine());
			int[] search = new int[n*2-1];
			search[0] = n - 1;
			int temp = 1;
			for (int j = 1; j < search.length; j+=2) {
				search[j] = n-temp;
				search[j+1] = n-temp;
				temp++;
			}
			
			int[][] roll = new int[n][n];
			int count = 1;
			int r = 0;
			int c = 0;
			roll[r][c] = count++;
			for(int j = 0; j < search.length; j++) {
				for(int k = 0; k < search[j]; k++) {
					r+=dr[j%4];
					c+=dc[j%4];
					roll[r][c] = count++;
				}
			}
			
			sb.append("#" + (i+1) + "\n");
			for (int j = 0; j < roll.length; j++) {
				for (int k = 0; k < roll.length; k++) {
					sb.append(roll[j][k] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
