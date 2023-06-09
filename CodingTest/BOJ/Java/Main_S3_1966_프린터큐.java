package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S3_1966_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(new int[] {num, i});
				pq.offer(num);
			}
			int cnt = 0;
			
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				if(tmp[0] == pq.peek()) {
					pq.poll();
					cnt++;
					if(tmp[1] == M) {
						break;
					}
				}
				else {
					q.offer(tmp);
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
