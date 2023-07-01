package com.pttdv.st0704;

import java.util.*;
import java.io.*;

public class Main_S4_1302_베스트셀러 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		// 입력 : map을 활용하여 이름 별 갯수를 저장
		for (int i = 0; i < N; i++) {
			String tmp = in.readLine();
			if(map.get(tmp) == null) {
				map.put(tmp, 1);
			} else {
				map.put(tmp, map.get(tmp) + 1);
			}
		}
		
		int max = 0;
		String res = "";
		
		// 전체 목록을 돌면서 가장 큰 이름을 찾는다.
		for(String t : map.keySet()) {
			if(max < map.get(t)) {
				max = map.get(t);
				res = t;
			} else if(max == map.get(t) && res.compareTo(t) > 0) { // 갯수가 같으면 사전 순으로 빠른 것을 저장
				res = t;
			}
		}
		
		System.out.println(res);
	}
}
