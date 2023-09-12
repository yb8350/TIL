package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_S5_1427_소트인사이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] N = in.readLine().split("");
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N.length; i++) {
			arr.add(Integer.parseInt(N[i]));
		}
		
		Collections.sort(arr, Collections.reverseOrder());
		
		for (int i = 0; i < N.length; i++) {
			sb.append(arr.get(i));
		}
		
		System.out.println(sb);
	}
}
