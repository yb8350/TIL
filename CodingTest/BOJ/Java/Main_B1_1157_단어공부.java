package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_1157_단어공부 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String list = in.readLine().toUpperCase();
		int[] alphabet = new int[27];
		for (int i = 0; i < list.length(); i++) {
			char word = list.charAt(i);
			alphabet[word-65]++;
		}
		
		int max = 0;
		int idx = -1;
		int cnt = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
				idx = i;
				cnt = 1;
			}
			else if(max == alphabet[i]) {
				cnt++;
			}
		}
		
		if(cnt > 1) System.out.println("?");
		else System.out.println((char)(65+idx));
	}
}
