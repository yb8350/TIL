package com.ssafy.st0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_1904_01타일 { //19596kb	108ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		long[] tile = new long[N+1];
		tile[1] = 1;
		if(N >= 2) tile[2] = 2;
		if(N > 2) {
			for (int i = 3; i <= N; i++) {
				tile[i] = (tile[i-1] + tile[i-2]) % 15746; //피보나치 수열
			}
		}
		System.out.println(tile[N]);
	}
}