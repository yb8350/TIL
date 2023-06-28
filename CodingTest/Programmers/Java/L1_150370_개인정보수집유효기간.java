// https://school.programmers.co.kr/learn/courses/30/lessons/150370
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int day = Integer.parseInt(today.replace(".", ""));
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> term = new HashMap<>();
        for(String t : terms) {
             String[] tmp = t.split(" ");
            term.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            String[] d = tmp[0].split("\\.");
            int[] date = new int[3];
            date[0] = Integer.parseInt(d[0]);
            date[1] = Integer.parseInt(d[1]) + term.get(tmp[1]);
            date[2] = Integer.parseInt(d[2]) - 1;
            
            while(date[1] > 12) {
                date[1]-=12;
                date[0]+=1;
            }
            
            if(date[2] == 0) {
                date[2] = 28;
                date[1] -= 1;
                if(date[1] == 0) {
                    date[0] -= 1;
                    date[1] = 12;
                }
            }
            int t = date[0] * 10000 + date[1] * 100 + date[2];
            if(day > t) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++ ) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}