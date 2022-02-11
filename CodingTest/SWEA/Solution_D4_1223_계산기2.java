package com.ssafy.ws0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1223_계산기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(in.readLine());
            char[] line = in.readLine().toCharArray();
            Stack<Integer> num = new Stack<>();
            num.push((int)line[0]-'0');
            for (int i = 1; i < N; i+=2) {
                if (line[i] == '+') num.push((int)line[i+1]-'0');
                else if (line[i] == '*') {
                    int tmp = num.pop();
                    num.push(tmp * ((int)line[i+1]-'0'));
                }
            }
            int sum = 0;
            while(!num.isEmpty()) {
                sum += num.pop();               
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
		
	}
}
