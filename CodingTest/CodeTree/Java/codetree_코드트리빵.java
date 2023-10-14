package asdf;
import java.util.*;
import java.io.*;

class Human {
	int r, c;
	boolean fin;
	
	public Human(int r, int c, boolean fin) {
		super();
		this.r = r;
		this.c = c;
		this.fin = fin;
	}
}

public class codetree_코드트리빵 {
	static int N, M, fin_cnt;
	static int[][] map;
	static Human[] human;
	static int[][] store;
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		store = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			store[i][0] = Integer.parseInt(st.nextToken()) - 1;
			store[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		human = new Human[M];
		int time = 0;
		while(true) {
			if(fin_cnt == M) {
				break;
			}
			
			visited = new boolean[N][N];
			for (int i = 0; i < M; i++) {
				if(i > time) break;
				
				if(i == time) {
					setBasecamp(i);
				}
				else {
					if(!human[i].fin) {
						moveStore(i);
					}
				}
			}
			lockMap();
			time++;
		}
		
		System.out.println(time);
	}

	private static void setBasecamp(int idx) {
		int min = Integer.MAX_VALUE;
		int[] fix_bc = new int[2];
		
		// 편의점에서 가장 가까운 베이스캠프 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					Queue<int[]> q = new LinkedList<int[]>();
					int[][] tmpmap = new int[N][N];
					tmpmap[i][j] = 1;
					q.add(new int[] {i, j});
					
					// bfs
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						
						// 편의점 도착 시, 최단 거리인지 확인 후 종료
						if(tmp[0] == store[idx][0] && tmp[1] == store[idx][1]) {
							if(min > tmpmap[tmp[0]][tmp[1]]) {
								min = tmpmap[tmp[0]][tmp[1]];
								fix_bc[0] = i;
								fix_bc[1] = j;
							}
							break;
						}
						
						for (int k = 0; k < 4; k++) {
							int dx = tmp[0] + dr[k];
							int dy = tmp[1] + dc[k];
							if(dx > -1 && dx < N && dy > -1 && dy < N && map[dx][dy] >= 0 && tmpmap[dx][dy] == 0 && !visited[dx][dy]) {
								tmpmap[dx][dy] = tmpmap[tmp[0]][tmp[1]] + 1;
								q.add(new int[] {dx, dy});
							}
						}
					}
				}
			}
		}
		
		human[idx] = new Human(fix_bc[0], fix_bc[1], false);
		visited[fix_bc[0]][fix_bc[1]] = true;
	}

	private static void moveStore(int idx) {
		int r = human[idx].r;
		int c = human[idx].c;
		
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] tmpmap = new int[N][N];
		int[][][] backstep = new int[N][N][2];
		tmpmap[r][c] = 1;
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			if(tmp[0] == store[idx][0] && tmp[1] == store[idx][1]) {
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				int dx = tmp[0] + dr[k];
				int dy = tmp[1] + dc[k];
				if(dx > -1 && dx < N && dy > -1 && dy < N && map[dx][dy] >= 0 && tmpmap[dx][dy] == 0 && !visited[dx][dy]) {
					tmpmap[dx][dy] = tmpmap[tmp[0]][tmp[1]] + 1;
					q.add(new int[] {dx, dy});
					backstep[dx][dy][0] = tmp[0];
					backstep[dx][dy][1] = tmp[1];
				}
			}
		}
		
		// 역추적
		Queue<int[]> qq = new LinkedList<int[]>();
		qq.add(new int[] {store[idx][0], store[idx][1]});
		while(!qq.isEmpty()) {
			int[] tmp = qq.poll();
			int br = backstep[tmp[0]][tmp[1]][0];
			int bc = backstep[tmp[0]][tmp[1]][1];
			
			if(br == r && bc == c) {
				human[idx].r = tmp[0];
				human[idx].c = tmp[1];
				break;
			}
			
			qq.add(new int[] {br, bc});
		}
		
		// 편의점 도착했을 경우
		if(human[idx].r == store[idx][0] && human[idx].c == store[idx][1]) {
			visited[store[idx][0]][store[idx][1]] = true;
			human[idx].fin = true;
			fin_cnt++;
		}
	}

	private static void lockMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) {
					map[i][j] = -1;
				}
			}
		}
	}
}
