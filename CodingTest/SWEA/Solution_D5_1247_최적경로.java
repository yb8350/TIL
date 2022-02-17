package com.ssafy.ws0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	static int[] temp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			int officeX = Integer.parseInt(st.nextToken());
			int officeY = Integer.parseInt(st.nextToken());
			int houseX = Integer.parseInt(st.nextToken());
			int houseY = Integer.parseInt(st.nextToken());
			int[][] cus = new int [N][2];
			temp = new int[N];
			for (int i = 0; i < N; i++) {
				temp[i] = i;
			}
			for (int i = 0; i < N; i++) {
				cus[i][0] = Integer.parseInt(st.nextToken());
				cus[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//문제풀이
			int min = Integer.MAX_VALUE;
			do {
				int res = 0;
				int tx = officeX, ty = officeY;
				for (int i = 0; i < N; i++) {
					res += Math.abs(tx - cus[temp[i]][0])+Math.abs(ty - cus[temp[i]][1]);
					tx = cus[temp[i]][0];
					ty = cus[temp[i]][1];
				}
				res += Math.abs(tx - houseX)+Math.abs(ty - houseY);
				min = res < min ? res : min;
			}while(np());
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean np() {
		int N = temp.length;
		
		int i = N - 1;
		while(i > 0 && temp[i-1] >= temp[i]) i--;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(temp[i-1] >= temp[j]) j--;
		
		swap(i-1, j);
		
		int k = N - 1;
		while(i < k) swap(i++, k--);
		return true;
	}

	private static void swap(int i, int j) {
		int tmp = temp[i];
		temp[i] = temp[j];
		temp[j] = tmp;
		
	}
	

}
