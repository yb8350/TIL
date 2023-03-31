package com.ssafy.st0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] girl = new int[6];
		int[] boy = new int[6];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			if(S == 0) girl[Y-1]++;
			else boy[Y-1]++;
		}
		int res = 0;
		for (int n : girl) {
			if(n == 0) continue;
			else if(n%K != 0) res+= n/K+1;
			else res+=n/K;
		}
		for (int n : boy) {
			if(n == 0) continue;
			else if(n%K != 0) res+= n/K+1;
			else res+=n/K;
		}
		System.out.println(res);
	}
}
