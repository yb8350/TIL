package com.ssafy.st0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_14889_스타트와링크 { //37608kb	392ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//풀이 : 넥퍼 조합 사용
		int[] input = new int[N];
		for (int i = N - 1; i > N / 2 - 1; i--) {
			input[i] = 1;
		}
		int min = Integer.MAX_VALUE;
		do {
			int[] s1 = new int[N / 2], s2 = new int[N / 2];
			int s1cnt = 0, s2cnt = 0;
			int start = 0, link = 0;
			for (int i = 0; i < input.length; i++) {
				if (input[i] == 1) //조합에 포함되면
					s1[s1cnt++] = i; //1팀에 추가
				else if (input[i] == 0) //조합에 포함되지 않으면
					s2[s2cnt++] = i; //2팀에 추가
			}
			for (int i = 0; i < s1.length - 1; i++) { 
				for (int j = i + 1; j < s1.length; j++) {
					start += map[s1[i]][s1[j]] + map[s1[j]][s1[i]]; //start팀의 능력치 더하기
				}
			}
			for (int i = 0; i < s2.length - 1; i++) {
				for (int j = i + 1; j < s2.length; j++) {
					link += map[s2[i]][s2[j]] + map[s2[j]][s2[i]]; //link팀의 능력치 더하기
				}
			}
			int r = Math.abs(start - link);
			if (min > r) min = r; //둘의 차이가 최소면 min에 대입
		} while (np(input));

		System.out.println(min);
	}

	private static boolean np(int[] input) {
		int N = input.length;

		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (input[i - 1] >= input[j])
			j--;

		swap(input, i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(input, i++, k--);

		return true;
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
