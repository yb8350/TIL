package com.ssafy.st0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G5_2133_타일채우기 { //11500kb	88ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		if(N % 2 == 0) {
			arr[0] = 1;
			arr[2] = 3;
			for (int i = 4; i <= N; i+=2) {
				arr[i] = arr[i-2] * arr[2];
				for (int j = i - 4; j >= 0; j-=2) {
					arr[i] += arr[j] * 2;
				}
			}
			System.out.println(arr[N]);
		}else System.out.println("0");
	}
}

//https://yabmoons.tistory.com/536 참고