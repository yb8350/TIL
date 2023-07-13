package com.pttdv.st0717;
import java.util.*;
import java.io.*;
public class Main_S1_12852_1로만들기2 { //15508kb	80ms => Java 5등
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 입력 : 숫자 N
		int N = Integer.parseInt(in.readLine());
		
		// 풀이 : 다음 숫자의 인덱스 위치에 현재 숫자를 저장하여, 1을 만든 후 역순으로 따라가 출력
		int[] arr = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		arr[N] = -1;
		q.offer(N);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			// 1을 만들었다면, 역순으로 숫자를 따라가며 sb에 저장
			if(num == 1) {
				StringBuilder sb = new StringBuilder();
				sb.append(1);
				int cnt = 0;
				int now = 1;
				while(now != N) {
					now = arr[now];
					sb.insert(0, now + " ");
					cnt++;
				}
				System.out.println(cnt);
				System.out.println(sb);
				break;
			}
			
			// 조건에 맞으면서 해당 위치가 비어있다면, 현재 숫자를 다음 숫자의 인덱스에 저장한 후 큐에 저장
			if(num % 3 == 0 && arr[num / 3] == 0) {
				arr[num / 3] = num;
				q.offer(num / 3);
			}
			if(num % 2 == 0 && arr[num / 2] == 0) {
				arr[num / 2] = num;
				q.offer(num / 2);
			}
			if(arr[num - 1] == 0) {
				arr[num - 1] = num;
				q.offer(num - 1);
			}
		}
	}
}
