// https://school.programmers.co.kr/learn/courses/30/lessons/138476
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int tan : tangerine) {
            if(map.get(tan) == null) map.put(tan, 1);
            else map.put(tan, map.get(tan)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int m : map.keySet()) {
            pq.offer(new int[] {m, map.get(m)});
        }
        
        while(!pq.isEmpty()) {
            int tmp = pq.poll()[1];
            if(cnt + tmp >= k) {
                answer++;
                break;
            }
            else if(cnt + tmp < k) {
                cnt += tmp;
                answer++;
            }
        }
        return answer;
    }
}