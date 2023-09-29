package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_B4_2742_기찍N {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		for(int i = N; i > 0; i--) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}
