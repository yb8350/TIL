package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_B3_11719_그대로출력하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while((line = in.readLine()) != null) {
			sb.append(line).append("\n");
		}
		
		System.out.println(sb);
	}
}
