package com.ssafy.ws0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D0_4013_특이한자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] c = {-1, 1}; //자석의 앞뒤를 확인하기 위한 배열
		int[][] d = {{6,2},{2,6}}; //자석의 앞뒤에 따라 확인해야 하는 번호를 저장한 배열 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int K = Integer.parseInt(in.readLine());
			int[][] mag = new int[5][8];
			for (int i = 1; i <= 4; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//풀이
			for (int k = 0; k < K; k++) {
				//0. 회전할 자석과 회전 방향을 입력
				StringTokenizer st = new StringTokenizer(in.readLine());
				int N = Integer.parseInt(st.nextToken());
				int D = Integer.parseInt(st.nextToken());
				
				//1. 회전하는 자석 정보를 체크한 후 저장
				boolean[] visited = new boolean[5];
				int[][] r = new int[5][2]; //자석 별 회전 정보 저장
				r[N][0] = 1;
				r[N][1] = D;
				visited[N] = true;
				Queue<int[]> q = new LinkedList<>();
				q.offer(new int[] {N, D});
				while(!q.isEmpty()) {
					int[] tmp = q.poll();
					for (int i = 0; i < 2; i++) { //현재 자석의 양 옆을 확인
						int t = tmp[0] + c[i];
						if(t > 0 && t <= 4 && !visited[t]) { //범위 안의 체크하지 않은 자석이라면
							visited[t] = true; //방문 체크
							if(mag[tmp[0]][d[i][0]] != mag[t][d[i][1]]) { //맞닿은 부분이 서로 다른 극이라면
								r[t][0] = 1; //회전해야한다.
								r[t][1] = tmp[1] == 1 ? -1 : 1; //회전 방향을 저장
								q.offer(new int[] {t, r[t][1]}); //큐에 저장하여 다음 자석도 회전하는지 체크
							}
						}
					}
				}
				
				//2. 자석을 회전
				for (int i = 1; i <= 4; i++) {
					if(r[i][0] == 1) mag[i] = rotate(mag[i], r[i][1]);
				}
			}
			
			//3. 최종 점수를 계산
			int res = 0;
			for (int i = 1; i <= 4; i++) {
				if(mag[i][0] == 1) res += Math.pow(2, i-1);
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static int[] rotate(int[] m, int i) {
		if(i == 1) { //시계방향
			int tmp = m[7];
			for (int j = 6; j >= 0; j--) {
				m[j+1] = m[j];
			}
			m[0] = tmp;
			return m;
		} else { //반시계방향
			int tmp = m[0];
			for (int j = 1; j < 8; j++) {
				m[j-1] = m[j];
			}
			m[7] = tmp;
			return m;
		}
	}
}
