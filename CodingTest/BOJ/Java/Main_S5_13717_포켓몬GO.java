package com.pttdv.st0905;
import java.util.*;
import java.io.*;
public class Main_S5_13717_포켓몬GO {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int res = 0;
		int max = 0;
		String pokemon = "";
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			st = new StringTokenizer(in.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			while(M >= K) {
				int tmp = M / K;
				M = M - (K * tmp) + (2 * tmp);
				cnt += tmp;
			}
			
			res += cnt;
			if(max < cnt) {
				max = cnt;
				pokemon = name;
			}
		}
		
		System.out.println(res);
		System.out.println(pokemon);
	}
}
