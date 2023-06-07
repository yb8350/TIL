package com.pttdv.st0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_1593_문자해독 { //36772kb	404ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int g = Integer.parseInt(st.nextToken());
		int Slength = Integer.parseInt(st.nextToken());
		String W = new StringTokenizer(in.readLine()).nextToken();
		String S = new StringTokenizer(in.readLine()).nextToken();
		
		// 1. map 채우기
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < g; i++) {
			char w = W.charAt(i);
			if(map.containsKey(w)) map.put(w, map.get(w) + 1);
			else map.put(w, 1);
		}
		
		int cnt = 0, res = 0;
		for (int i = 0; i < Slength; i++) {
			// 2. 현재 문자가 W에 있다면 추가 후, 조건에 해당하면 cnt 증가
			char s = S.charAt(i);
			if(map.get(s) != null) {
				map.put(s, map.get(s)-1);
				if(map.get(s) >= 0) cnt++;
			}
			
			if(i >= g-1) {
				if(cnt == g) res++; // 현재 확인 중인 문자열이 W에 모두 해당되면 res 증가
				// 3. 현재 확인 중인 g 길이의 문자열 중 첫 번째 글자를 map에서 제거 후 cnt 감소
				char first = S.charAt(i-g+1);
				if(map.get(first) != null) {
					map.put(first, map.get(first)+1);
					if(map.get(first) > 0) cnt--;
				}
			}
		}
		System.out.println(res);
	}
}
