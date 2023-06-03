package com.ssafy.st0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_G3_4577_소코반 { //11580kb	80ms
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Character, int[]> push = new HashMap<>();
		push.put('U', new int[] {-1, 0});
		push.put('D', new int[] {1, 0});
		push.put('L', new int[] {0, -1});
		push.put('R', new int[] {0, 1});
		int gameNum = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			char[][] map = new char[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = in.readLine().toCharArray();
			}
			char[] input = in.readLine().toCharArray();
			//풀이
			int[] player = new int[2];
			ArrayList<int[]> arr = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 'w' || map[i][j] == 'W') { //캐릭터 위치 저장
						player[0] = i;
						player[1] = j;
					}
					if(map[i][j] == '+' || map[i][j] == 'W' || map[i][j] == 'B') { //목표점 저장
						arr.add(new int[] {i, j});
					}
				}
			}
			
			boolean res = false;
			for(char i : input) { //방향키에 맞게 움직이는 반복문
				int r = 0;
				for(int[] a : arr) {
					if(map[a[0]][a[1]] == 'B') r++;
				}
				if(r == arr.size()) { //모든 목표점에 박스가 있으면 멈추기
					res = true;
					break;
				}
				
				int[] tmp = push.get(i);
				int dx = player[0] + tmp[0];
				int dy = player[1] + tmp[1];
				
				switch(map[dx][dy]) {
				case '.':
				case '+': //다음 칸이 빈칸인 경우
					map[player[0]][player[1]] = map[player[0]][player[1]] == 'W' ? '+' : '.';
					map[dx][dy] = map[dx][dy] == '+' ? 'W' : 'w';
					player[0] = dx;
					player[1] = dy;
					break;
				case 'b':
				case 'B': //다음 칸이 박스인 경우
					if(map[dx + tmp[0]][dy + tmp[1]] == '.') { //박스가 이동할 칸이 빈칸인 경우
						map[player[0]][player[1]] = map[player[0]][player[1]] == 'W' ? '+' : '.';
						map[dx][dy] = map[dx][dy] == 'B' ? 'W' : 'w';
						map[dx + tmp[0]][dy + tmp[1]] = 'b';
						player[0] = dx;
						player[1] = dy;
					} else if(map[dx + tmp[0]][dy + tmp[1]] == '+') { //박스가 이동할 칸이 목표점인 경우
						map[player[0]][player[1]] = map[player[0]][player[1]] == 'W' ? '+' : '.';
						map[dx][dy] = map[dx][dy] == 'B' ? 'W' : 'w';
						map[dx + tmp[0]][dy + tmp[1]] = 'B';
						player[0] = dx;
						player[1] = dy;
					}
					break;
				default:
					break;
				}
			}
			
			int r = 0;
			for(int[] a : arr) {
				if(map[a[0]][a[1]] == 'B') r++;
			}
			if(r == arr.size()) res = true; //모든 목표점에 박스가 있는지 확인
			
			//출력
			sb.append("Game ").append(gameNum++).append(": ").append(res ? "complete" : "incomplete").append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
