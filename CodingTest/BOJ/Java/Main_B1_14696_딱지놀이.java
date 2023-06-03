package com.ssafy.st0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int tc = 0; tc < N; tc++) {
			int[] a = new int[4];
			int[] b = new int[4];
			
			st = new StringTokenizer(in.readLine());
			int C = Integer.parseInt(st.nextToken());
			for (int i = 0; i < C; i++) {
				a[Integer.parseInt(st.nextToken())-1]++;
			}
			st = new StringTokenizer(in.readLine());
			C = Integer.parseInt(st.nextToken());
			for (int i = 0; i < C; i++) {
				b[Integer.parseInt(st.nextToken())-1]++;
			}
			
			for (int i = 3; i >= -1; i--) {
				if(i == -1) sb.append("D\n");
				else if(a[i] > b[i]) {
					sb.append("A\n");
					break;
				}
				else if(a[i] < b[i]) {
					sb.append("B\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
