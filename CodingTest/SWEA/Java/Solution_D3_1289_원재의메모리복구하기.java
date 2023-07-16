package com.ssafy.ws0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_1289_원재의메모리복구하기 {
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(in.readLine());
		for(int i = 0; i < tc; i++) {
			char[] data = in.readLine().toCharArray();
			int res = data[0] == '1' ? 1 : 0;
			for(int j = 0; j < data.length-1; j++) {
				if(data[j] != data[j+1]) res++;
			}
			sb.append("#" + (i+1) + " " + res + "\n");
		}
		System.out.println(sb.toString());
	}
}
