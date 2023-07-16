package com.ssafy.ws0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Character> bracket = new HashMap<>();
		bracket.put('{', '}');
		bracket.put('[', ']');
		bracket.put('(', ')');
		bracket.put('<', '>');
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int cnt = Integer.parseInt(in.readLine());
			String s = in.readLine();
			Stack<Character> stack = new Stack<>();
			boolean res = true;
			for (int i = 0; i < cnt; i++) {
				char tmp = s.charAt(i);
				if(bracket.containsKey(tmp)) {
					stack.push(tmp);
				}
				else if(tmp == bracket.get(stack.peek())) stack.pop();
				else {
					res = false;
					break;
				}
			}
			sb.append(res?"1":"0").append("\n");
		}
		System.out.println(sb);
	}
}
