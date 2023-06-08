package com.pttdv.st0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S3_13305_주유소 {
	static long res;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken())-1;
		
		int[] load = new int[N];
		PriorityQueue<int[]> price = new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			load[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			price.offer(new int[] {Integer.parseInt(st.nextToken()), i});
		}
		
		runLoad(price, load, N);
		System.out.println(res);
	}
	private static void runLoad(PriorityQueue<int[]> price, int[] load, int n) {
		if(n == 0) return;
		
		int[] tmp = new int[] {-1, -1};
		do {
			 tmp = price.poll();
		} while(tmp[1] > n);
		long sum = 0;
		for (int i = tmp[1]; i < n; i++) {
			sum += load[i];
		}

		res += sum * tmp[0];
		runLoad(price, load, tmp[1]);
	}
}
