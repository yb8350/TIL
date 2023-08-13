package com.pttdv.st0815;
import java.util.*;
import java.io.*;
public class Main_S3_1270_전쟁땅따먹기 { //322092kb	4192ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			HashMap<String, Integer> map = new HashMap<>(); // map에 군대 수 저장
			String[] army = in.readLine().split(" ");
			int max = 0;
			String idx = "";
			int len = Integer.parseInt(army[0]);
			
			for(int j = 1; j <= len; j++) {
				if(map.containsKey(army[j])) {
					map.put(army[j], map.get(army[j])+1);
				} else map.put(army[j], 1);
				
				if(max < map.get(army[j])) { // max값 업데이트
					max = map.get(army[j]);
					idx = army[j];
				}
			}
			
			if(len / 2 < max) { // 절반을 초과한다면 출력
				sb.append(idx);
			}
			else sb.append("SYJKGW");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
