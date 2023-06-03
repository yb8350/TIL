package com.ssafy.hw0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] paper = new boolean[100][100];
		int N = Integer.parseInt(in.readLine());
		for (int cnt = 0; cnt < N; cnt++) {
			String[] s = in.readLine().split(" ");
			int x = Integer.parseInt(s[0])-1;
			int y = Integer.parseInt(s[1])-1;
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {
					paper[i][j] = true;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if(paper[i][j]) res++;
			}
		}
		System.out.println(res);
	}
}
