package com.ssafy.ws0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {
	static int cnt, N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			cnt = 0;
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			do {
				check(0, 0, 0);
			}while(np());
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		
	}
	
	private static void check(int r, int l, int idx) {
		if(idx == N) {
			cnt++;
			return;
		}
		
		r += arr[idx];
		if(r<=l) check(r, l, idx+1);
		r -= arr[idx];
		l += arr[idx];
		if(r<=l) check(r, l, idx+1);
		l -= arr[idx];
	}



	private static boolean np() {
		int N = arr.length;
		
		int i = N - 1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(arr[i-1] >= arr[j]) j--;
		
		swap(i-1, j);
		
		int k = N - 1;
		while(i < k) swap(i++, k--);
		return true;
	}
	
	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
}