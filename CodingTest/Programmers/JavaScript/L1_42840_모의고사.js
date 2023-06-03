//https://programmers.co.kr/learn/courses/30/lessons/42840
function solution(answers) {
  var answer = [];
  let a = [1, 2, 3, 4, 5];
  let a_idx = a.length,
    a_score = 0;
  let b = [2, 1, 2, 3, 2, 4, 2, 5];
  let b_idx = b.length,
    b_score = 0;
  let c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  let c_idx = c.length,
    c_score = 0;
  answers.forEach((answer, index) => {
    if (answer === a[index % a_idx]) a_score++;
    if (answer === b[index % b_idx]) b_score++;
    if (answer === c[index % c_idx]) c_score++;
  });
  let max = Math.max(a_score, b_score, c_score);
  if (max == a_score) answer.push(1);
  if (max == b_score) answer.push(2);
  if (max == c_score) answer.push(3);
  return answer;
}
