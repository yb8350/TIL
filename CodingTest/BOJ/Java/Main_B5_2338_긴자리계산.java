package com.pttdv.st;
import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main_B5_2338_긴자리계산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger A = new BigInteger(in.readLine());
		BigInteger B = new BigInteger(in.readLine());
		System.out.println(A.add(B));
		System.out.println(A.subtract(B));
		System.out.println(A.multiply(B));
	}
}
