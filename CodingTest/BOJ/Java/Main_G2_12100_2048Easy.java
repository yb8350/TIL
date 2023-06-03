package com.ssafy.st0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G2_12100_2048Easy { //31784kb	256ms
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		play(map, 0);
		System.out.println(res);
	}

	private static void play(int[][] map, int cnt) {
		int N = map.length;
		if(cnt == 5) {
			check(map);
			return;
		}

		play(up(map), cnt+1);
		play(down(map), cnt+1);
		play(left(map), cnt+1);
		play(right(map), cnt+1);
	}
	
	private static int[][] up(int[][] map) {
		int N = map.length;
		int[][] remap = new int[N][N];
		for (int i = 0; i < N; i++) {
			List<Integer> list = new LinkedList<>();
			for (int j = 0; j < N; j++) { //0보다 큰 숫자를 모두 리스트에 저장
				if(map[j][i] > 0) {
					list.add(map[j][i]);
				}
			}
			for (int j = 0; j < list.size() - 1; j++) { //같은 숫자 합치기
				if(list.get(j).equals(list.get(j+1))) { 
					list.set(j, list.get(j) * 2);
					list.remove(j+1);
				}
			}
			for (int j = 0; j < list.size(); j++) { //새로운 배열에 저장
				remap[j][i] = list.get(j);
			}
		}
		return remap;
	}
	
	private static int[][] down(int[][] map) {
		int N = map.length;
		int[][] remap = new int[N][N];
		for (int i = 0; i < N; i++) {
			List<Integer> list = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if(map[N - j - 1][i] > 0) {
					list.add(map[N - j - 1][i]);
				}
			}
			for (int j = 0; j < list.size() - 1; j++) {
				if(list.get(j).equals(list.get(j+1))) {
					list.set(j, list.get(j) * 2);
					list.remove(j+1);
				}
			}
			for (int j = 0; j < list.size(); j++) {
				remap[N - j - 1][i] = list.get(j);
			}
		}
		return remap;
	}

	private static int[][] left(int[][] map) {
		int N = map.length;
		int[][] remap = new int[N][N];
		for (int i = 0; i < N; i++) {
			List<Integer> list = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if(map[i][j] > 0) {
					list.add(map[i][j]);
				}
			}
			for (int j = 0; j < list.size() - 1; j++) {
				if(list.get(j).equals(list.get(j+1))) {
					list.set(j, list.get(j) * 2);
					list.remove(j+1);
				}
			}
			for (int j = 0; j < list.size(); j++) {
				remap[i][j] = list.get(j);
			}
		}
		return remap;
	}
	private static int[][] right(int[][] map) {
		int N = map.length;
		int[][] remap = new int[N][N];
		for (int i = 0; i < N; i++) {
			List<Integer> list = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if(map[i][N - j - 1] > 0) {
					list.add(map[i][N - j - 1]);
				}
			}
			for (int j = 0; j < list.size() - 1; j++) {
				if(list.get(j).equals(list.get(j+1))) {
					list.set(j, list.get(j) * 2);
					list.remove(j+1);
				}
			}
			for (int j = 0; j < list.size(); j++) {
				remap[i][N - j - 1] = list.get(j);
			}
		}
		return remap;
	}

	private static void check(int[][] remap) {
		int max = 0;
		int N = remap.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(remap[i][j], max);
			}
		}
		res = Math.max(max, res);
	}
	
}
