package com.ssafy.ws0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		
		while(N % 5 != 0) {
			N -= 3;
			cnt++;
			if(N == 0) break;
			else if(N < 3) cnt = -1;
		}
		
		if(cnt < 0 || N == 0) System.out.println(cnt);
		else System.out.println(cnt + (N / 5));
		
	}
}