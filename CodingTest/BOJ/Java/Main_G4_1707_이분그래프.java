package com.pttdv.st0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_1707_이분그래프 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] node = new ArrayList[V+1];
			
			for (int i = 1; i <= V; i++) {
				node[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				node[a].add(b);
				node[b].add(a);
			}
			
			//풀이
			int[] team = new int[V+1];
			boolean toggle = true;
			point:
			for (int i = 1; i <= V; i++) {
				if(team[i] == 0) {
					Queue<Integer> q = new LinkedList<Integer>();
					q.offer(i);
					team[i] = 1;
					while(!q.isEmpty()) {
						int now = q.poll();
						ArrayList<Integer> tmp = node[now];
						for (int j = 0; j < tmp.size(); j++) {
							if(team[tmp.get(j)] == 0) {
								q.offer(tmp.get(j));
								team[tmp.get(j)] = team[now] == 1 ? 2 : 1;
							}
							else if(team[tmp.get(j)] == team[now]) {
								sb.append("NO").append("\n");
								toggle = false;
								break point;
							}
						}
					}
				}
			}
			
			if(toggle) sb.append("YES").append("\n");
		}
		System.out.println(sb);

	}
}
