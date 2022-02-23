package com.ssafy.st0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_S5_2635_수이어가기 { //16616kb 156ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		//풀이
		int max = 2; //최대갯수 저장할 변수
		ArrayList<Integer> res = new ArrayList<>(); //결과 저장할 배열
		for (int i = 1; i <= N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(N); //첫번째값 추가
			list.add(i); //두번째값 추가
			int j = 0, tmp = 0;
			do {
				tmp = list.get(j) - list.get(++j); //뺄셈해보기
				if(tmp > -1) list.add(tmp); //양수일 경우 리스트에 추가
			}while(tmp > -1); //음수일 경우 반복 중지
			
			if(max < list.size()) { //최댓값 확인
				max = list.size();
				res = (ArrayList<Integer>) list.clone();
			}
		}
		
		//출력
		System.out.println(max);
		for(int r : res) {
			System.out.print(r + " ");
		}
	}
}
