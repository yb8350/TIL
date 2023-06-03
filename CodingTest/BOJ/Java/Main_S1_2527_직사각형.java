package com.ssafy.st0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2527_직사각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] sq1 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] sq2 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			//풀이
			if(sq1[2] < sq2[0] || sq1[3] < sq2[1] || sq1[0] > sq2[2] || sq1[1] > sq2[3])
				System.out.println("d"); //사각형이 겹치지 않는 경우
			else if((sq1[0] == sq2[2] && sq1[3] == sq2[1]) || (sq1[2] == sq2[0] && sq1[3] == sq2[1]) || (sq1[2] == sq2[0] && sq1[1] == sq2[3]) || (sq1[0] == sq2[2] && sq1[1] == sq2[3]))
				System.out.println("c"); //사각형의 점이 겹치는 경우
			else if(sq1[2] == sq2[0] || sq1[3] == sq2[1] || sq1[0] == sq2[2] || sq1[1] == sq2[3])
				System.out.println("b"); //사각형의 선분이 겹치는 경우	
			else
				System.out.println("a"); //사각형이 겹치는 경우
		}
	}
}