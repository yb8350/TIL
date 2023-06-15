package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S4_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			map.put(name, 1);
		}
		
		int cnt = 0;
		PriorityQueue<String> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			if(map.get(name) != null) {
				cnt++;
				pq.offer(name);
			}
		}
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}
}
