package com.ssafy.st0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2630_색종이만들기 { //13276kb	120ms
	static int[] res = new int[2];
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
		cut(map,0, 0, N);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	
	private static void cut(int[][] map, int sx, int sy, int N) {
		int color = map[sx][sy]; //시작점의 색 저장
		if(N == 1) {
			res[color]++;
			return;
		}
		for (int i = sx; i < sx+N; i++) {
			for (int j = sy; j < sy+N; j++) {
				if(map[i][j] != color) { //색이 다르면 4등분으로 나눠 탐색
					cut(map, sx, sy, N/2);
					cut(map, sx+(N/2), sy, N/2);
					cut(map, sx, sy+(N/2), N/2);
					cut(map, sx+(N/2), sy+(N/2), N/2);
					return;
				}
			}
		}
		res[color]++;
	}
}
