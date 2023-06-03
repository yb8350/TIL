package com.ssafy.st0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G4_11559_PuyoPuyo { //11584kb	80ms
	public static void main(String[] args) throws IOException {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[][] py = new char[12][6];
		for (int i = 0; i < 12; i++) {
			py[i] = in.readLine().toCharArray();
		}

		// 풀이
		// 1. 모든 칸에 대하여 점(빈칸)이 아닐 경우,
		// 2. bfs를 이용해서 주변의 뿌요를 탐색.
		// 3. 4개 이상의 뿌요를 발견했다면 전부 터뜨린다.
		// 4. 한 번이라도 터뜨렸다면, 모든 뿌요에 중력을 적용한 후 위 과정을 반복.
		
		int res = 0;
		
		do {
			boolean[][] visited = new boolean[12][6];
			boolean stop = true;	
// 1번
			for (int i = 11; i > -1; i--) { //모든 칸을 탐색
				for (int j = 0; j < 6; j++) {
					if (py[i][j] != '.' && !visited[i][j]) { //방문하지 않은 칸이 뿌요라면
// 2번
						ArrayList<int[]> list = new ArrayList<>(); //같은 색의 뿌요를 저장할 리스트
						Queue<int[]> q = new LinkedList<int[]>();
						q.offer(new int[] { i, j }); //현재 위치를 큐에 추가
						while (!q.isEmpty()) {
							int[] tmp = q.poll();
							for (int k = 0; k < 4; k++) {
								int dx = tmp[0] + dr[k];
								int dy = tmp[1] + dc[k];
								//범위 내의 방문한 적 없는 같은 색의 뿌요를 만나면,
								if (dx > -1 && dx < 12 && dy > -1 && dy < 6 && !visited[dx][dy]
										&& py[tmp[0]][tmp[1]] == py[dx][dy]) {
									q.offer(new int[] { dx, dy }); //큐에 추가
									visited[dx][dy] = true; //방문 처리
									list.add(new int[] { dx, dy }); //리스트에 추가
								}
							}
						}
// 3번
						if (list.size() >= 4) { //리스트에 추가된 뿌요가 4개 이상이라면
							for (int[] li : list) {
								py[li[0]][li[1]] = '.'; //모두 터뜨려준다.
							}
							stop = false; //한 번이라도 터졌음을 체크
						}
					}
				}
			}
// 4번
			if (stop) break;
			res++; //연쇄 증가
			for (int j = 0; j < 6; j++) { //모든 뿌요 아래로 내려주기
				Queue<Character> q = new LinkedList<>();
				for (int i = 11; i > -1; i--) { //세로 라인의 뿌요 찾아서 저장
					if (py[i][j] != '.') {
						q.offer(py[i][j]);
						py[i][j] = '.';
					}
				}
				int cnt = 11;
				for (char c : q) { //아래부터 뿌요 채워주기
					py[cnt--][j] = c;
				}
			}
		} while (true);
		System.out.println(res);
	}
}
