// https://school.programmers.co.kr/learn/courses/30/lessons/17680
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        HashMap<String, Boolean> map = new HashMap<>();
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(int i = 0; i < cities.length; i++) {
            String word = cities[i].toUpperCase();
            boolean tf = map.get(word) != null ? map.get(word) : false;
            
            if(tf) {
                int len = q.size();
                for(int j = 0; j < len; j++) {
                    String tmp = q.poll();
                    if(word.equals(tmp)) continue;
                    q.add(tmp);
                }
                q.add(word);
                answer++;
                
            } else {
                if(q.size() < cacheSize) {
                    q.add(word);
                    map.put(word, true);
                } else if(q.size() >= cacheSize) {
                    String tmp = q.poll();
                    map.put(tmp, false);
                    q.add(word);
                    map.put(word, true);
                }
                answer += 5;
            }
        }
        
        
        return answer;
    }
}