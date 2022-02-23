package com.ssafy.st0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S5_2628_종이자르기 { //11644kb 76ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine());
		LinkedList<Integer> row = new LinkedList<>();
		LinkedList<Integer> column = new LinkedList<>();
		row.add(R);
		column.add(C);
		//풀이
		//d, k를 입력 받은 후 k값에 맞게 가로 혹은 세로를 자른다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if (d == 0)
				cut(column, k);
			else
				cut(row, k);
		}
		
		//구해놓은 가로, 세로의 길이를 각각 모두 곱해준 후 최댓값을 찾는다.
		int max = 0;
		for (int i = 0; i < row.size(); i++) {
			for (int j = 0; j < column.size(); j++) {
				int tmp = row.get(i) * column.get(j);
				if (tmp > max)
					max = tmp;
			}
		}
		
		//출력
		System.out.println(max);
	}

	private static void cut(LinkedList<Integer> rc, int k) {
		for (int j = 0; j < rc.size(); j++) {
			int num = rc.get(j);
			int tmp = k - num;
			if (tmp < 0) {
				rc.remove(j);
				rc.add(j, k);
				rc.add(j + 1, num - k);
				break;
			} else
				k = tmp;
		}
	}
}
