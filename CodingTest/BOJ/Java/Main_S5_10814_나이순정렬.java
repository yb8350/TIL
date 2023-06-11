package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S5_10814_나이순정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<String[]> pq = new PriorityQueue<>(
				(a,b)->Integer.parseInt(a[0])==Integer.parseInt(b[0])?Integer.parseInt(a[1])-Integer.parseInt(b[1]):Integer.parseInt(a[0])-Integer.parseInt(b[0]));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String age = st.nextToken();
			String name = st.nextToken();
			pq.offer(new String[] {age, String.valueOf(i), name});
		}
		
		for (int i = 0; i < N; i++) {
			String[] tmp = pq.poll();
			sb.append(tmp[0]).append(" ").append(tmp[2]).append("\n");
		}
		System.out.println(sb);
	}
}
