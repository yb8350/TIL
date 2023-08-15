// https://school.programmers.co.kr/learn/courses/30/lessons/42584
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {0, prices[0]});
        
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] tmp = stack.pop();
                answer[tmp[0]] = i - tmp[0];
            }
            stack.push(new int[] {i, prices[i]});
        }
 
        
        while(!stack.isEmpty()) {
            int[] tmp = stack.pop();
            answer[tmp[0]] = N - tmp[0] - 1;
        }
        
        return answer;
    }
}