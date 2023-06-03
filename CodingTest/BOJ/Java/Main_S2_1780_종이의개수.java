package com.ssafy.st0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1780_종이의개수 { //318648kb	860ms
	static int[] res = new int[3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//풀이
		cut(map, 0, 0, N);
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(res[2]);
	}
	
	private static void cut(int[][] map, int sx, int sy, int N) {
		int num = map[sx][sy]; //시작점의 숫자 저장
		if(N == 1) {
			res[num+1]++;
			return;
		}
		for (int i = sx; i < sx+N; i++) {
			for (int j = sy; j < sy+N; j++) {
				if(map[i][j] != num) { //9등분으로 나눠 분할정복
					int n = N / 3;
					cut(map, sx, sy, n);
					cut(map, sx+n, sy, n);
					cut(map, sx+n+n, sy, n);
					cut(map, sx, sy+n, n);
					cut(map, sx+n, sy+n, n);
					cut(map, sx+n+n, sy+n, n);
					cut(map, sx, sy+n+n, n);
					cut(map, sx+n, sy+n+n, n);
					cut(map, sx+n+n, sy+n+n, n);
					return;
				}
			}
		}
		res[num+1]++;
	}
}
