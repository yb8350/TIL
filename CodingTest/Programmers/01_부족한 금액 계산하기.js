//https://programmers.co.kr/learn/courses/30/lessons/82612?language=javascript

function solution(price, money, count) {
    var answer = -1;
    let pr = 0;
    for (let i = 1; i <= count; i++) {
        pr += price * i;
    }
    answer = pr - money < 0 ? 0 : pr - money;
    return answer;
}
