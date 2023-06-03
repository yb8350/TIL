package com.ssafy.st0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_10158_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(in.readLine());
		
		if((t+p)/w % 2 == 0) sb.append((t+p) % w);
		else sb.append(w-((t+p) % w));
		sb.append(" ");
		if((t+q)/h % 2 == 0) sb.append((t+q) % h);
		else sb.append(h-((t+q) % h));
		
		System.out.println(sb);
	}
}
