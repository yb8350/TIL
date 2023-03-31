package com.ssafy.st0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_17281_야구 { //16412kb	372ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[][] baseball = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				baseball[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//풀이 : 넥퍼 순열
		int res = 0;
		int[] tmp = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }; //순서
		do {
			int order[] = new int[9];
			order[3] = 0; //첫번째 선수를 4번타자로 지정
			for (int j = 0, k = 0; j < 9; j++) {
				if (j != 3) order[j] = tmp[k++]; // 나머지 선수 배치
			}
			res = Math.max(play(baseball, order), res); //경기를 통해 최댓값 찾기
		} while (np(tmp)); //넥퍼
		
		System.out.println(res);
	}


	private static int play(int[][] baseball, int[] order) {
		int N = baseball.length;
		int idx = 0, res = 0;
		for (int i = 0; i < N; i++) {
			int p1 = 0, p2 = 0, p3 = 0, h = 0, out = 0;
			while (out < 3) {
				if (idx == 9) // 한바퀴 돌면 다시 처음으로
					idx = 0;
				switch (baseball[i][order[idx++]]) {
				case 0: // 아웃
					out++;
					break;
				case 1: // 안타
					h = p3;p3 = 0;
					p3 = p2;p2 = 0;
					p2 = p1;p1 = 1;
					break;
				case 2: // 2루타
					h += p3;p3 = 0;
					h += p2;p2 = 1;
					p3 = p1;p1 = 0;
					break;
				case 3: // 3루타
					h += p3;p3 = 1;
					h += p2;p2 = 0;
					h += p1;p1 = 0;
					break;
				case 4: // 홈런
					h += p3;p3 = 0;
					h += p2;p2 = 0;
					h += p1;p1 = 0;
					h += 1;
					break;
				}
				res += h;
				h = 0;
			}
		}
		return res;
	}
	
	//넥퍼
	private static boolean np(int[] arr) {
		int N = 8;

		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			j--;

		swap(arr, i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(arr, i++, k--);
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
