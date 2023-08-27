package com.pttdv.st0829;
import java.util.*;
import java.io.*;
public class Main_S4_1544_사이클단어 { //13444kb	88ms
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine()); // 단어 개수
		
		HashMap<String, Integer> map = new HashMap<>(); // 단어 저장할 map
		map.put(in.readLine(), 1); // 첫번째 단어 저장
		for (int i = 1; i < N; i++) {
			boolean toggle = false;
			String word = in.readLine();
			
			// 단어의 순서를 바꿔보면서 map에 있는지 확인한다.
			for (int j = 0; j < word.length(); j++) {
				word = word.substring(1, word.length()) + word.substring(0, 1);
				
				// 만약 같은 단어가 있다면 toggle을 true로 바꾼 후 반복을 중단한다.
				if(map.get(word) != null) {
//					map.put(word, map.get(word)+1);
					toggle = true;
					break;
				}
			}
			
			// 같은 단어가 없었다면 해당 단어를 추가한다.
			if(!toggle) {
				map.put(word, 1);
			}
		}
		
		// map에 저장된 단어의 개수를 출력한다.
		System.out.println(map.size());
	}
}
