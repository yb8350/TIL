import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String lv1 = s;
        String lv2 = "";

        do {
            String tmp = lv1.replace("0", "");
            answer[1] += lv1.length() - tmp.length();
            lv1 = tmp;
            lv2 = Integer.toBinaryString(lv1.length());
            lv1 = lv2;
            answer[0]++;
        } while(lv2.length() > 1);
        
        return answer;
    }
}