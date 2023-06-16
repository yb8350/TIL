package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_1546_평균 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		double max = 0;
		double[] arr = new double[N];
		for (int i = 0; i < N; i++) {
			double tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
			if(max < tmp) {
				max = tmp;
			}
		}
		
		double sum = 0, res = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i] / max * 100.0;
		}
		System.out.println(sum / N);
	}
}
