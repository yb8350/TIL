package com.pttdv.st0804;
import java.util.*;
import java.io.*;
public class Main_S1_1495_기타리스트 { // 20216kb	260ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 볼륨의 차이를 저장
		int[] ctrl = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// 모든 볼륨값에 대한 배열을 만들어, 해당 볼륨이 사용되는 순서를 저장
		int[] vol = new int[M+1];
		Arrays.fill(vol, -1);
		
		vol[S] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			// 다음 순서에 사용 가능한 볼륨값을 큐에 저장
			for(int j = 0; j <= M; j++) {
				if(vol[j] == i) {
					q.add(j + ctrl[i]);
					q.add(j - ctrl[i]);
				}
			}
			
			while(!q.isEmpty()) {
				int tmp = q.poll();
				if(tmp >= 0 && tmp <= M) vol[tmp] = i+1;
			}
		}
		
		// N번째에 사용 가능한 볼륨값 중 가장 큰 값을 탐색
		int res = -1;
		for(int i = 0; i <= M; i++) {
			if(vol[i] == N) {
				res = Math.max(res, i);
			}
		}
		
		System.out.println(res);
	}
}
