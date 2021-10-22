//https://programmers.co.kr/learn/courses/30/lessons/42576?language=javascript
function solution(participant, completion) {
    for (let item of completion) {
        if (completion.includes(item)) {
          const idx = participant.indexOf(item);
          if (idx > -1) participant.splice(idx, 1);
        }
    }
  return participant[0];
}
