package com.pttdv.st0804;
import java.util.*;
import java.io.*;
public class Main_G3_10986_나머지합 { // 	168108kb	464ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] S = new long[N+1];
		long[] cnt = new long[M];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = (S[i-1] + Integer.parseInt(st.nextToken())) % M;
			cnt[(int)S[i]]++;
		}
		
		long res = (int)cnt[0];
		for(int i = 0; i < M; i++) {
			if(cnt[i] > 1) {
				res += cnt[i] * (cnt[i] - 1) / 2;
			}
		}
		System.out.println(res);
	}
}
