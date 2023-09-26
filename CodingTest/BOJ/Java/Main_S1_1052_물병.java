package com.pttdv.st0926;
import java.util.*;
import java.io.*;
public class Main_S1_1052_물병 { // 11520kb	76ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String binaryN = Integer.toBinaryString(N);
		int res = 0;
		while(true) {
			// 1. 1의 개수 카운트
			int cnt = 0;
			int lastIndex = 0;
			for(int i = 0; i < binaryN.length(); i++) {
				if(binaryN.charAt(i) == '1') {
					cnt++;
					lastIndex = i;
				}
			}
			
			// 2. 만약 1의 개수가 K보다 크다면, 가장 낮은 1의 위치에 해당하는 값을 N에 더한 후 반복
			if(cnt > K) {
				int tmp = (int) Math.pow(2, binaryN.length() - (lastIndex + 1));
				res += tmp;
				N += tmp;
				binaryN = Integer.toBinaryString(N);
			}
			else break;
		}
		

		System.out.println(res);
	}
}
