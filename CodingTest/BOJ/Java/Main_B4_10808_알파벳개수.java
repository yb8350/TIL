package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_B4_10808_알파벳개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String N = in.readLine();
		int[] alp = new int[26];
		for(int i = 0; i < N.length(); i++) {
			alp[N.charAt(i) - 97] += 1;
		}
		
		for (int i = 0; i < 26; i++) {
			sb.append(alp[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
