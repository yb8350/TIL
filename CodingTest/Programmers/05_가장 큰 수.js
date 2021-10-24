//https://programmers.co.kr/learn/courses/30/lessons/42746?language=javascript
function solution(numbers) {
  var answer = numbers
    .sort((x, y) => {
      return `${x}${y}` - `${y}${x}`;
    })
    .reverse()
    .join("");
  return answer == 0 ? '0' : answer;
}
