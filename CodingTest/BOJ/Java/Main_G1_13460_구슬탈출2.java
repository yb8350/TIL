package com.ssafy.st0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G1_13460_구슬탈출2 { //79168kb	212ms
	static int res = 11;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int[] red = new int[2];
		int[] blue = new int[2];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'R') { //빨간 공 찾은 후, 맵에서 지우기
					red[0] = i;
					red[1] = j;
					map[i][j] = '.';
				} else if(map[i][j] == 'B') { //파란 공 찾은 후, 맵에서 지우기
					blue[0] = i;
					blue[1] = j;
					map[i][j] = '.';
				}
			}
		}
		
		
		
		//풀이
		play(map, red, blue, 1);
		System.out.println(res == 11 ? -1 : res);
	}

	private static void play(char[][] map, int[] red, int[] blue, int cnt) {
		if(cnt == 11) return; //종료조건
		if(res <= cnt) return; //가지치기
		
		for (int i = 0; i < 4; i++) {
			int rx = red[0] + dr[i];
			int ry = red[1] + dc[i];
			int bx = blue[0] + dr[i];
			int by = blue[1] + dc[i];
			int success = 0;
			boolean rt = false, bt = false;
			
			while(true) { //red
				if(rx == blue[0] && ry == blue[1]) rt = true; //파란공을 지나쳤으면 체크
				if(map[rx][ry] == '.') { //빈칸이면 다음칸 체크
					rx += dr[i];
					ry += dc[i];
				} else if(map[rx][ry] == 'O') { //도착점이면 성공 체크 후 반복 중지
					success = 1;
					break;
				} else break; //그 외의 상황(벽)이면 반복중지
				
			}
			
			while(true) { //blue
				if(bx == red[0] && by == red[1]) bt = true;
				if(map[bx][by] == '.') {
					bx += dr[i];
					by += dc[i];
				} else if(map[bx][by] == 'O') {
					success = -1;
					break;
				} else break;
			}
			
			if(success == 1) { //빨간공만 넣었으면
				res = Math.min(cnt, res); //결과에 저장
			} else if(success == 0) {
				//빨간공이 파란공을 지나쳤으면 현재 빨간공 위치에서 하나 더 전의 값을 보내준다.
				if(rt) play(map, new int[] {rx-dr[i]-dr[i], ry-dc[i]-dc[i]}, new int[] {bx-dr[i], by-dc[i]}, cnt+1);  
				//파란공이 빨간공을 지나쳤으면 현재 파란공 위치에서 하나 더 전의 값을 보내준다.
				else if(bt) play(map, new int[] {rx-dr[i], ry-dc[i]}, new int[] {bx-dr[i]-dr[i], by-dc[i]-dc[i]}, cnt+1);
				//둘 다 지나치지 않았을 경우
				else play(map, new int[] {rx-dr[i], ry-dc[i]}, new int[] {bx-dr[i], by-dc[i]}, cnt+1);
			}
		}
	}
}
