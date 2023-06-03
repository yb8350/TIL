package com.ssafy.ws0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G4_17135_캐슬디펜스 { //22532kb	364ms
	static LinkedList<int[]> enemy;
	static int N, M, D;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		enemy = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) enemy.add(new int[] {i, j});
			}
		}

		//풀이
		// 1. np를 이용해 궁수 자리 배치
		// 2. 적과의 거리를 계산하여 공격할 수 있는 적 찾아서 공격
		// 3. 잡은 적의 수를 결과값에 더해준 후 적 이동
		// 4. 적이 없어질때까지 2~3 반복
		// 5. 잡은 적의 수 최댓값을 비교
		int res = 0;
		int[] castle = new int[M];
		for (int i = M - 1; i > M - 4; i--) { //np 조합 배열
			castle[i] = 2;
		}
		
		do {
			int c = attack(castle); //공격을 통해 없앨 수 있는 적의 수 반환
			res = Math.max(c, res); //최댓값 비교
		}while(np(castle));
		
		System.out.println(res);
	}

	private static int attack(int[] castle) {
		int cnt = 0;
		
		LinkedList<int[]> arr = new LinkedList<>();
		for(int i = 0; i < enemy.size(); i++) { //테스트를 위해 적 위치 복사
			arr.add(new int[] {enemy.get(i)[0], enemy.get(i)[1]});
		}
		
		while(!arr.isEmpty()) {
			int idx = 0;
			int[][] shoot = new int[3][2]; //공격하는 적의 위치를 저장하는 배열
			for(int i = 0; i < 3; i++) {
				Arrays.fill(shoot[i], -1); //공격할 적 위치 초기화
			}
			for (int i = 0; i < M; i++) {
				if(castle[i] == 2) {
					int dist = Integer.MAX_VALUE;
					for (int j = arr.size() - 1; j > -1; j--) {
						int[] e = arr.get(j);
						int d = Math.abs(N - e[0]) + Math.abs(i - e[1]);
						if(d <= D && dist > d) { //공격 범위 내의 가장 가까운 적이라면 거리와 위치 저장
							dist = d;
							shoot[idx] = e;
						} else if(dist == d && shoot[idx][1] > e[1]) shoot[idx] = e; //거리가 같다면 더 왼쪽의 적으로 설정
					}
					idx++;
				}
			}
			
			for (int i = 0; i < 3; i++) {
				if(arr.remove(shoot[i])) cnt++;//공격할 수 있는 적이라면 공격 후 처치한 적의 수 증가
			}

			if(arr.isEmpty()) break; // 모든 적이 처치됐으면 반복 종료
			
			for (int i = 0; i < arr.size(); i++) { //모든 적 앞으로 한 칸씩 이동
				if(++arr.get(i)[0] == N) { //적이 성까지 진입했다면 삭제
					arr.remove(i);
					i--;
				}
			}
		}
		return cnt;
	}

	private static boolean np(int[] arr) {
		int N = arr.length;
		
		int i = N - 1;
		while(i > 0 && arr[i - 1] >= arr[i]) i--;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(arr[i - 1] >= arr[j]) j--;
		
		swap(i-1, j, arr);
		
		int k = N - 1;
		while(i < k) swap(i++, k--, arr);
		
		return true;
	}

	private static void swap(int i, int j, int[] arr) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
