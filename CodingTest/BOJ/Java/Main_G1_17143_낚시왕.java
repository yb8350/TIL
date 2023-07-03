package com.pttdv.st0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main_G1_17143_낚시왕 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 입력 : 맵의 크기(R,C)와 상어 개수(M)
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] shark = new int[M+1][5]; // 전체 상어 목록(r,c,속력,이동방향,크기)
		int res = 0; // 낚시왕이 잡은 상어 크기의 합
		int fishing = -1; // 낚시왕이 다음에 잡을 상어의 index 저장
		
		// 입력 : 상어 목록 저장
		for (int i = 1; i < shark.length; i++) {
			shark[i] = Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(shark[i][1] == 1) { // 다음으로 잡을 상어 위치 미리 찾기
				if(fishing == -1) fishing = i;
				else if(shark[fishing][0] > shark[i][0]) fishing = i;
			}
		}

		int[] d = {0, -1, 1, 1, -1};
		
		// 풀이
		for (int i = 1; i <= C; i++) {			
			// 1. 잡을 수 있는 상어가 있다면 잡는다.
			if(fishing != -1) {
				res += shark[fishing][4];
				shark[fishing] = null;
			}
			fishing = -1;
			

			int[][] sea = new int[R+1][C+1];
			for (int j = 1; j < shark.length; j++) {
				if(shark[j] == null) continue;
				
				// 2. 상어의 위치를 이동한다.
				int N = 0;
				int n = 0;
				int dir = shark[j][3];
				
				// 이동하는 값 지정
				if(dir == 1 || dir == 2) {
					N = R;
					n = shark[j][0];
				}
				else {
					N = C;
					n = shark[j][1];
				}
				
				// (N * 2 - 2) 만큼 이동할 때마다 제자리에 돌아오므로, 나머지만큼만 이동하도록 계산
				int speed = shark[j][2] % (N * 2 - 2);
				
				// 이동하기 전, 주어진 길이를 벗어나지 않도록 방향을 조정한다.
				if(n == 1 && d[dir] == -1) {
					if(dir == 4) dir = 3;
					else if(dir == 1) dir = 2;
				}
				if(n == N && d[dir] == 1) {
					if(dir == 3) dir = 4;
					else if(dir == 2) dir = 1;
				}
				
				// 상어 이동
				while(speed > 0) {
					n += d[dir];
					if(n == 1) {
						dir = dir == 1 ? 2 : 3;
					}
					else if(n == N) {
						dir = dir == 2 ? 1 : 4;
					}
					speed--;
				}
				
				// 이동한 값을 저장
				shark[j][3] = dir;
				if(dir == 1 || dir == 2) shark[j][0] = n;
				else shark[j][1] = n;

				// 3. 다른 상어와 같은 칸에 있는지 판단한다.
				int idx = sea[shark[j][0]][shark[j][1]];
				if(idx > 0) {
					if(shark[j][4] > shark[idx][4]) {
						sea[shark[j][0]][shark[j][1]] = j;
						shark[idx] = null;
						if(idx == fishing) fishing = j;
					}
					else {
						shark[j] = null;
						continue;
					}
				}
				else sea[shark[j][0]][shark[j][1]] = j;
				
				// 4. 다음으로 잡힐 상어인지 판단한다.
				if(shark[j][1] == i+1) {
					if(fishing == -1) fishing = j;
					else if(shark[fishing][0] >= shark[j][0]) fishing = j;
				}
			}
		}

		System.out.println(res);
		
	}

//	private static int MoveShark(int speed, int N, int n, boolean pm) {
//		if(pm) return Math.abs(N - Math.abs(Math.abs(n + (speed % (N * 2 - 2))) - N));
//		return Math.abs(N - Math.abs(Math.abs(n - (speed % (N * 2 - 2)) - 2) - N));
//	}
//	
//	private static int DirShark(int speed, int N, int n, int dir) {
//		int[] d = {0, -1, 1, 1, -1};
//		speed %= N * 2 - 2;
//		
//		while(speed > 0) {
//			n += d[dir];
//			if(n == 1) {
//				dir = dir == 1 ? 2 : 3;
//			}
//			if(n == N) {
//				dir = dir == 2 ? 1 : 4;
//			}
//			speed--;
//		}
//		return dir;
//	}
}
