package com.pttdv.st0717;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_G4_2580_스도쿠 {
	static List<int[]> zero;
	static int zerocnt;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] sudoku = new int[9][9];
		int[] num = new int[10];
		zero = new ArrayList<int[]>();
		Arrays.fill(num, 9);
		for (int i = 0; i < 9; i++) {
			String[] s = in.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(s[j]);
				if(sudoku[i][j] > 0) num[sudoku[i][j]]--;
				else zero.add(new int[] {i, j});
			}
		}
		zerocnt = zero.size();
		goSudoku(sudoku, num, 0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static boolean finish;
	private static void goSudoku(int[][] sdoku, int[] num, int idx) {
		if(idx == zerocnt) {
			finish = true;
			return;
		}
		
		int r = zero.get(idx)[0], c = zero.get(idx)[1];
		
		for (int k = 1; k <= 9; k++) {
			if(num[k] > 0) {
				sdoku[r][c] = k;
				if(check(sdoku, r, c)) {
					num[k]--;
					goSudoku(sdoku, num, idx+1);
					if(finish) return;
					else num[k]++;
				}
			}
		}
		sdoku[r][c] = 0;
	}
	private static boolean check(int[][] sudoku, int r, int c) {
		int[] checked = new int[10];
		
		for (int i = 0; i < 9; i++) {
			if(sudoku[i][c] > 0) {
				if(checked[sudoku[i][c]] == 0) checked[sudoku[i][c]]++;
				else return false;
			}
		}
		
		checked = new int[10];
		for (int i = 0; i < 9; i++) {
			if(sudoku[r][i] > 0) {
				if(checked[sudoku[r][i]] == 0) checked[sudoku[r][i]]++;
				else return false;
			}
		}
		
		checked = new int[10];
		for (int i = r - (r % 3); i < r - (r % 3)+3; i++) {
			for (int j = c - (c % 3); j < c - (c % 3)+3; j++) {
				if(sudoku[i][j] > 0) {
					if(checked[sudoku[i][j]] == 0) checked[sudoku[i][j]]++;
					else return false;
				}
			}
		}
		
		return true;
	}
}