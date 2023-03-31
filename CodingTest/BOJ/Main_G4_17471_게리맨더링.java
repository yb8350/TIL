package com.ssafy.ws0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_17471_게리맨더링 { //12928kb	104ms
	static ArrayList<Integer>[] list;
	static int[] population;
	static int N, res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		population = new int[N + 1];
		list = new ArrayList[N + 1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
            population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < num; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
		}
		//풀이
		//1. 부분집합으로 나눈다
		//2. 조건을 확인한다. -> 전부다 하나의 색인지, 서로의 구역이 연결되어있는지
		//3. 인구 수 계산
		
		visited = new boolean[N+1];
		Subset(1); //부분집합
		
		if(res == Integer.MAX_VALUE) System.out.println(res);
		else System.out.println(-1);
	}
	static boolean[] visited;
	public static void Subset(int cnt) {
		if(cnt == N+1) {
			if (check()) { //조건 확인
				//인구수 계산
                int sumA = 0, sumB = 0;
                for (int i = 1; i <= N; i++) {
                    if (visited[i]) sumA += population[i];
                    else sumB += population[i];
                }
 
                res = Math.min(res, Math.abs(sumA - sumB));
            }
			return;
		}
		
		visited[cnt] = true;
		Subset(cnt+1);
		visited[cnt] = false;
		Subset(cnt+1);
	}
	
	private static boolean check() {
        boolean[] v = new boolean[N + 1];
        
        //a구역, b구역 일단 하나씩 찾기
        int aa = -1;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                aa = i;
                break;
            }
        }
        int bb = -1;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bb = i;
                break;
            }
        }
 
        if (aa == -1 || bb == -1) return false; //전부 색이 같은 경우
        
        //a구역 연결확인
        Queue<Integer> q = new LinkedList<>();
        q.add(aa);
        v[aa] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < list[tmp].size(); i++) {
                if (!v[list[tmp].get(i)] && visited[list[tmp].get(i)]) { //방문하지 않은 노드가 a구역이라면
                	v[list[tmp].get(i)] = true;
                	q.add(list[tmp].get(i));                	
                }
            }
        }
        // b구역 연결확인
        q.add(bb);
        v[bb] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 0; i < list[tmp].size(); i++) {
                if (!v[list[tmp].get(i)] && !visited[list[tmp].get(i)]) { //방문하지 않은 노드가 b구역이라면 	
                	v[list[tmp].get(i)] = true;
                	q.add(list[tmp].get(i));
                }
            }
        }
 
        // 한 곳이라도 연결되지 않았다면
        for (int i = 1; i <= N; i++) {
            if (!v[i])
                return false;
        }
 
        return true;
    }
}
