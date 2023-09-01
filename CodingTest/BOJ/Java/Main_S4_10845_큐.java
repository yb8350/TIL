package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_S4_10845_큐 {
	static StringBuilder sb;
	static Deque<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			String[] cmd = in.readLine().split(" ");

			if(cmd[0].equals("push")) PushQueue(cmd[1]);	
			else if(cmd[0].equals("pop")) PopQueue();
			else if(cmd[0].equals("size")) SizeQueue();
			else if(cmd[0].equals("empty")) EmptyQueue();
			else if(cmd[0].equals("front")) frontQueue();
			else if(cmd[0].equals("back")) BackQueue();
		}
		
		System.out.println(sb.toString());
	}
	
	private static void PushQueue(String num) {
		q.offer(Integer.parseInt(num));
	}

	private static void PopQueue() {
		if(!q.isEmpty()) sb.append(q.poll()).append("\n");
		else sb.append(-1).append("\n");
	}

	private static void SizeQueue() {
		sb.append(q.size()).append("\n");
		
	}

	private static void EmptyQueue() {
		sb.append(q.isEmpty() ? 1 : 0).append("\n");
	}

	private static void frontQueue() {
		if(!q.isEmpty()) sb.append(q.peekFirst()).append("\n");
		else sb.append(-1).append("\n");
	}

	private static void BackQueue() {
		if(!q.isEmpty()) sb.append(q.peekLast()).append("\n");
		else sb.append(-1).append("\n");
	}
}
