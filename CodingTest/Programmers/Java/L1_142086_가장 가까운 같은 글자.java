// https://school.programmers.co.kr/learn/courses/30/lessons/142086
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        for(int i = 0; i < s.length(); i++) {
            answer[i] = alphabet[s.charAt(i)-97] == -1 ? -1 : (i+1) - alphabet[s.charAt(i)-97];
            alphabet[s.charAt(i)-97] = i+1;
        }
        return answer;
    }
}