package com.pttdv.st0704;
import java.util.*;
import java.io.*;
public class Main_S2_2644_촌수계산 {
	static int a, b, res = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 : 전체 사람의 수
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// 입력 : 촌수가 궁금한 두 사람의 번호
		st = new StringTokenizer(in.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		// 입력 : 촌수 관계의 수
		st = new StringTokenizer(in.readLine());		
		int M = Integer.parseInt(st.nextToken());
		
		// 0. 촌수 관계를 저장할 리스트 생성
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 입력 : 촌수 관계를 리스트에 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		
		boolean[] visited = new boolean[N+1]; //방문 체크
		
		// 1. a부터 시작해서 촌수를 확인하는 재귀함수
		SearchDegree(list, visited, a, 0);
		
		System.out.println(res);
	}

	private static void SearchDegree(ArrayList<Integer>[] list, boolean[] visited, int now, int cnt) {
		// b를 찾으면 촌수를 기록한 후 종료
		if(now == b) {
			res = cnt;
			return;
		}
		
		// 현재 사람의 촌수 관계 리스트를 가져온다.
		ArrayList<Integer> tmp = list[now];
		
		// 재귀함수를 통해 현재 사람과의 촌수 관계를 확인한다.
		for (int i = 0; i < tmp.size(); i++) {
			if(!visited[tmp.get(i)]) {
				visited[tmp.get(i)] = true;
				SearchDegree(list, visited, tmp.get(i), cnt+1);
			}
		}
	}
}	
