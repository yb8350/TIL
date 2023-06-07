// https://school.programmers.co.kr/learn/courses/30/lessons/138477

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] rank = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = 0;
        for(int i = 0; i < score.length; i++) {
            if(len < k) {
                pq.offer(score[i]);
                len++;
            }
            else if(pq.peek() < score[i]) {
                pq.poll();
                pq.offer(score[i]);
            }
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}