package com.ssafy.st0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main_G3_15811_복면산 { //159500kb	652ms
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		char[][] word = new char[3][18];
		for (int i = 0; i < 3; i++) {
			word[i] = st.nextToken().toCharArray();
		}
		
		//풀이
		boolean alphabet[] = new boolean[26];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < word[i].length; j++) {
				alphabet[word[i][j] - 'A'] = true; //알파벳 사용 여부 체크
			}
		}
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			if(alphabet[i]) cnt++; //알파벳 개수 체크
		}
		
		if(cnt > 10) { //사용된 알파벳이 10개 넘으면
			System.out.println("NO"); //NO 출력
			return;
		}
		
		//np 조합과 순열을 이용
		int[] arr = new int[10];
		
		for (int i = 0; i < cnt; i++) { 
			arr[9 - i] = 1; //알파벳 개수만큼 조합하기 위해 np에 사용할 배열 생성
		}
		
		do {//조합을 통해 사용할 숫자를 결정
			int[] num = new int[cnt];
			for (int i = 0, c = 0; i < 10; i++) {
				if(arr[i] == 1) num[c++] = i; //사용할 숫자를 num 배열에 저장
			}
			int[] m = new int[26]; //특정 알파벳에 매칭할 값을 저장하는 배열
			do {
				int n = 0;
				for (int i = 0; i < 26; i++) {
					if(alphabet[i]) m[i] = num[n++]; //알파벳이 사용중이면 그 위치에 매칭 값을 저장
				}

				long[] s = new long[3];
				for (int i = 0; i < 3; i++) { //모든 단어를 숫자로 변환
					s[i] += m[word[i][0] - 'A']; 
					for (int j = 1; j < word[i].length; j++) {
						s[i] *= 10;
						s[i] += m[word[i][j] - 'A'];
					}
				}
				if(s[0] + s[1] == s[2]) { //변환한 값이 맞아떨어지면
					System.out.println("YES"); //YES 출력
					return;
				}
			}while(np(num));
		}while(np(arr));
		System.out.println("NO"); //끝까지 확인했음에도 맞는 걸 못찾았으므로 NO 출력
	}

	private static boolean np(int[] arr) {
		int N = arr.length;
		
		int i = N - 1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		if(i == 0) return false;
		
		int j = N - 1;
		while( arr[i-1] >= arr[j]) j--;
		
		swap(arr, i-1, j);
		
		int k = N - 1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	
}
