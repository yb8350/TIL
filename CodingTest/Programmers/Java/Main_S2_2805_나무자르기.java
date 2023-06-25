package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tree = new int[N];
		
		st = new StringTokenizer(in.readLine());
		int upper = 0;
		int lower = 0;
		
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			upper = upper < tree[i] ? tree[i] : upper;
		}

		while(lower < upper) {
			int height = (upper + lower) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if(tree[i] > height) 
					sum += tree[i] - height;
			}
			
			if(sum < M) upper = height;
			else lower = height+1;
		}
		
		System.out.println(lower - 1);
	}
}
