package asdf;
import java.util.*;
import java.io.*;

class Mover {
	int r, c;
	boolean fin;
	
	public Mover(int r, int c, boolean fin) {
		super();
		this.r = r;
		this.c = c;
		this.fin = fin;
	}
}

public class codetree_메이즈러너 {
	static int N, M, K;
	static int[][] map;
	
	static Mover[] player;
	static int[] exit;
	
	static int out_cnt, move_cnt;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		player = new Mover[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			player[i] = new Mover(r, c, false);
		}
		
		exit = new int[2];
		st = new StringTokenizer(in.readLine());
		exit[0] = Integer.parseInt(st.nextToken()) - 1;
		exit[1] = Integer.parseInt(st.nextToken()) - 1;
		
		for (int round = 0; round < K; round++) {
			playerMove();
			if(out_cnt == M) {
				break;
			}
			mapRotate();
		}
		
		System.out.println(move_cnt);
		System.out.println((exit[0] + 1) + " " + (exit[1] + 1));
	}

	private static void playerMove() {
		for (int i = 0; i < M; i++) {
			if(player[i].fin) continue;
			
			int r = player[i].r;
			int c = player[i].c;
			int dst = Math.abs(exit[0] - r) + Math.abs(exit[1] - c);
			
			for (int j = 0; j < 4; j++) {
				int dx = r + dr[j];
				int dy = c + dc[j];
				int now_dst = Math.abs(exit[0] - dx) + Math.abs(exit[1] - dy);
				
				if(dx > -1 && dx < N && dy > -1 && dy < N && dst > now_dst && map[dx][dy] == 0) {
					player[i].r = dx;
					player[i].c = dy;
					move_cnt++;
					break;
				}
			}
			
			if(player[i].r == exit[0] && player[i].c == exit[1]) {
				player[i].fin = true;
				out_cnt++;
			}
		}
	}

	private static void mapRotate() {
		// 정사각형 탐색
		ArrayList<Integer> arr = new ArrayList<>();
		int size = -1, sr = -1, sc = -1;
		
		loop:
		for (int s = 2; s <= N; s++) {
			for (int i = 0; i <= N - s; i++) {
				for (int j = 0; j <= N - s; j++) {
					if(i <= exit[0] && exit[0] < i + s && j <= exit[1] && exit[1] < j + s) {
						for (int k = 0; k < M; k++) {
							if(!player[k].fin && i <= player[k].r && player[k].r < i + s && j <= player[k].c && player[k].c < j + s) {
								arr.add(k);
							}
						}
						if(arr.size() > 0) {
							size = s;
							sr = i;
							sc = j;
							break loop;
						}
					}
				}
			}
		}
		System.out.println(size + " " + sr + " " + sc);
		
		// 정사각형 회전
		int[][] box = new int[size][size];
		for(int i = sr; i < sr + size; i++) {
			for (int j = sc; j < sc + size; j++) {
				box[i - sr][j - sc] = map[i][j];
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(box[i][j] != 0) {
					map[j + sr][(size - i - 1) + sc] = box[i][j] - 1;
				}
				else {
					map[j + sr][(size - i - 1) + sc] = 0;
				}
			}
		}
		
		// 플레이어 회전
		for(int i = 0; i < arr.size(); i++) {
			int pr = player[arr.get(i)].r - sr;
			int pc = player[arr.get(i)].c - sc;
			
			player[arr.get(i)].r = pc + sr;
			player[arr.get(i)].c = (size - pr - 1) + sc;
		}
		
		// 출구 회전
		int er = exit[0] - sr;
		int ec = exit[1] - sc;
		
		exit[0] = ec + sr;
		exit[1] = (size - er - 1) + sc;
	}
}
