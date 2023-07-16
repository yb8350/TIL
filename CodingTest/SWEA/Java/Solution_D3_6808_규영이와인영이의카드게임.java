package com.ssafy.ws0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영이와인영이의카드게임 {
	static int[] gyu, iny;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			boolean[] checked = new boolean[18];
			gyu = new int[9];
			iny = new int[9];
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				checked[gyu[i]-1] = true;
			}
			int cnt = 0;
			for (int i = 0; i < 18; i++) {
				if(!checked[i]) iny[cnt++] = i+1;
			}
			int win = 0, lose = 0;
			
			do {
				int gyus = 0, inys = 0;
				for(int i = 0; i < 9; i++) {
					if(gyu[i] > iny[i]) gyus+= gyu[i]+iny[i];
					else if(gyu[i] < iny[i]) inys+= gyu[i]+iny[i];
				}
				if(gyus > inys) win++;
				else if(gyus < inys) lose++;
				
			}while(np());
			sb.append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean np() {
		int i = 8;
		while(i > 0 && iny[i-1]>=iny[i]) --i;
		
		if(i == 0) return false;
		
		int j = 8;
		while(iny[i-1] >= iny[j]) --j;
		
		swap(i-1, j);
		
		int k = 8;
		while(i < k) swap(i++, k--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int temp = iny[i];
		iny[i] = iny[j];
		iny[j] = temp;
		
	}
}
