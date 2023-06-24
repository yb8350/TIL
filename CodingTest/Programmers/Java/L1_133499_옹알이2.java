//https://school.programmers.co.kr/learn/courses/30/lessons/133499
import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] keyword = {"aya", "ye", "woo", "ma"};
        
        for(String word : babbling) {
            boolean toggle = false;
            int prev = -1;
            do {
                toggle = false;
                
                for(int i = 0; i < keyword.length; i++) {
                    if(word.indexOf(keyword[i]) == 0 && prev != i) {
                        word = word.substring(keyword[i].length());
                        prev = i;
                        toggle = true;
                        break;
                    }
                }
            } while(toggle);
            
            if(word.length() == 0) answer++;
        }
        
        return answer;
    }
}