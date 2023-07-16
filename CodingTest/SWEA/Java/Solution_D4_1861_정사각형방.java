package com.ssafy.ws0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {
	public static void main(String[] args) throws IOException {
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(in.readLine());
            int[][] arr = new int[N+2][N+2];
            for (int i = 0; i < N; i++) {
            	StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            int max = 1;
            int room = N + 1;
            for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int mode = 0;
					int r = i;
					int c = j;
					int cnt = 1;
					while(mode != 4) {
						if(r+dr[mode] > -1 && r+dr[mode] < N && c+dc[mode] > -1 && c+dc[mode] < N) {
							if(arr[r][c] + 1 == arr[r+dr[mode]][c+dc[mode]]) {
								r+=dr[mode];
								c+=dc[mode];
								mode = 0;
								cnt++;
							}
							else mode++;
						}
						else mode++;
					}
					if(max < cnt) {
						max = cnt;
						room = arr[i][j];
					}
					else if (max == cnt) {
						room = arr[i][j] < room ? arr[i][j] : room;
					}
				}
			}
            sb.append(room).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
	}
}
