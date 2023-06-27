package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_8989_시계 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
			String[] time = new String[5];
			
			for (int i = 0; i < 5; i++) {
				time[i] = st.nextToken();
				String[] tmp = time[i].split(":");
				int h = Integer.parseInt(tmp[0]);
				int m = Integer.parseInt(tmp[1]);
				if(h > 12) h = h - 12;
				double angle = Math.abs((h * 30 + m * 0.5) - (m * 6));
				if(angle > 180) angle = 360 - angle;
				pq.add(new int[] {(int) (angle * 10), Integer.parseInt(tmp[0]) * 100 + m, i});
			}
			
			pq.poll();
			pq.poll();			
			
			sb.append(time[pq.peek()[2]]).append("\n");
		}
		System.out.println(sb);
	}
}
