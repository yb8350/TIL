package com.pttdv.st0711;
import java.util.*;
import java.io.*;
public class Main_S2_1912_연속합 { //21652kb	184ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력 : 정수의 개수
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// 입력 : 정수 목록
		st = new StringTokenizer(in.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 풀이
		int max = arr[0]; // 연속합의 최댓값
		int now = arr[0]; // 현재 상황에서의 최댓값
		for (int i = 1; i < N; i++) {
			now = Math.max(now + arr[i], arr[i]); // 현재에 다음 수를 더한 값과 다음 수 중에 큰 수를 찾는다.
			max = Math.max(max, now); // 현재까지의 최댓값과 방금 찾은 최댓값을 비교하여 저장한다.
		}
		
		System.out.println(max);
	}
}
