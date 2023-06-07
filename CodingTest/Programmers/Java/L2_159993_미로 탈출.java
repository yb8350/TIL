// https://school.programmers.co.kr/learn/courses/30/lessons/159993
import java.util.*;

class Solution {
    static int[][] maze;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public int solution(String[] maps) {
        int answer = 0;
        maze = new int[maps.length][maps[0].length()];
        
        int[] start = new int[] {-1, -1};
        int[] lever = new int[] {-1, -1};
        int[] end = new int[] {-1, -1};
        for(int i = 0; i < maps.length; i++){
            String[] map = maps[i].split("");
            for(int j = 0; j < map.length; j++) {
                if(map[j].equals("S")) start = new int[] {i, j};
                else if(map[j].equals("L")) lever = new int[] {i, j};
                else if(map[j].equals("E")) end = new int[] {i, j};
                else if(map[j].equals("X")) maze[i][j] = -1;
            }
        }
        
        int tmp = bfs(start, lever);     
        if(tmp > -1) {
            answer += tmp;
            tmp = bfs(lever, end);
            System.out.println(tmp);
            if(tmp > -1) return answer + tmp;
        }
        
        return -1;
    }
    
    public int bfs(int[] s, int[] e) {
        Queue<int[]> q = new LinkedList<>();
        int[][] map = new int[maze.length][maze[0].length];
        for(int i = 0; i < map.length; i++) {
            map[i] = maze[i].clone();
        }
        boolean[][] visited = new boolean[map.length][map[0].length];
        q.offer(s);
        visited[s[0]][s[1]] = true;
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            
            if(tmp[0] == e[0] && tmp[1] == e[1]) return map[tmp[0]][tmp[1]];
            
            for(int i = 0; i < 4; i++) {
                int dx = tmp[0] + dr[i];
                int dy = tmp[1] + dc[i];
                if(dx > -1 && dx < map.length && dy > -1 && dy < map[0].length && map[dx][dy] > -1 && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    map[dx][dy] = map[tmp[0]][tmp[1]] + 1;
                    q.offer(new int[] {dx, dy}); 
                }
            }
        }
        return -1;
    }
}