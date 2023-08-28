package com.pttdv.st0829;
import java.util.*;
import java.io.*;
public class Main_G2_1766_문제집 { //	46564kb	456ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			cnt[B] += 1;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if(cnt[i] == 0) pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int tmp = pq.poll();
			ArrayList<Integer> nowList = list[tmp];
			
			for(int num : nowList) {
				if(cnt[num] - 1 == 0) {
					pq.add(num);
				}
				else cnt[num] -= 1;
			}
			
			sb.append(tmp).append(" ");
		}
		
		System.out.println(sb);
	}
}
