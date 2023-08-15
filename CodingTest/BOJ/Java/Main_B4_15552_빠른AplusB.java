package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_B4_15552_빠른AplusB { //241500kb	736ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(A+B).append("\n");
		}
		System.out.println(sb);
	}
}
