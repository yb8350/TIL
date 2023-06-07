package com.pttdv.st0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_13549_숨바꼭질3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N, 0});
		
		int[] checked = new int[100001];
		Arrays.fill(checked, Integer.MAX_VALUE);
		int res = Integer.MAX_VALUE; 
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			if(tmp[0] == K) {
				res = tmp[1] < res ? tmp[1] : res;
				continue;
			}
			if(res < tmp[1]) continue;
			
			check(tmp[0]*2, tmp[1], checked, q);
			check(tmp[0]+1, tmp[1]+1, checked, q);
			check(tmp[0]-1, tmp[1]+1, checked, q);
		}
		
		System.out.println(res);
	}

	private static void check(int i, int j, int[] checked, Queue<int[]> q) {
		if(i >= 0 && i <= 100000 && checked[i] > j) {
			q.add(new int[] {i, j});
			checked[i] = j;
		}
	}
	
}
