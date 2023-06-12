package com.pttdv.st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_2920_음계 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int asc = 0, desc = 0;
		for (int i = 1; i < 9; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == i) asc++;
			else if(tmp == 9-i) desc++;
			else {
				System.out.println("mixed");
				return;
			}
		}
		
		if(asc == 8) System.out.println("ascending");
		else if(desc == 8) System.out.println("descending");
		else System.out.println("mixed");
		
	}
}
