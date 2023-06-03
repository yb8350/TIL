// https://school.programmers.co.kr/learn/courses/30/lessons/12946
import java.util.*;

class Solution {
    static ArrayList<int[]> res;
    public int[][] solution(int n) {
        int[][] answer = {};
        res = new ArrayList<>();
        
        hanoi(n, 1, 2, 3);

        // 리스트 -> 배열 변환
        answer = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
    
    public static void hanoi(int cnt, int From, int temp, int To) {
        if(cnt == 1) {
            res.add(new int[] {From, To});
        }
        else {
            hanoi(cnt-1, From, To, temp);
            res.add(new int[] {From, To});
            hanoi(cnt-1, temp, From, To);
        }
    }
}