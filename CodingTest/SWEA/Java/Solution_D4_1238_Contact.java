package com.ssafy.hw0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int data;
	Node link;
	public Node(int data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
}

public class Solution_D4_1238_Contact {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 1;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String[] s = in.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int start = Integer.parseInt(s[1]);
			Node[] gr = new Node[101];
			boolean[] visited = new boolean[101];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				gr[from] = new Node(to, gr[from]);
			}
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(start);
			visited[start] = true;
			int lv = 0, t = 0, cnt = 1;
			Object[] arr = null;
			while(!q.isEmpty()) {
				int c = q.poll();
				for(Node tmp = gr[c]; tmp != null; tmp = tmp.link) {
					if(!visited[tmp.data]) {
						q.offer(tmp.data);
						visited[tmp.data] = true;
						t++;
					}
				}
				
				if(lv == 0) {
					lv = t;
					t = 0;
					if(!q.isEmpty()) {
						arr = q.toArray();
					}
				}
				lv--;
			}
			
			int max = 0;
			for(Object i : arr) {
				if((int)i > max) max = (int)i;
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
