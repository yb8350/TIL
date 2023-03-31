package com.ssafy.ws0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S3_1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {N, 0});
		while(!q.isEmpty()) {
			int[] t = q.poll();
			if(t[0] == 1) {
				System.out.println(t[1]);
				return;
			}
			if(t[0] % 3 == 0) q.offer(new int[] {t[0] / 3, t[1]+1});
			if(t[0] % 2 == 0) q.offer(new int[] {t[0] / 2, t[1]+1});
			q.offer(new int[] {t[0] - 1, t[1]+1});
		}
	}
}
