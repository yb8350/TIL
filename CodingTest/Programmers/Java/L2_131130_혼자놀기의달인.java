// https://school.programmers.co.kr/learn/courses/30/lessons/131130
import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < cards.length; i++) {
            int now = cards[i] - 1;
            int cnt = 0;
            while(!visited[now]) {
                visited[now] = true;
                now = cards[now] - 1;
                cnt++;
            }
            pq.offer(cnt);
        }
        
        if(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            answer = a*b;
        }        
        return answer;
    }
}