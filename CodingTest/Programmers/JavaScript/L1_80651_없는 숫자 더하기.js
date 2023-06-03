//https://programmers.co.kr/learn/courses/30/lessons/86051?language=javascript
function solution(numbers) {
    var answer = 0;
    let num = [0,1,2,3,4,5,6,7,8,9];
    let difference = num.filter(x => !numbers.includes(x));
    for (let item of difference) answer += item;

    return answer;
}
