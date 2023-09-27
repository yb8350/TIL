package com.pttdv.st1006;
import java.util.*;
import java.io.*;
public class Main_S1_14888_연산자끼워넣기 { // 15656kb	96ms
	static int[] numbers;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		
		// 입력: 숫자 목록
		numbers = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 입력: 부호 별 개수(+, -, *, / 순)
		int[] signs = new int[4];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			signs[i] = Integer.parseInt(st.nextToken());
		}
		
		// 재귀를 이용하여 가능한 모든 식을 만든 후 max, min 값 찾기
		dfs(signs, numbers[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int[] signs, int num, int cnt) {
		// 식이 완성되었을 경우, max와 min 값 찾기
		if(N == cnt) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		// 부호 배열 복사
		int[] tmp = Arrays.copyOf(signs, 4);
		
		// 부호별 재귀
		for (int i = 0; i < 4; i++) {
			if(tmp[i] > 0) {
				tmp[i]--;
				if(i == 0) dfs(tmp, num + numbers[cnt], cnt + 1);
				else if(i == 1) dfs(tmp, num - numbers[cnt], cnt + 1);
				else if(i == 2) dfs(tmp, num * numbers[cnt], cnt + 1);
				else if(i == 3) dfs(tmp, num > 0 ? num / numbers[cnt] : (Math.abs(num) / numbers[cnt]) * -1, cnt + 1);
				tmp[i]++;
			}
		}
	}
}
