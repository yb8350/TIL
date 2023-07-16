// https://school.programmers.co.kr/learn/courses/30/lessons/92334
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> id_idx = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<String>());
            id_idx.put(id_list[i], i);
        }
        
        for(String rep : report) {
            String[] tmp = rep.split(" ");
            HashSet<String> set = map.get(tmp[1]);
            set.add(tmp[0]);
            map.put(tmp[1], set);
        }
        
        for(String m : map.keySet()) {
            if(map.get(m).size() >= k) {
                for(String id : map.get(m)) {
                    answer[id_idx.get(id)]++;
                }
            }
        }
        
        return answer;
    }
}