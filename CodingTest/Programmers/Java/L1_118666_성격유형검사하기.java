// https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=java
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        map.put('T', 0);
        map.put('R', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        for(int i = 0; i < survey.length; i++) {
            char no = survey[i].charAt(0);
            char yes = survey[i].charAt(1);
            sumScore(map, no, yes, choices[i]);
        }
        
        if(map.get('T') > map.get('R')) sb.append("T");
        else sb.append("R");
        if(map.get('F') > map.get('C')) sb.append("F");
        else sb.append("C");
        if(map.get('M') > map.get('J')) sb.append("M");
        else sb.append("J");
        if(map.get('N') > map.get('A')) sb.append("N");
        else sb.append("A");
        return sb.toString();
    }
    public void sumScore(LinkedHashMap<Character, Integer> map, char no, char yes, int n) {
        if(n == 1) {
            map.put(no, map.get(no)+3);
        }
        else if(n == 2) {
            map.put(no, map.get(no)+2);
        }
        else if(n == 3) {
            map.put(no, map.get(no)+1);
        }
        if(n == 7) {
            map.put(yes, map.get(yes)+3);
        }
        else if(n == 6) {
            map.put(yes, map.get(yes)+2);
        }
        else if(n == 5) {
            map.put(yes, map.get(yes)+1);
        }
    }
}