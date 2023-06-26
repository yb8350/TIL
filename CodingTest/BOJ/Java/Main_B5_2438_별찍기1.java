package com.pttdv.st;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main_B5_2438_별찍기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
