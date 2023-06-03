package com.ssafy.hw0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main_G5_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		Stack<int[]> top = new Stack<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		loop:
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(top.isEmpty()) sb.append("0 ");
			else {
				if(tmp < top.peek()[1]) {
					sb.append(top.peek()[0]).append(" ");
					top.push(new int[] {i, tmp});
					continue;
				}
				while(tmp > top.peek()[1]) {
					top.pop();
					if(top.isEmpty()) {
						sb.append("0 ");
						top.push(new int[] {i, tmp});
						continue loop;
					}
				}
				sb.append(top.peek()[0]).append(" ");
			}
			top.push(new int[] {i, tmp});
		}
		System.out.println(sb);
	}
}