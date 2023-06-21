// https://school.programmers.co.kr/learn/courses/30/lessons/172927
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int len = picks[0]+picks[1]+picks[2];
        
        if(len * 5 > minerals.length) {
            len = minerals.length;
        } else {
            len *= 5;
        }
        
        int cnt = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[2]-a[2]);

        for(int i = 0; i < len; i+=5) { 
            int[] tmp = new int[3];
            
            for(int j = 0; j < 5; j++) {
                if(i+j < len) {
                    if(minerals[i+j].equals("diamond")) {
                        tmp[0] += 1;
                        tmp[1] += 5;
                        tmp[2] += 25;
                    }
                    else if(minerals[i+j].equals("iron")) {
                        tmp[0] += 1;
                        tmp[1] += 1;
                        tmp[2] += 5;
                    }
                    else if(minerals[i+j].equals("stone")) {
                        tmp[0] += 1;
                        tmp[1] += 1;
                        tmp[2] += 1;
                    }
                }
            }
            pq.offer(tmp);
        }
        
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int idx = picks[0] == 0 ? picks[1] == 0 ? 2 : 1 : 0;
            picks[idx] = picks[idx]-1;
            answer += tmp[idx];
        }
        
        return answer;
    }
}