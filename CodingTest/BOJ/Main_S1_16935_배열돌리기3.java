package com.ssafy.ws0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_16935_배열돌리기3 {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N, M, R;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = in.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < R; i++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				mode1();
				break;
			case 2:
				mode2();
				break;
			case 3:
				mode3();
				int tmp = N;
				N = M;
				M = tmp;
				break;
			case 4:
				mode4();
				tmp = N;
				N = M;
				M = tmp;
				break;
			case 5:
				mode5();
				break;
			case 6:
				mode6();
				break;
			default:
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void mode1() {
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N-i-1][j];
				arr[N-i-1][j] = temp;
			}
		}
	}
	public static void mode2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][M-j-1];
				arr[i][M-j-1] = temp;
			}
		}
	}
	
	public static void mode3() {
		int[][] res = new int[M][N]; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res[j][N-i-1]=arr[i][j];
			}
		}
		arr = res;
	}
	public static void mode4() {
		int[][] res = new int[M][N]; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res[M-j-1][i]=arr[i][j];
			}
		}
		arr = res;
	}
	
	public static void mode5() {
		int[][] tmp1 = new int[N/2][M/2];
		int[][] tmp2 = new int[N/2][M/2];
		int[][] tmp3 = new int[N/2][M/2];
		int[][] tmp4 = new int[N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tmp1[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				tmp2[i][j - M/2] = arr[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				tmp3[i - N/2][j - M/2] = arr[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				tmp4[i - N/2][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[i][j+M/2] = tmp1[i][j];
				arr[i+N/2][j+M/2] = tmp2[i][j];
				arr[i+N/2][j] = tmp3[i][j];
				arr[i][j] = tmp4[i][j];
			}
		}
	}
	
	public static void mode6() {
		int[][] tmp1 = new int[N/2][M/2];
		int[][] tmp2 = new int[N/2][M/2];
		int[][] tmp3 = new int[N/2][M/2];
		int[][] tmp4 = new int[N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tmp1[i][j] = arr[i][j];
			}
		}
		for (int i = 0; i < N/2; i++) {
			for (int j = M/2; j < M; j++) {
				tmp2[i][j - M/2] = arr[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = M/2; j < M; j++) {
				tmp3[i - N/2][j - M/2] = arr[i][j];
			}
		}
		for (int i = N/2; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				tmp4[i - N/2][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[i+N/2][j] = tmp1[i][j];
				arr[i][j] = tmp2[i][j];
				arr[i][j+M/2] = tmp3[i][j];
				arr[i+N/2][j+M/2]  = tmp4[i][j];
			}
		}
	}
	
}
