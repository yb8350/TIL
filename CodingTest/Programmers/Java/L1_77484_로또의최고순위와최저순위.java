// https://school.programmers.co.kr/learn/courses/30/lessons/77484
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int zero = 0;
        for(int num : lottos) {
            if(num != 0) {
                set.add(num);
            }
            else zero++;
        }
        int win = 0;
        for(int num : win_nums) {
            if(!set.add(num)) {
                win++;
            }
        }

        answer[0] = rank(win + zero);
        answer[1] = rank(win);

        return answer;
    }
    
    public int rank(int n) {
        if(n == 6) return 1;
        else if(n == 5) return 2;
        else if(n == 4) return 3;
        else if(n == 3) return 4;
        else if(n == 2) return 5;
        else return 6;
    }
}