package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B3_2562_최댓값 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max=0;
		int idx=0;
		for (int i = 0; i < 9; i++) {
			int N = Integer.parseInt(in.readLine());
			if(max < N) {
				max = N;
				idx = i+1;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}
