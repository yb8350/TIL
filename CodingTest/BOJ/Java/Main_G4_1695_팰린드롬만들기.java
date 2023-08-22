package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_G4_1695_팰린드롬만들기 {
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		arr = new int[N];
		dp = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(MinValue(0, N-1));
	}

	private static int MinValue(int left, int right) {
		if(left > right) {
			return 0;
		}
		
		if(dp[left][right]!=-1) {
			return dp[left][right];
		}
        	
		int min = Integer.MAX_VALUE;
		
		if(arr[left] == arr[right]) {
			min = MinValue(left+1, right-1);
		}
		else {
			min = Math.min(MinValue(left+1, right)+1, MinValue(left, right-1)+1);
		}
		
		
		return dp[left][right] = min;
	}
}
