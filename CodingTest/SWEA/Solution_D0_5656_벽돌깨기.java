package com.ssafy.ws0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D0_5656_벽돌깨기 {
	static int[][] block;
	static int N, W, H, min;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			block = new int[H][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					block[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, block);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int cnt, int[][] nblock) {
		if(cnt == N) {
			int res = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(nblock[i][j] > 0) res++;
				}
			}
			min = Math.min(res, min);
			return;
		}
		
		for (int ball = 0; ball < W; ball++) {
			
			// 0. 블럭 복사
			int[][] tmpblock = new int[H][W];
			for (int j = 0; j < H; j++) {
				tmpblock[j] = Arrays.copyOf(nblock[j], W);
			}
			
			// 1. 블럭제거
			for (int i = 0; i < H; i++) {
				if(tmpblock[i][ball] > 0) {
					breakBlock(i, ball, tmpblock[i][ball], tmpblock);
					break;
				}
			}
			
			// 2. 블럭정리
			for (int i = 0; i < W; i++) {
				Queue<Integer> q = new LinkedList<Integer>();
				for (int j = H-1; j > -1; j--) {
					if(tmpblock[j][i] > 0) {
						q.offer(tmpblock[j][i]);
						tmpblock[j][i] = 0;
					}
				}
				int th = H -1;
				while(!q.isEmpty()) {
					tmpblock[th--][i] = q.poll();
				}
			}
			
			// 3. 다음 공 던지러 가기
			dfs(cnt+1, tmpblock);
		}
	}
	
	private static void breakBlock(int r, int c, int n, int[][] tmpblock) {
		if(n < 2) {
			tmpblock[r][c] = 0;
			return;
		}
		
		for (int j = 0; j < 4; j++) {
			int dx = r;
			int dy = c;
			for (int k = 0; k < n-1; k++) {
				dx += dr[j];
				dy += dc[j];
				if(dx > -1 && dx < H && dy > -1 && dy < W) {
					tmpblock[r][c] = 0;
					breakBlock(dx, dy, tmpblock[dx][dy], tmpblock);
				}
			}
		}
		
	}
}
