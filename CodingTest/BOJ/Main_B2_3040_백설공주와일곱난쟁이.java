package com.ssafy.hw0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B2_3040_백설공주와일곱난쟁이 {
	static int[] dwarf, tmp, res;
	static boolean yes = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dwarf = new int[9];
		tmp = new int[7];
		
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(in.readLine());
		}
		check(0,0);
		Arrays.sort(tmp);
		for (int i = 0; i < 7; i++) {
			sb.append(tmp[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void check(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += tmp[i];
			}
			if(sum == 100) yes = true;
			return;
		}
		for(int i = start; i < 9; i++) {
			tmp[cnt] = dwarf[i];
			check(cnt+1, i+1);
			if(yes) break;
		}
	}
}
