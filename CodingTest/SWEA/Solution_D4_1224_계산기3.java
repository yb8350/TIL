package com.ssafy.ws0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1224_계산기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(in.readLine());
            char[] line = in.readLine().toCharArray();
        	Stack<Integer> num = new Stack<>();
        	Stack<Character> oper = new Stack<>();
            for (int i = 0; i < N; i++) {
            	if(line[i] == '(') oper.push(line[i]);
            	else if(line[i] == ')') {
            		while(oper.peek() != '(') {
            			int tmp = oper.pop();
            			if(tmp == '+') num.push(num.pop() + num.pop());
            			else if(tmp == '*') num.push(num.pop() * num.pop());
            		}
            		oper.pop();
            	}
            	else if(line[i] == '*') oper.push(line[i]);
            	else if(line[i] == '+') {
            		if(oper.isEmpty() || oper.peek() == '(') oper.push(line[i]);
            		else {
            			while(oper.peek() != '(' && !oper.isEmpty()) {
            				int tmp = oper.pop();
                			if(tmp == '+') num.push(num.pop() + num.pop());
                			else if(tmp == '*') num.push(num.pop() * num.pop());
            			}
            			oper.push(line[i]);
            		}
            	}
             	else num.push(line[i]-'0');
            }
            sb.append(num.pop()).append("\n");
        }
        System.out.println(sb);
	}
}
