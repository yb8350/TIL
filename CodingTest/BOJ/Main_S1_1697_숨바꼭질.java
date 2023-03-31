package com.ssafy.st0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1697_숨바꼭질 { //16444kb	124ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//풀이
		if(N == K) { //출발지와 목적지가 같은 경우
			System.out.println(0);
			return;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		int cnt = 1; //레벨을 계산하기 위한 변수
		int res = 1; //현재 레벨을 저장하는 변수
		boolean[] checked = new boolean[100001];
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			if(tmp + 1 == K || tmp - 1 == K || tmp * 2 == K) { //목적지일 경우
				break;
			}
			
			//한번도 확인하지 않은 값일 때 큐에 추가
			check(tmp+1, q, checked);
			check(tmp-1, q, checked);
			check(tmp*2, q, checked);
			
			cnt--;
			if(cnt == 0) {
				cnt = q.size();
				res++;
			}
		}
		System.out.println(res);
	}

	private static void check(int i, Queue<Integer> q, boolean[] checked) {
		if(i >= 0 && i <= 100000 && !checked[i]) {
			q.offer(i); 
			checked[i] = true;
		}
	}
}
