package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_S4_1026_보물 {
	static int N;
	static int[] A, B;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		B = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += A[i] * B[N - i -1];
		}
		
		System.out.println(sum);
	}
}
