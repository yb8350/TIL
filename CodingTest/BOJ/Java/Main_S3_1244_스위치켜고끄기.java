package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_1244_스위치켜고끄기 {
	static int[] toggle;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		toggle = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			toggle[i] = Integer.parseInt(st.nextToken());
		}
		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			String[] s = in.readLine().split(" ");
			if(Integer.parseInt(s[0]) == 1) {
				int t = Integer.parseInt(s[1]) - 1;
				for (int j = t; j < N; j+=t+1) {
					toggle[j] = toggle[j] == 0 ? 1 : 0;
				}
			}
			else {
				int t = Integer.parseInt(s[1]) - 1;
				toggle[t] = toggle[t] == 0 ? 1 : 0;
				for (int j = 1; t-j > -1 && t+j < N; j++) {
					if(toggle[t-j] == toggle[t+j]) {
						toggle[t-j] = toggle[t-j] == 0 ? 1 : 0;
						toggle[t+j] = toggle[t+j] == 0 ? 1 : 0;
					}
					else break;
				}
			}
		}

		for(int i=0; i<N; i++) {
			System.out.print(toggle[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
	}
}
