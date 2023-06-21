package com.pttdv.st0620;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S1_20529_가장가까운세사람의심리적거리 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			if(N > 32) {
				sb.append(0).append("\n");
				String trash = in.readLine();
				continue;
			}
			
			String[] mbtiList = in.readLine().split(" ");
			int[] arr = new int[N];
			arr[N-1] = 1;
			arr[N-2] = 1;
			arr[N-3] = 1;
			
			int min = Integer.MAX_VALUE;
			do {
				String[] tmp = new String[4];
				int idx = 0;
				for (int i = 0; i < N; i++) {
					if(arr[i] == 1) {
						tmp[idx++] = mbtiList[i];
					}
				}
				tmp[idx] = tmp[0];
				
				int sum = 0;
				for (int i = 0; i < 3; i++) {
					String[] A = tmp[i].split("");
					String[] B = tmp[i+1].split("");
					for (int j = 0; j < 4; j++) {
						if(!A[j].equals(B[j])) {
							sum++;
						}
					}
				}
				
				min = min > sum ? sum : min;
			} while(np(arr));
			
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	private static boolean np(int[] arr) {
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			j--;

		swap(arr, i - 1, j);

		int k = N - 1;
		while (i < k)
			swap(arr, i++, k--);
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
