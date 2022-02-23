package com.ssafy.st0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[6];
		int N = Integer.parseInt(in.readLine()); //참외 개수 입력
		int maxi = 0, maxj = 0, id = -1, jd = -1; //가장 큰 가로, 세로의 값과 그 index를 저장
		for (int i = 0; i < 6; i++) { //방향, 길이 입력
			StringTokenizer st = new StringTokenizer(in.readLine());
			int dir = Integer.parseInt(st.nextToken()); //방향 입력
			int len = Integer.parseInt(st.nextToken()); //길이 입력
		
		//풀이
			//가장 큰 세로 혹은 가로가 입력됐을 경우,
			//그 값의 이전값-다음값은 파인 부분의 가로 혹은 세로이다.
			
			arr[i] = len;
			if(dir == 1 || dir ==2) { // 가로일 경우 최대값 탐색
				if(maxi < len) {
					maxi = len;
					id = i;
				}
			}
			else { //세로일 경우 최대값 탐색
				if(maxj < len) {
					maxj = len;
					jd = i;
				}
			}
		}
		
		int x = 0, y = 0;
		//가로의 파인 부분 길이 계산
		if(id == 0) x = Math.abs(arr[id + 1] - arr[5]);
		else if (id == 5) x = Math.abs(arr[id - 1] - arr[0]);
		else x = Math.abs(arr[id + 1] - arr[id - 1]);
		
		//세로의 파인 부분 길이 계산
		if(jd == 0) y = Math.abs(arr[jd + 1] - arr[5]);
		else if (jd == 5) y = Math.abs(arr[jd - 1] - arr[0]);
		else y = Math.abs(arr[jd + 1] - arr[jd - 1]);
		
		//출력
		System.out.println((maxi * maxj - x * y) * N);
		
	}
}
