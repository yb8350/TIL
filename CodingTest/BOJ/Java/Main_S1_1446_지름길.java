package com.pttdv.st0810;
import java.util.*;
import java.io.*;
public class Main_S1_1446_지름길 { //	18404kb	224ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		// 시작 위치를 기준으로 우선순위 큐를 정렬하여 지름길 정보를 저장
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int shortcut = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {start, end, shortcut}); 
		}
		
		// 전체 거리를 무한으로 초기화
		int[] load = new int[10001];
		Arrays.fill(load, Integer.MAX_VALUE);
		
		// 현재 위치에서 한 칸씩 이동
		// 만약 지름길 사용이 가능하면 기존 값과 비교하여 이동 가능한 최솟값을 load의 현재 위치에 저장
		load[0] = 0;
		for(int i = 0; i < D; i++) {
			while(!pq.isEmpty() && pq.peek()[0] == i) {
				int[] tmp = pq.poll();
				load[tmp[1]] = Math.min(load[tmp[1]], load[tmp[0]] + tmp[2]);
			}
			load[i+1] = Math.min(load[i]+1, load[i+1]);
		}
		
		System.out.println(load[D]);
	}
}
