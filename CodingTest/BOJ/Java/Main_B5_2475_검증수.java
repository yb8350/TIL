package com.pttdv.st;

import java.util.*;
import java.io.*;

public class Main_B5_2475_검증수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		System.out.println(sum % 10);
		
	}
}
