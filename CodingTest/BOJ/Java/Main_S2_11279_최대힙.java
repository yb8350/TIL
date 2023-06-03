package com.ssafy.st0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_S2_11279_최대힙 { //24868kb	284ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대힙 생성
		
		//풀이
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(in.readLine());
			if(x > 0) pq.offer(x); //자연수일 때, 최대힙에 넣기
			else if(x == 0) { //0일 때,
				if(pq.isEmpty()) sb.append("0\n"); //비어있다면 0 출력
				else sb.append(pq.poll()).append("\n"); //아니라면 최대값 출력
			}
		}
		System.out.println(sb);
	}
}
