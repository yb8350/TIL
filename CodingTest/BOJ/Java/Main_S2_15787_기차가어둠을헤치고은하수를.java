package com.pttdv.st1006;
import java.util.*;
import java.io.*;
public class Main_S2_15787_기차가어둠을헤치고은하수를 { // 75124kb	516ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] train = new String[N+1];
		for (int i = 1; i <= N; i++) {
			train[i] = "00000000000000000000";
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int mode = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if(mode == 1) {
				int seat= Integer.parseInt(st.nextToken());
				train[idx] = train[idx].substring(0, seat - 1) + "1" + train[idx].substring(seat);
			}
			if(mode == 2) {
				int seat= Integer.parseInt(st.nextToken());
				train[idx] = train[idx].substring(0, seat - 1) + "0" + train[idx].substring(seat);
			}
			if(mode == 3) {
				train[idx] = "0" + train[idx].substring(0, 19);
			}
			if(mode == 4) {
				train[idx] = train[idx].substring(1) + "0";
			}
		}
		
		HashMap<String, Boolean> map = new HashMap<>();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(map.get(train[i]) == null) {
				map.put(train[i], true);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
