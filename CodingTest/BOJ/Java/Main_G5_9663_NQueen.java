package com.ssafy.st0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_9663_NQueen { //12168kb	5632ms
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		arr = new int[N];
		
		//풀이
		queen(0);
		System.out.println(cnt);
	}
	
	private static void queen(int lv) {
		int N = arr.length;
		if(lv == N) { //모든 퀸을 다 놓았을 경우
			cnt++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[lv] = i; //현재 라인에 퀸 놓기
			if(check(lv)) { //퀸을 놓을 수 있다면
				queen(lv+1); //재귀를 통해 다음 퀸을 놓으러 간다.
			}
		}
	}
	
	private static boolean check(int lv) {
		for (int i = 0; i < lv; i++) {
			if(arr[lv] == arr[i]) return false; //지금까지 놓은 퀸과 같은 행일 경우
			else if(Math.abs(lv - i) == Math.abs(arr[lv] - arr[i])) return false; //대각선일 경우
		}
		return true;
	}
}

//충격적인 풀이방식...
//int[] arr = { 0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596 };
//System.out.print(arr[n]);