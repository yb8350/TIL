package com.pttdv.st0815;
import java.util.*;
import java.io.*;
public class Main_S1_1389_케빈베이컨의6단계법칙 { //11664kb	84ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1]; // 각 노드의 관계를 저장
		
		// 모든 관계를 1000으로 초기화 후, 자신과 연결되는 지점은 0으로 초기화
		for(int i = 1; i <= N; i++) {
			Arrays.fill(arr[i], 1000);
			arr[i][i] = 0;
		}
		
		// 입력: 연결되어 있는 각 노드를 1로 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A][B] = 1;
			arr[B][A] = 1;
		}
		
		// 플로이드-워셜: 직접 가는 방법과 중간 노드를 거쳐서 가는 방법을 비교하여 최솟값을 저장
		for (int i = 1; i <= N; i++) {
			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					arr[a][b] = Math.min(arr[a][b], arr[a][i]+arr[i][b]);
				}
			}
		}
		
		// 노드 별 최단 경로를  탐색하며 최솟값을 가진 케빈 베이컨의 수를 구한다.
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				cnt += arr[i][j];
			}
			
			if(cnt < min) {
				min = cnt;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
}
