//https://school.programmers.co.kr/learn/courses/30/lessons/154539
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {0, numbers[0]});
        
        for(int i = 1; i < numbers.length; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= numbers[i]) {
                    break;
                }
                int[] tmp = stack.pop();
                answer[tmp[0]] = numbers[i];
            }
            stack.push(new int[] {i, numbers[i]});
        }
        
        while(!stack.isEmpty()) {
            int[] tmp = stack.pop();
            answer[tmp[0]] = -1;
        }
        
        return answer;
    }
}