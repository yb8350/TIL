// https://school.programmers.co.kr/learn/courses/30/lessons/131127
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i= 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        boolean[] visited = new boolean[discount.length];
        
        for(int i= 0; i < discount.length; i++) {
            if(map.get(discount[i]) != null) {
                int tmp = map.get(discount[i]);
                map.put(discount[i], tmp - 1);
                visited[i] = true;
            }
            
            if(i >= 10 && visited[i - 10]) {
                map.put(discount[i - 10], map.get(discount[i - 10]) + 1);
            }
            
            int cnt = 0;
            for(String item : want) {
                if(map.get(item) == 0) cnt++;
            }
            if(cnt == want.length) answer++;
        }
        
        return answer;
    }
}