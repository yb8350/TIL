// https://school.programmers.co.kr/learn/courses/30/lessons/42576
function solution(participant, completion) {
  let object = {};

  completion.forEach((value) => {
    if (!object[value]) {
      object[value] = 1;
    } else {
      object[value] = object[value] + 1;
    }
  });

  for (let item of participant) {
    if (!object[item] || object[item] == 0) {
      return item;
    } else {
      object[item] = object[item] - 1;
    }
  }

  return -1;
}
