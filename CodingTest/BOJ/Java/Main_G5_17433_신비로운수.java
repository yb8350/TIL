package com.pttdv.st0926;
import java.util.*;
import java.io.*;
public class Main_G5_17433_신비로운수 { // 16092kb	140ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 정렬을 통해 가장 작은 수를 구해서, 각 숫자마다 그 차이를 계산하여 최대 공약수를 구한다.
			Arrays.sort(arr);
			int min = arr[0];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				arr[i] -= min;
				if(arr[i] != 0) {
					idx = i;
					break;
				}
			}
			
			// 모든 수의 차이가 같다는 의미이므로, 무한에 해당한다.
			if(idx == 0) {
				sb.append("INFINITY").append("\n");
				continue;
			}
			
			// 이어서 숫자의 차이와 최대공약수를 구한다.
			int res = arr[idx];
			for(int i = idx + 1; i < N; i++) {
				arr[i] -= min;
				res = gcd(res, arr[i]);
			}
			
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	// a % b = r -> b % r = 0 : 0이 되었을 때 최대공약수가 되는 원리
	private static int gcd(int a, int b) {
		int tmp = a % b;
		while(tmp != 0) {
			a = b;
			b = tmp;
			tmp = a % b;
		}
		return b;
	}
}
