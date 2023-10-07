package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_G4_3190_뱀 { // 12412kb	96ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 빈 칸: 0, 뱀: 1, 사과: 2
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력: 맵 크기
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		
		// 입력: 사과 정보
		int K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 2;
		}
		
		// 입력: 이동 정보
		int L = Integer.parseInt(in.readLine());
		Queue<String[]> move = new LinkedList<String[]>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String X = st.nextToken();
			String C = st.nextToken();
			move.add(new String[] {X, C});
		}
		
		int r = 0; // 뱀 머리 행
		int c = 0; // 뱀 머리 열
		int len = 1; // 뱀 길이
		int dir = 1; // 뱀 방향(0: 상, 1: 우, 2: 하, 3: 좌) 
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		Queue<int[]> snake = new LinkedList<int[]>();
		snake.add(new int[] {r, c});
		map[r][c] = 1;
		int time = 1;
		
		while(true) {
			int dx = r + dr[dir];
			int dy = c + dc[dir];
			
			// 게임 종료 조건: 이동할 머리 위치가 벽이거나 뱀의 몸일 경우
			if(dx < 0 || dx >= N || dy < 0 || dy >= N || map[dx][dy] == 1) {
				break;
			}
			
			// 사과를 먹지 않았다면, 꼬리를 지워준다.
			if(map[dx][dy] != 2) {
				int[] tmp = snake.poll();
				map[tmp[0]][tmp[1]] = 0;
			}
			
			// 머리 위치 추가
			map[dx][dy] = 1;
			snake.add(new int[] {dx, dy});
			r = dx;
			c = dy;
			
			// 방향 전환
			if(!move.isEmpty() && time == Integer.parseInt(move.peek()[0])) {
				String[] tmp = move.poll();
				if(tmp[1].equals("L")) {
					dir = dir - 1 < 0 ? 3 : dir - 1;
				}
				else {
					dir = dir + 1 > 3 ? 0 : dir + 1;
				}
			}
			
			time++;
		}
		
		System.out.println(time);
	}
}
