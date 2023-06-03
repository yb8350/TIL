package com.ssafy.st0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2559_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int[] tem = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			tem[i] = Integer.parseInt(st.nextToken());
		}
		//풀이
		//배열의 현재 위치부터 K번째를 더한 위치까지 값을 더한 후,
		//더한 값이 최댓값일 경우 max에 대입
		//음수가 나올 수 있기 때문에 max초기값은 Integer.MIN_VALUE로 설정
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i <= N - K; i++) {
			int sum = 0;
			for (int j = i; j < i + K; j++) {
				sum += tem[j];
			}
			if(max < sum) max = sum;
		}
		
		//출력
		System.out.println(max);
	}
}
