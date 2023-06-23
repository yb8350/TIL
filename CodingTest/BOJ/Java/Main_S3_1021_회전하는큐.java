package com.pttdv.st0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S3_1021_회전하는큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.add(i+1);
		}
		
		st = new StringTokenizer(in.readLine());
		int res = 0;

		
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = 0;
			int cnt = 0;
			while(true) {
				if(queue.get(left) == num) {
					for (int j = 0; j < cnt; j++) {
						queue.addLast(queue.removeFirst());
					}
					queue.removeFirst();
					res += cnt;
					break;
				}
				else if(queue.get(right) == num) {
					for (int j = 0; j < cnt; j++) {
						queue.addFirst(queue.removeLast());
					}
					queue.poll();
					res += cnt;
					break;
				}
				
				left = left+1 > queue.size() - 1 ? 0 : left + 1;
				right = right-1 < 0 ? queue.size() - 1 : right - 1;
				cnt++;

			}
		}
		System.out.println(res);
	}
}
