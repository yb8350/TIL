package com.ssafy.ws0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] field;
	static int h = 0;
	static int w = 0;

	static void control(char c) {
		char d = 0;
		int n = 0;
		if (c == 'S') {
			if (field[h][w] == '^')
				n = 0;
			else if (field[h][w] == 'v')
				n = 1;
			else if (field[h][w] == '<')
				n = 2;
			else if (field[h][w] == '>')
				n = 3;

			int sh = h;
			int sw = w;
			while (sh + dr[n] > -1 && sh + dr[n] < field.length && sw + dc[n] > -1 && sw + dc[n] < field[0].length) {
				if (field[sh + dr[n]][sw + dc[n]] == '*') {
					field[sh + dr[n]][sw + dc[n]] = '.';
					return;
				} else if (field[sh + dr[n]][sw + dc[n]] == '#')
					return;
				else {
					sh += dr[n];
					sw += dc[n];
				}
			}
			return;
		}

		if (c == 'U') {
			d = '^';
			n = 0;
		} else if (c == 'D') {
			d = 'v';
			n = 1;
		} else if (c == 'L') {
			d = '<';
			n = 2;
		} else if (c == 'R') {
			d = '>';
			n = 3;
		}

		field[h][w] = d;
		if (h + dr[n] > -1 && h + dr[n] < field.length && w + dc[n] > -1 && w + dc[n] < field[0].length) {
			if (field[h + dr[n]][w + dc[n]] == '.') {
				field[h][w] = '.';
				field[h + dr[n]][w + dc[n]] = d;
				h += dr[n];
				w += dc[n];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String s = in.readLine();
			int H = Integer.parseInt(s.split(" ")[0]);
			int W = Integer.parseInt(s.split(" ")[1]);
			field = new char[H][W];
			
			for (int i = 0; i < field.length; i++) {
				char[] input = in.readLine().toCharArray();
				for (int j = 0; j < field[0].length; j++) {
					field[i][j] = input[j];
					if (input[j] == '<' || input[j] == '>' || input[j] == '^' || input[j] == 'v') {
						h = i;
						w = j;
					}
				}
			}
			int cnt = Integer.parseInt(in.readLine());
			char[] ctrl = in.readLine().toCharArray();
			for (int i = 0; i < cnt; i++) {
				control(ctrl[i]);
			}

			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[0].length; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
