package com.ssafy.ws0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish {
	int r;
	int c;
	int size;
	
	public Fish(int r, int c, int size) {
		super();
		this.r = r;
		this.c = c;
		this.size = size;
	}
}

public class Main_G3_16236_아기상어 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[][] sea = new int[N][N];
		ArrayList<Fish> fish = new ArrayList<>();
		int sr = -1, sc = -1, ssize = 2, cnt = 1, time = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken()); //값 대입
				if(sea[i][j] == 9) { //아기 상어 위치 저장
					sr = i;
					sc = j;
					sea[sr][sc] = 0;
				}
				else if(sea[i][j] > 0) fish.add(new Fish(i, j, sea[i][j])); //물고기 위치 저장
			}
		}
		
		//풀이
		while(true) {
			int mindst = Integer.MAX_VALUE, yam = -1;
			
			int[] dr = {-1, 0, 1, 0};
			int[] dc = {0, 1, 0, -1};
			int[][] distance = new int[N][N];
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(new int[] {sr, sc});
			while(!q.isEmpty()) { //현재 위치에서 이동에 필요한 거리를 표시하는 맵 만들기
				int[] tmp = q.poll();
				for (int i = 0; i < 4; i++) {
					if(tmp[0]+dr[i] < 0 || tmp[0]+dr[i] >= N || tmp[1]+dc[i] < 0 || tmp[1]+dc[i] >= N) continue;
					else if(distance[tmp[0]+dr[i]][tmp[1]+dc[i]] == 0 && sea[tmp[0]+dr[i]][tmp[1]+dc[i]] <= ssize) {
						distance[tmp[0]+dr[i]][tmp[1]+dc[i]] = distance[tmp[0]][tmp[1]] + 1 ;
						q.offer(new int[] {tmp[0]+dr[i], tmp[1]+dc[i]});
					}
				}
			}
			
			for (int i = 0; i < fish.size(); i++) { //먹을 수 있는 물고기 확인
				Fish f = fish.get(i);
				if(f.size < ssize) { //아기상어보다 물고기가 작을 때
					int dst = distance[f.r][f.c]; //거리 확인
					if(dst != 0 && mindst > dst) { //거리가 가장 가까운 물고기 기록
						mindst = dst;
						yam = i;
					}
				}
			}
			
			if(yam == -1) break; //먹을 수 있는 물고기가 없을 경우
			else { //있다면 아기 상어 이동
				Fish f = fish.get(yam);
				time += mindst;
				sr = f.r;
				sc = f.c;
				fish.remove(yam); //물고기 삭제
				sea[sr][sc] = 0; //맵에서도 삭제
				
				if(ssize == cnt) { //상어 크기만큼 먹었을 경우
					ssize++; // 사이즈 증가
					cnt = 1; //카운트 초기화
				}
				else cnt++; //아닐 경우 카운트 누적
			}
		}
		
		System.out.println(time);
	}
}
