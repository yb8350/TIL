package com.pttdv.st0926;
import java.util.*;
import java.io.*;
public class Main_S1_1946_신입사원 { //301432kb	1700ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			ArrayList<int[]> arr = new ArrayList<>();
			
			// 입력: 모든 지원자의 등수 입력
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int A = Integer.parseInt(st.nextToken()); // 서류 등수
				int B = Integer.parseInt(st.nextToken()); // 면접 등수
				arr.add(new int[] {A, B});
			}
			
			// 서류 등수를 기준으로 정렬
			Collections.sort(arr, (a,b) -> a[0] - b[0]);
			
			// 서류 1등의 면접 등수를 min에 저장
			int min = arr.get(0)[1];
			int cnt = 1;
			
			// 이전 지원자의 면접 최고 등수보다 높으면 합격
			for (int i = 1; i < N; i++) {
				int rank = arr.get(i)[1];
				if(min > rank) {
					cnt++;
					min = arr.get(i)[1];
				}
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
