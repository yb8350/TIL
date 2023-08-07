package com.pttdv.st0810;
import java.util.*;
import java.io.*;
public class Main_S3_2579_계단오르기 { //11636kb	76ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[] num = new int[N+1];
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		// N이 1일 경우 예외 처리
		if(N == 1) {
			System.out.println(num[1]);
			return;
		}
		
		int[] dp = new int[N+1];

		dp[1] = num[1];
		dp[2] = num[1] + num[2];
		
		// 3번 연속은 안되기 때문에, 과거의 패턴은 직전에 2칸 뛰거나, 2칸 전에 2칸 뛰거나이다.(0->2->3 or 1->3)
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + num[i-1]) + num[i];
		}
		
		System.out.println(dp[N]);
	}
}
