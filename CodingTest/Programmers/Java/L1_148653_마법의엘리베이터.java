// https://school.programmers.co.kr/learn/courses/30/lessons/148653
class Solution {
  static int res = Integer.MAX_VALUE;
  public int solution(int storey) {
      int answer = 0;
        
      while(storey != 0) {
          int num = storey % 10;
          System.out.println(num);
          if(num < 5) {
              storey -= num;
              answer += num;
          }
          else if(num > 5) {
              storey += (10 - num);
              answer += (10 - num);
          }
          else {
              if(storey / 10 % 10 < 5) {
                  storey -= num;
                  answer += num;
              }
              else {
                  storey += (10 - num);
                  answer += (10 - num);
              }
          }
          System.out.println(storey);
          storey /= 10;
      }
      
      return answer;
  }
}