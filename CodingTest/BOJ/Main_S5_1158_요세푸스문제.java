package com.ssafy.ws0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S5_1158_요세푸스문제 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = in.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int n = 0;
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			q.offer(i+1);
		}
		sb.append("<");
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				if(j+1 == K) sb.append(q.poll()).append(", ");
				else q.offer(q.poll());
			}
		}
		
		
		System.out.println(sb.substring(0, sb.length()-2) + ">");
	}
}
