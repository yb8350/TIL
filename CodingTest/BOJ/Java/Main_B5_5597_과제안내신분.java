package com.pttdv.st;

import java.util.*;
import java.io.*;

public class Main_B5_5597_과제안내신분 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[31];
		for(int i = 0; i < 28; i++) {
			int N = Integer.parseInt(in.readLine());
			arr[N] = true;
		}
		
		for(int i = 1; i <= 30; i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}

	}
}
