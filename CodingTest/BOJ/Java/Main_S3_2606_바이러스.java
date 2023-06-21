package com.pttdv.st0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S3_2606_바이러스 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] computer = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			computer[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			computer[a].add(b);
			computer[b].add(a);
		}
		
		boolean[] virus = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		virus[1] = true;
		
		while(!q.isEmpty()) {
			ArrayList<Integer> list = computer[q.poll()];
			for (int i = 0; i < list.size(); i++) {
				int tmp = list.get(i);
				if(!virus[tmp]) {
					virus[tmp] = true;
					q.offer(tmp);
				}
			}
		}
		
		int res = 0;
		for (int i = 2; i < N+1; i++) {
			if(virus[i]) res++;
		}
		
		System.out.println(res);
		
	}
}
