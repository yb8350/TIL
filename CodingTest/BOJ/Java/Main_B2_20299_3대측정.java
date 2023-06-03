package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B2_20299_3대측정 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = in.readLine().split(" ");
		//입력받은 값을 각 변수에 넣기
		int N = Integer.parseInt(s[0]); //신청한 동아리의 수
		int S = Integer.parseInt(s[1]); //팀원 3명의 능력 합에 대한 가입조건
		int M = Integer.parseInt(s[2]); //개인에 대한 가입조건
		int cnt = 0; //합격한 동아리의 수
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) { //신청한 동아리 수 만큼 반복
			StringTokenizer st = new StringTokenizer(in.readLine());
			//동아리원의 능력치 입력
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a+b+c > S && a >= M && b >= M && c >= M) { //팀원 합이 S이상이면서 팀원 모두 M이상일 경우 합격
				cnt++; //합격한 동아리 수 증가
				//합격한 팀원을 큐에 추가
				q.offer(a);
				q.offer(b);
				q.offer(c);
			}
		}
		sb.append(cnt).append("\n"); //합격한 팀원 수를 출력
		while(!q.isEmpty()) {
			sb.append(q.poll()).append(" "); //합격한 팀원을 출력
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
