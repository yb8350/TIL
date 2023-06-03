package com.ssafy.st0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_17136_색종이붙이기 { //16708kb	204ms
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] paper = new int[10][10];
		int[] limit = new int[] {0, 5, 5, 5, 5, 5};
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//풀이 - dfs : 현재 칸이 1일 경우 5개의 종이를 내림차순으로 대보기
		colorpaper(0, 0, paper, 0, limit);
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}

	private static void colorpaper(int r, int c, int[][] paper, int cnt, int[] limit) {
		if(r >= 9 && c > 9) { //마지막 칸까지 왔으면 종료
			res = Math.min(cnt, res);
			return;
		}
		
		if(res <= cnt) return; //가지치기 : 현재까지 찾은 최솟값이 사용한 종이 수보다 많으면 종료
		
		if(c > 9) {
			r += 1;
			c = 0;
		}
		
		if(paper[r][c] == 1) {
			//사이즈 별로 색종이 대보기
			for (int size = 5; size > 0; size--) {
				boolean cp = true;
				loop:
					for (int i = r; i < r + size; i++) {
						for (int j = c; j < c + size; j++) {
							if(i < 0 || i >= 10 || j < 0 || j >= 10 || paper[i][j] == 0) {
								cp = false;
								break loop;
							}
						}
					}
				
				//색종이를 놓을 수 있고 그 크기의 색종이가 남아있다면
				if(cp && limit[size] > 0) {
					//종이 놓아보기
					for (int k = r; k < r + size; k++) {
						for (int l = c; l < c + size; l++) {
							paper[k][l] = 0;
						}
					}
					limit[size]--;
					colorpaper(r, c + 1, paper, cnt+1, limit); //다음 칸으로 이동
					//다시 종이 치우기
					limit[size]++;
					for (int k = r; k < r + size; k++) {
						for (int l = c; l < c + size; l++) {
							paper[k][l] = 1;
						}
					}
				}
			}
		}
		else colorpaper(r, c + 1, paper, cnt, limit);
	}
}
