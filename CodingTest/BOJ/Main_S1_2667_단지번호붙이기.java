package com.ssafy.st0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_2667_단지번호붙이기 { //11656kb	84ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		//풀이
		int cnt = 0; //마을 개수 카운트
		ArrayList<Integer> arr = new ArrayList<>(); //마을 별 집 개수 저장하는 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '1') { //집을 발견했을 경우
					map[i][j] = '0'; //현재 위치 0으로 변환
					int c = 1; //현재 위치까지 포함해서 집 개수 세는 변수
					//bfs
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i, j});
					while(!q.isEmpty()) {
						int[] t = q.poll();
						
						for (int k = 0; k < 4; k++) {
							int dx = t[0]+ dr[k];
							int dy = t[1] + dc[k];
							if(dx > -1 && dx < N && dy > -1 && dy < N && map[dx][dy] == '1' ) {
								map[dx][dy] = '0';
								q.offer(new int[] {dx, dy});
								c++;
							}
						}
					}
					arr.add(c); //집 개수 배열에 추가
					cnt++; //마을 개수 추가
				}
			}
		}
		Collections.sort(arr); //정렬
		sb.append(cnt).append("\n");
		for(int a : arr) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}
}
