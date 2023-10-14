package asdf;
import java.util.*;
import java.io.*;

class Player {
	int r, c, d, s, g;

	public Player(int r, int c, int d, int s, int g) {
		super();
		this.r = r;
		this.c = c;
		this.d = d;
		this.s = s;
		this.g = g;
	}
}

public class codetree_싸움땅 {
	static int N, M, K;
	static int[] point;
	static int[][] map;
	
	static PriorityQueue<Integer>[] gun;
	static Player[] player;
	
	static int[] dr = {-1, 0, 1, 0, -1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1, 0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		point = new int[M];
		map = new int[N][N];
		
		gun = new PriorityQueue[N * N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				gun[i * N + j] = new PriorityQueue<>((a, b) -> b - a);
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp != 0) gun[i * N + j].add(tmp);
			}
		}
		
		player = new Player[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			player[i] = new Player(r, c, d, s, 0);
			map[r][c] = i + 1;
		}
		
		for(int round = 0; round < K; round++) {
			for (int i = 0; i < M; i++) {
				playerMove(i);
			}
		}
		
		for (int i = 0; i < M; i++) {
			sb.append(point[i]).append(" ");
		}
		System.out.println(sb);

	}

	private static void playerMove(int i) {
		//플레이어 이동가능한지 확인
		int dx = player[i].r + dr[player[i].d];
		int dy = player[i].c + dc[player[i].d];
		
		// 벽이라면 방향 전환
		if(dx < 0 || dx >= N || dy < 0 || dy >= N) {
			player[i].d = (player[i].d + 2) % 4;
			dx = player[i].r + dr[player[i].d];
			dy = player[i].c + dc[player[i].d];
		}
		
		//다른 플레이어 없으면
		if(map[dx][dy] == 0) {
			// 현재 칸으로 플레이어 이동
			map[player[i].r][player[i].c] = 0;
			map[dx][dy] = i + 1;
			player[i].r = dx;
			player[i].c = dy;
			
			// 총 획득 여부 체크
			if(!gun[dx * N + dy].isEmpty() && gun[dx * N + dy].peek() > player[i].g) {
				if(player[i].g != 0) {
					int tmp = player[i].g;
					gun[dx * N + dy].add(tmp);
				}
				player[i].g = gun[dx * N + dy].poll();
			}
		}
		//플레이어 있으면
		else {
			int j = map[dx][dy] - 1;
			playerBattle(i, j, dx, dy);
		}
	}

	private static void playerBattle(int i, int j, int dx, int dy) {
		// 능력치 비교
		int p1 = player[i].s + player[i].g;
		int p2 = player[j].s + player[j].g;
		
		int win = -1;
		int lose = -1;
		
		if(p1 > p2) {
			win = i;
			lose = j;
		}
		else if(p1 < p2) {
			win = j;
			lose = i;
		}
		else {
			if(player[i].s > player[j].s) {
				win = i;
				lose = j;
			}
			else {
				win = j;
				lose = i;
			}
		}
		
		point[win] += Math.abs(p1 - p2);
		
		map[player[win].r][player[win].c] = 0;
		map[player[lose].r][player[lose].c] = 0;
		
		// 진 플레이어
		losePlayer(lose, dx, dy);
		
		// 이긴 플레이어
		winPlayer(win, dx, dy);
	}

	private static void losePlayer(int i, int dx, int dy) {
		// 현재 자리에 총을 내려놓는다.
		if(player[i].g != 0) {
			int tmp = player[i].g;
			gun[dx * N + dy].add(tmp);
			player[i].g = 0;
		}
		
		//진 플레이어 이동
		for (int j = 0; j < 4; j++) {
			int tx = dx + dr[player[i].d];
			int ty = dy + dc[player[i].d];
			
			if(tx > -1 && tx < N && ty > -1 && ty < N && map[tx][ty] == 0) {
				map[tx][ty] = i + 1;
				player[i].r = tx;
				player[i].c = ty;
				break;
			}
			player[i].d = (player[i].d + 1) % 4;
		}
		
		// 이동한 칸에 더 나은 총이 있다면 획득
		if(!gun[player[i].r * N + player[i].c].isEmpty() && gun[player[i].r * N + player[i].c].peek() > player[i].g) {
			if(player[i].g != 0) {
				int tmp = player[i].g;
				gun[player[i].r * N + player[i].c].add(tmp);
			}
			player[i].g = gun[player[i].r * N + player[i].c].poll();
		}
	}

	private static void winPlayer(int i, int dx, int dy) {
		// 배틀이 일어난 위치에 이긴 플레이어 자리잡기
		map[dx][dy] = i + 1;
		player[i].r = dx;
		player[i].c = dy;
		
		// 이동한 칸에 더 나은 총이 있다면 획득
		if(!gun[player[i].r * N + player[i].c].isEmpty() && gun[player[i].r * N + player[i].c].peek() > player[i].g) {
			if(player[i].g != 0) {
				int tmp = player[i].g;
				gun[player[i].r * N + player[i].c].add(tmp);
			}
			player[i].g = gun[player[i].r * N + player[i].c].poll();
		}
	}
}
