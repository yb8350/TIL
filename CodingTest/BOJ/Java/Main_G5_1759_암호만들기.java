package com.ssafy.ws0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_1759_암호만들기 {
	static int L, C;
	static int[] arr;
	static char[] pwd;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = in.readLine().split(" ");
		L = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		pwd = new char[C];
		arr = new int[C];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < C; i++) {
			pwd[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(pwd);
		for (int i = C - 1; i >= C - L; i--) {
			arr[i] = 1;
		}
		Stack<String> ss = new Stack<>();
		do {
			char[] tmp = new char[L];
			int cnt = 0, mo = 0, ja = 0;
			for (int i = 0; i < C; i++) {
				if (arr[i] == 1) {
					tmp[cnt++] = pwd[i];
					if (pwd[i] == 'a' || pwd[i] == 'e' || pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'u')
						mo++;
					else
						ja++;
				}
			}
			String str = "";
			if (mo >= 1 && ja >= 2) {
				for (int i = 0; i < L; i++) {
					str += tmp[i];
				}
				ss.push(str);
			}
		} while (np());

		while (!ss.isEmpty()) {
			sb.append(ss.pop()).append("\n");
		}

		System.out.println(sb);
	}

	private static boolean np() {
		int i = C - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;

		if (i == 0)
			return false;

		int j = C - 1;
		while (arr[i - 1] >= arr[j])
			--j;

		swap(i - 1, j);

		int k = C - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
