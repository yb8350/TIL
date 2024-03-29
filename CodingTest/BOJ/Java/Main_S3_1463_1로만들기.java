package com.pttdv.st0717;
import java.util.*;
import java.io.*;
public class Main_S3_1463_1로만들기 { //15448kb	84ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			// 1을 만들었다면, 역순으로 숫자를 따라가며 sb에 저장
			if(num == 1) {
				int cnt = 0;
				int now = 1;
				while(now != N) {
					now = arr[now];
					cnt++;
				}
				System.out.println(cnt);
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
