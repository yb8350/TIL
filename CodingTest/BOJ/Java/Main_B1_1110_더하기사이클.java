package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main_B1_1110_더하기사이클 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String N = in.readLine();
		if(N.length() == 1) N = "0" + N;
		String tmp = N;
		int cnt = 0;
		do {
			String[] arr = tmp.split("");
			tmp = arr[1];	
			String t = Integer.toString(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
			if(t.length() == 1) t = "0" + t;
			tmp += t.split("")[1];
			cnt++;
		} while(!N.equals(tmp));

		System.out.println(cnt);
	}
}
