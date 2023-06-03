package com.ssafy.st0428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G3_2629_양팔저울 { //13300kb	84ms
	static int N;
	static int[] chu;
	static boolean[][] res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		chu = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine()); 
		for (int i = 0; i < N; i++) {
			chu[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(in.readLine());
		int[] guseul = new int[M];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			guseul[i] = Integer.parseInt(st.nextToken());
		}
		
		//풀이
		res = new boolean[N+1][40001]; 
		
		measure(0, 0); 
		
		for (int i = 0; i < M; i++) { //모든 구슬을 순환하여 측정 가능한지 체크
			if(res[N][guseul[i]]) sb.append("Y").append(" ");
			else sb.append("N").append(" ");
		}
		System.out.println(sb);
	}

	private static void measure(int cnt, int w) {
		if(res[cnt][w]) return; //이미 확인했던 곳이면 리턴
		res[cnt][w] = true; //측정 가능함을 체크
		
		if(cnt == N) return; //모든 추를 확인했으면 리턴
		
		measure(cnt + 1, w + chu[cnt]); //오른쪽에 추를 추가했을 때
		measure(cnt + 1, w); //오른쪽에 추를 추가하지 않았을 때
		measure(cnt + 1, Math.abs(w - chu[cnt])); //왼쪽에 추를 추가했을 때
	}
}
