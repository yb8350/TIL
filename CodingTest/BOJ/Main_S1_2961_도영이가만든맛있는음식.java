package com.ssafy.ws0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_2961_도영이가만든맛있는음식 {
	static int N, res = Integer.MAX_VALUE;
	static int[] sour, bitter;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		sour = new int[N];
		bitter = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			String[] s = in.readLine().split(" ");
			sour[i] = Integer.parseInt(s[0]);
			bitter[i] = Integer.parseInt(s[1]);
		}

		subset(0);

		System.out.println(res);
	}

	public static void subset(int cnt) {
		if(cnt == N) {
			int s = 1;
			int b = 0;
			int c = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					s *= sour[i];
					b += bitter[i];
					c++;
				}
				if(c != 0 && Math.abs(s-b) < res) res = Math.abs(s-b);
			}
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}
}
