package com.pttdv.st0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_G4_9935_문자열폭발 { //87360kb	460ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String arr = in.readLine();
		String boom = in.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < arr.length(); i++) {
			// 1. stack에 문자 push
			stack.push(arr.charAt(i));
			
			// 2. stack 길이가 폭발 문자열 길이 이상인지 확인
			if(stack.size() >= boom.length()) {
				boolean flag = true;
				
				// 2-1. stack의 가장 끝부터 폭발 문자열과 같은지 확인
				for (int j = 0; j < boom.length(); j++) {
					// 다르면 flag를 false로 바꾼 후 반복 중지
					if(stack.get(stack.size() - j - 1) != boom.charAt(boom.length() - j - 1)) {
						flag = false;
						break;
					}	
				}
				
				// 2-2. stack의 마지막이 폭발 문자열과 같다면 그 길이만큼 pop
				if(flag) {
					for (int j = 0; j < boom.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		
		int len = stack.size();
		if(len == 0) 
			sb.append("FRULA");
		else {
			for (int i = 0; i < len; i++) {
				sb.append(stack.pop());
			}
			sb = sb.reverse();
		}
		
		System.out.println(sb);

// 리팩토링 전 : 276912kb	1008ms
//		int checked = 0;
//		boolean toggle = false;
//		do {
//			toggle = false;
//			
//			for (int i = 0; i < arr.length(); i++) {
//				// 1. stack에 문자 push
//				stack.push(arr.charAt(i));
//				
//				// 2. 폭발 문자열의 현재 문자와 같은지 확인
//				if(stack.peek() == boom.charAt(checked)) {
//					// 2-1. 폭발 문자열의 끝이라면
//					if(checked == boom.length()-1) {
//						for (int j = 0; j < boom.length(); j++) {
//							stack.pop();
//						}
//						toggle = true;
//					}
//					// 2-2. 다음 문자가 남아 있다면
//					else {
//						checked++;
//						continue;
//					}
//				}
//				
//				// 3. 현재 stack의 맨 윗 문자가 폭발 문자열의 첫 문자와 같은지 확인
//				if (stack.size() != 0 && stack.peek() == boom.charAt(0)) {
//					checked = 1;
//				}
//				else checked = 0;
//			}
//			
//			int len = stack.size();
//			StringBuilder str = new StringBuilder();
//			if(len == 0) {
//				System.out.println("FRULA");
//				return;
//			}
//			else {
//				for (int i = 0; i < len; i++) {
//					str.append(stack.pop());
//				}
//				str = str.reverse();
//				arr = str.toString();
//			}
//		} while(toggle);
//		
//		System.out.println(arr);
	}
}
