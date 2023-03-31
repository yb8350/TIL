package com.ssafy.st0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14719_빗물 { //11756kb	80ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] block = new int[W];
		int max = 0;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
			if(block[max] < block[i]) max = i;
		}
		
		//풀이 : 처음부터 max까지, 끝에서부터 max까지 탐색
		int set = block[0]; //처음 값으로 세팅
		int rain = 0, res = 0;
		for (int i = 1; i <= max; i++) {
			if(set > block[i]) rain += set - block[i]; //set보다 작으면, 작은만큼 빗물로 채우기
			else {
				res += rain;
				rain = 0;
				set = block[i];
			}
		}
		
		set = block[W - 1]; //끝 값으로 세팅
		rain = 0;
		for (int i = W - 2; i >= max; i--) {
			if(set > block[i]) rain += set - block[i];
			else {
				res += rain;
				rain = 0;
				set = block[i];
			}
		}
		System.out.println(res);
	}
}
