package com.ssafy.ws0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S1_1074_Z {
	static int N ,r, c, res;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = in.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		r = Integer.parseInt(s[1]);
		c = Integer.parseInt(s[2]);
		
		int m = (int) Math.pow(2, N);
		search(N, m/2, m/2, 0);
		System.out.println(res);
	}
	private static void search(int n, int tr, int tc, int start) {
		if(n == 0) {
			res = start;
			return;
		}
		
		int t = (int) Math.pow(2, n);
		int k = (int) Math.pow(2, n - 1) / 2;
		int m = t * t / 4;

		if(r < tr && c < tc) {
			search(n-1, tr - k, tc - k, start + m * 0);
		}
		else if(r < tr && c >= tc) {
			search(n-1, tr - k, tc + k, start + m * 1);
		}
		else if(r >= tr && c < tc) {
			search(n-1,  tr + k, tc - k, start + m * 2);
		}
		else if(r >= tr && c >= tc) {
			search(n-1,  tr + k, tc + k, start + m * 3);
		}
	}
}