//https://school.programmers.co.kr/learn/courses/30/lessons/87390
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        int cnt = 0;
        
        long j = left % n;
        
        st:
        for(long i = left / n; i < n; i++) {
            for(; j < n; j++) {
                if(i <= j) answer[cnt++] = (int)j+1;
                else answer[cnt++] = (int)i+1;
                
                if(cnt == right - left + 1) break st;
            }
            j = 0;
        }
        
        return answer;
    }
}