package com.ssafy.ws0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D3_1225_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for (int tc = 0; tc < T; tc++) {
			sb.append("#").append(Integer.parseInt(in.readLine())).append(" ");
			Queue<Integer> queue = new ArrayDeque<>();
			String[] s = in.readLine().split(" ");
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(s[i]));
			}
			int cnt = 1;
			while(queue.peek() - cnt > 0) {
				queue.offer(queue.poll() - cnt);
				cnt++;
				if(cnt == 6) cnt = 1;
			}
			queue.poll();
			queue.offer(0);
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
