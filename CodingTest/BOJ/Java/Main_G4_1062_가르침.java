package com.pttdv.st0810;
import java.util.*;
import java.io.*;
public class Main_G4_1062_가르침 { //12452kb	276ms
	static int N, K, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		String[] str = new String[N]; // 주어진 단어에서 앞,뒤 4글자씩 제외한 단어 저장
		boolean[] visited = new boolean[26]; // 영어 알파벳 26개의 사용 여부를 체크
		
		if(K < 5) System.out.println(0); // K가 5이하이면 모든 단어 배울 수 없음
		else if(K == 26) System.out.println(N); // K가 26이면 모든 단어 배울 수 있음
		else {
			for(int i = 0; i < N; i++) {
				String tmp = in.readLine();
				str[i] = tmp.substring(4, tmp.length()-4);
			}
			
			// 남극 단어에 항상 들어가는 5개의 단어 사용 처리
			visited['a'-97] = true;
			visited['n'-97] = true;
			visited['t'-97] = true;
			visited['i'-97] = true;
			visited['c'-97] = true;
			
			dfs(str, visited, 0, 0);
			System.out.println(answer);
		}
	}
	private static void dfs(String[] str, boolean[] visited, int cnt, int num) {
		if(cnt == K - 5) {
			// 현재까지 사용 가능한 글자로 몇 개의 단어를 배울 수 있는지 체크
			int res = 0;
			for(int i = 0; i < N; i++) {
				boolean toggle = true;
				for(int j = 0; j < str[i].length(); j++) {
					if(!visited[str[i].charAt(j) - 97]) {
						toggle = false;
						break;
					}
				}
				if(toggle) res++;
			}
			
			answer = Math.max(res, answer);
			return;
		}
		
		// 사용 가능한 단어를 체크
		for(int i = num; i < 26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(str, visited, cnt+1, i+1);
				visited[i] = false;
			}
		}
		
	}
}
