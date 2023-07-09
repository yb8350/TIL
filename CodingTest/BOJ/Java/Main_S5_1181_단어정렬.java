package com.pttdv.st;
import java.util.*;
import java.io.*;
public class Main_S5_1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(in.readLine());
		}
		
		PriorityQueue<String[]> pq = new PriorityQueue<>((a,b)->
		Integer.parseInt(a[1]) == Integer.parseInt(b[1]) ? 
				a[0].compareTo(b[0]) : Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
		Iterator<String> setIter = set.iterator();
		for (int i = 0; i < set.size(); i++) {
			String tmp = setIter.next();
			pq.add(new String[] {tmp, Integer.toString(tmp.length())});
		}
		
		for (int i = 0; i < set.size(); i++) {
			sb.append(pq.poll()[0]).append("\n");
		}
		
		System.out.println(sb);
	}
}
