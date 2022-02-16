package com.ssafy.ws0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BC {
	int x, y;
	int C;
	int P;
	
	public BC(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		C = c;
		P = p;
	}
}

public class Solution_D0_5644_무선충전 {
	static BC[] bc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dc = {0, -1, 0, 1, 0};
		int[] dr = {0, 0, 1, 0, -1};
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			String[] s = in.readLine().split(" ");
			int M = Integer.parseInt(s[0]);
			int A = Integer.parseInt(s[1]);
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			bc = new BC[A];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				bc[i] = new BC(x, y, C, P);
			}
			
			int Ax = 1, Ay = 1, Bx = 10, By = 10, cnt = 0, res = 0;
			do {
				ArrayList<Integer> Ayes = new ArrayList<>(), Byes = new ArrayList<>();
				// 현재위치에서 충전 가능한 BC 목록 생성
				for (int i = 0; i < A; i++) {
					if(Math.abs(Ax - bc[i].x) + Math.abs(Ay - bc[i].y) <= bc[i].C) {
						Ayes.add(i);
					}
					if(Math.abs(Bx - bc[i].x) + Math.abs(By - bc[i].y) <= bc[i].C) {
						Byes.add(i);
					}
				}
				int max = 0;
				if(Byes.size() == 0 || Ayes.size() == 0) max = maxEnergy(Ayes) + maxEnergy(Byes);
				else {
					// 같은 BC가 있는지 확인
					for (int i = 0; i < Ayes.size(); i++) {
						for (int j = 0; j < Byes.size(); j++) {
							int tmp = 0;
							if(Ayes.get(i) == Byes.get(j)) tmp = bc[Ayes.get(i)].P;
							else tmp = bc[Ayes.get(i)].P + bc[Byes.get(j)].P;
							
							if(max < tmp) max = tmp;
						}
					}
				}
				res += max;
				
				if(cnt == M) break;
				Ax += dr[moveA[cnt]];
				Ay += dc[moveA[cnt]];
				Bx += dr[moveB[cnt]];
				By += dc[moveB[cnt]];
				cnt++;
			}while(cnt <= M);
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static int maxEnergy(ArrayList<Integer> yes) {
		int m = 0;
		for (int i = 0; i < yes.size(); i++) {
			m = m < bc[yes.get(i)].P ? bc[yes.get(i)].P : m;
		}
		return m;
	}
	
}
