// https://school.programmers.co.kr/learn/courses/30/lessons/12981
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int fail = -1;
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(words[0], true);
        for(int i = 1; i < words.length; i++) {
            String word = words[i];
            if(word.charAt(0) != words[i-1].charAt(words[i-1].length()-1) || map.get(word) != null) {
                fail = i;
                break;
            }
            map.put(word, true);
        }

        if(fail != -1) {
            answer[0] = fail % n + 1;
            answer[1] = fail / n + 1;
        }
        return answer;
    }
}