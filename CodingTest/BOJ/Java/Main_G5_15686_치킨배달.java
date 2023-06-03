package com.ssafy.ws0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_G5_15686_치킨배달 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<int[]> house = new ArrayList<>();
		ArrayList<int[]> chicken = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if(t == 1) house.add(new int[] {i, j});
				if(t == 2) chicken.add(new int[] {i, j});
			}
		}
		
		int[] jh = new int[chicken.size()];
		for (int i = jh.length - 1; i >= jh.length - M; i--) {
			jh[i] = 1;
		}
		int min = Integer.MAX_VALUE;
		do {
			int[] hc = new int[house.size()];
			for (int i = 0; i < hc.length; i++) {
				hc[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < jh.length; i++) {
				if(jh[i] == 1) {
					int[] c = chicken.get(i);
					for (int j = 0; j < house.size(); j++) {
						int[] h = house.get(j);
						int t = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
						if(hc[j] > t) hc[j] = t;
					}
				}
			}
			int tmp = 0;
			for (int i = 0; i < hc.length; i++) {
				tmp += hc[i];
			}
			if(min > tmp) min = tmp;
		}while(np(jh));
		System.out.println(min);
	}

	private static boolean np(int[] jh) {
		int N = jh.length;
		
		int i = N -1;
		while(i > 0 && jh[i-1] >= jh[i]) i--;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(jh[i-1] >= jh[j]) j--;
		
		swap(jh, i-1, j);

		int k = N - 1;
		while(i < k) swap(jh, i++, k--);
		
		return true;
	}

	private static void swap(int[] jh, int i, int j) {
		int tmp = jh[i];
		jh[i] = jh[j];
		jh[j] = tmp;
		
	}
}
