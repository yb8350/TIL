// https://school.programmers.co.kr/learn/courses/30/lessons/43165
class Solution {
  static int res;
  public int solution(int[] numbers, int target) {
      int answer = 0;
      dfs(numbers, target, 0, 0);
      return res;
  }
  
  public void dfs(int[] numbers, int target, int lv, int num) {
      if(lv == numbers.length) {
          if(num == target) res++;
          return;
      }
      dfs(numbers, target, lv+1, num + numbers[lv]);
      dfs(numbers, target, lv+1, num - numbers[lv]);
  }
}