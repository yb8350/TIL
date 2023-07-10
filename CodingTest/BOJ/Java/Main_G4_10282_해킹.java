package com.pttdv.st0711;
import java.util.*;
import java.io.*;
public class Main_G4_10282_해킹 { //169676kb	1124ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력 : 컴퓨터 개수(n), 의존 정보의 개수(d), 바이러스에 걸린 컴퓨터(c)
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 입력 : 컴퓨터 간 의존 정보
			int[] distance = new int[n+1];
			boolean[] visited = new boolean[n+1];
			ArrayList<int[]>[] list = new ArrayList[n+1];
			
			for(int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
				distance[i] = Integer.MAX_VALUE;
			}

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list[b].add(new int[] {a, s});
			}
			
			// 풀이
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]); // 거리가 가까운 순으로
			pq.offer(new int[] {c, 0});
			distance[c] = 0;
			while(!pq.isEmpty()) {
				int num = pq.poll()[0];
				if(!visited[num]) {
					ArrayList<int[]> tmp = list[num];
					for(int[] arr : tmp) {
						distance[arr[0]] = Math.min(distance[num] + arr[1], distance[arr[0]]); // 현재 노드를 거쳐서 가는게 빠른지, 기존 방법이 빠른지 체크
						pq.add(new int[] {arr[0], distance[arr[0]]}); // 현재 노드와 거리를 pq에 추가
					}
					visited[num] = true;
				}
			}
			
			int cnt = 0;
			int max = 0;
			for (int i = 1; i <= n; i++) {
				if(visited[i]) { // 방문한 노드라면
					cnt++;
					max = Math.max(max, distance[i]);
				}
				
			}
			sb.append(cnt).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
