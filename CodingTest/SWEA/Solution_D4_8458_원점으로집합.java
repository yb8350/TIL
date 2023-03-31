package com.ssafy.ws0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_8458_원점으로집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			int cnt = -1;
			int[] res = new int[N];
			Arrays.fill(res, -1);
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
	
				Queue<int[]> q = new LinkedList<int[]>();
				q.offer(new int[] {x, y, 0});
				while(!q.isEmpty()) {
					int[] tmp = q.poll();
					if(tmp[0] == 0 && tmp[1] == 0) {
						res[i] = tmp[2];
						break;
					}
					for (int j = 0; j < 4; j++) {
						int dx = tmp[0] + (dr[j] * (tmp[2] + 1));
						int dy = tmp[1] + (dc[j] * (tmp[2] + 1));
						q.offer(new int[] {dx, dy, tmp[2]+1});
					}
				}
			}
			
			for(int r : res) {
				cnt = Math.max(r, cnt);
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
