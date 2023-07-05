package com.pttdv.st0711;
import java.util.*;
import java.io.*;
public class Main_S4_1388_바닥장식 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 입력 : 세로 길이, 가로 길이
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 입력 : 전체 바닥
		int[][] floor = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmp = in.readLine().split("");
			for (int j = 0; j < M; j++) {
				if(tmp[j].equals("-") ) {
					floor[i][j] = 1;
				}
				else floor[i][j] = 2;
			}
		}
		
		// 풀이
		boolean[][] visited = new boolean[N][M];
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) { // 방문되지 않은 바닥인 경우
					visited[i][j] = true;
					if(floor[i][j] == 1) { // 가로 모양 판자일 경우
						int tmp = j+1;
						while(tmp < M && floor[i][tmp] == 1) { // 하나씩 증가하며 다음 타일이 같은 모양인지 체크
							visited[i][tmp++] = true;
						}
					}
					else if(floor[i][j] == 2) { // 세로 모양 판자일 경우
						int tmp = i+1;
						while(tmp < N && floor[tmp][j] == 2) {
							visited[tmp++][j] = true;
						}
					}
					res++;
				}
			}
		}
		
		System.out.println(res);
		
	}
}
