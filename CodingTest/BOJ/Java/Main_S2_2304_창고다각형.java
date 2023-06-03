package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S2_2304_창고다각형 {
	static class Column implements Comparable<Column>{
		int start;
		int height;
		public Column(int start, int height) {
			super();
			this.start = start;
			this.height = height;
		}
		@Override
		public String toString() {
			return "Column [start=" + start + ", height=" + height + "]";
		}
		@Override
		public int compareTo(Column o) {
			return this.start - o.start;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Column[] c = new Column[N];
		int max = 0, maxi = -1;
		for (int i = 0; i < N; i++) {
			String[] s = in.readLine().split(" ");
			c[i] = new Column(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			if(c[i].height > max) max = c[i].height;
			
		}
		Arrays.sort(c);
		for(int i = 0; i < N; i++) {
			if(c[i].height == max) maxi = i;
		}
		int res = 0;
		
		Column tmp1 = c[0];
		for (int i = 1; i < N; i++) {
			if(tmp1.height <= c[i].height) {
				res += tmp1.height * Math.abs(c[i].start - tmp1.start);
				tmp1 = c[i];
				maxi = i;
			}
		}
		
		Column tmp2 = c[N-1];
		for (int i = 0; i < N - maxi; i++) {
			if(tmp2.height <= c[N-i-1].height) {
				res += tmp2.height * Math.abs((c[N-i-1].start + 1) - (tmp2.start + 1));
				tmp2 = c[N-i-1];
			}
		}
		res += max;
		
		System.out.println(res);
		
	}
}
