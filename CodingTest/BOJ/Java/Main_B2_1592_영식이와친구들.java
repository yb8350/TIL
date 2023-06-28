package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] seat = new int[N+1];
		int idx = 1;
		seat[idx] += 1;
		int cnt = 0;
		while(seat[idx] < M) {
			if(seat[idx] % 2 == 0) idx -= L;
			else idx += L;
			
			if(idx > N) idx -= N;
			else if(idx < 1) idx += N;
			
			seat[idx] += 1;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
