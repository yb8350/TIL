package com.ssafy.ws0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G2_3109_빵집 {
	static int R, C, cnt;
	static boolean check;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			map[i][0] = '-';
			pipe(i, 1);
			check = false;
		}
		System.out.println(cnt);
	}
	private static void pipe(int x, int y) {
		if(y == C - 1) {
			cnt++;
			check = true;
			return;
		}
		for(int i = x - 1; i <= x + 1; i++) {
			if(i > -1 && i < R) {
				if(map[i][y] == '.') {
					map[i][y] = '-';
					pipe(i, y+1);
					if(check) return;
				} 
			}
		}
	}
}

