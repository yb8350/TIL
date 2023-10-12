package asdf;
import java.util.*;
import java.io.*;
public class codetree_포탑부수기 {
	static int N, M, K;
	
	static int[][] map;
	static int[][] order;
	
	static int[] min_top, max_top;
	
	static boolean[][] last_visited;
	static int[][][] back;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		order = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while(time++ < K) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0) cnt++;
				}
				if(cnt > 1) break;
			}
			if(cnt == 1) break;
			
			min_top = new int[2];
			max_top = new int[2];
			
			searchMinTop();
			searchMaxTop();
			map[min_top[0]][min_top[1]] += N + M;
			order[min_top[0]][min_top[1]] = time;
			if(!laserDeal()) {
				shellDeal();
			}
			
			topLast();
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > max) {
					max = map[i][j];
				}
			}
		}

		System.out.println(max);
	}

	private static void searchMinTop() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				// 공격력이 가장 낮은 포탑
				if(min > map[i][j]) {
					min_top[0] = i;
					min_top[1] = j;
					min = map[i][j];
				}
				else if(min == map[i][j]) {
					// 가장 최근에 공격한 포탑
					int top_order = order[min_top[0]][min_top[1]];
					if(top_order < order[i][j]) {
						min_top[0] = i;
						min_top[1] = j;
						min = map[i][j];
					}
					else if(top_order == order[i][j]) {
						// 행과 열의 합이 큰 포탑
						int top_sum = min_top[0] + min_top[1];
						if(top_sum < i + j) {
							min_top[0] = i;
							min_top[1] = j;
							min = map[i][j];
						}
						else if(top_sum == i + j) {
							// 열 값이 큰 포탑
							if(min_top[1] < j) {
								min_top[0] = i;
								min_top[1] = j;
								min = map[i][j];
							}
						}
					}
				}
			}
		}
	}

	private static void searchMaxTop() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				// 공격력이 가장 높은 포탑
				if(max < map[i][j]) {
					max_top[0] = i;
					max_top[1] = j;
					max = map[i][j];
				}
				else if(max == map[i][j]) {
					// 가장 오래 전에 공격한 포탑
					int top_order = order[max_top[0]][max_top[1]];
					if(top_order > order[i][j]) {
						max_top[0] = i;
						max_top[1] = j;
						max = map[i][j];
					}
					else if(top_order == order[i][j]) {
						// 행과 열의 합이 작은 포탑
						int top_sum = max_top[0] + max_top[1];
						if(top_sum > i + j) {
							max_top[0] = i;
							max_top[1] = j;
							max = map[i][j];
						}
						else if(top_sum == i + j) {
							// 열 값이 작은 포탑
							if(max_top[1] > j) {
								max_top[0] = i;
								max_top[1] = j;
								max = map[i][j];
							}
						}
					}
				}
			}
		}
	}

	
	
	private static boolean laserDeal() {
		last_visited = new boolean[N][M];
		back = new int[N][M][2];
		
		boolean can = bfs();
		
		if(can) {
			last_visited[min_top[0]][min_top[1]] = true;
			last_visited[max_top[0]][max_top[1]] = true;
			
			int deal = map[min_top[0]][min_top[1]];
			map[max_top[0]][max_top[1]] -= deal;
			int rx = back[max_top[0]][max_top[1]][0];
			int ry = back[max_top[0]][max_top[1]][1];
			
			while(true) {
				if(rx == min_top[0] && ry == min_top[1]) break;
				map[rx][ry] -= deal / 2;
				last_visited[rx][ry] = true;
				
				int tmp1 = back[rx][ry][0];
				int tmp2 = back[rx][ry][1];
				
				rx = tmp1;
				ry = tmp2;
			}
		}
		
		return can;
	}
	
	private static boolean bfs() {
		boolean visited[][] = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {min_top[0], min_top[1]});
		visited[min_top[0]][min_top[1]] = true;
		
		boolean canAttack = false;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			if(tmp[0] == max_top[0] && tmp[1] == max_top[1]) {
				canAttack = true;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int dx = checkOver(tmp[0] + dr[i], N);
				int dy = checkOver(tmp[1] + dc[i], M);
				
				if(!visited[dx][dy] && map[dx][dy] != 0) {
					visited[dx][dy] = true;
					back[dx][dy][0] = tmp[0];
					back[dx][dy][1] = tmp[1];
					q.add(new int[] {dx, dy});
				}
			}
		}
		
		return canAttack;
	}

	private static int checkOver(int idx, int num) {
		if(idx == -1) return num - 1;
		else if(idx == num) return 0;
		return idx;
	}

	private static void shellDeal() {
		int deal = map[min_top[0]][min_top[1]];
		map[max_top[0]][max_top[1]] -= deal;
		
		int[] sr = {0, 0, 1, -1, 1, 1, -1, -1};
		int[] sc = {-1, 1, 0, 0, 1, -1, 1, -1};
		
		last_visited[min_top[0]][min_top[1]] = true;
		last_visited[max_top[0]][max_top[1]] = true;
		
		for(int i = 0; i < 8; i++) {
			int dx = checkOver(max_top[0] + sr[i], N);
			int dy = checkOver(max_top[1] + sc[i], M);
			if(map[dx][dy] != 0 && !last_visited[dx][dy]) {
				map[dx][dy] -= deal / 2;
				last_visited[dx][dy] = true;
			}
		}
	}

	private static void topLast() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] < 0) {
					map[i][j] = 0;
				}
				else if(map[i][j] != 0 && !last_visited[i][j]) {
					map[i][j] += 1;
				}
			}
		}
	}
}
