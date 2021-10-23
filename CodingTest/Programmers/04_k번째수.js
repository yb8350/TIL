//https://programmers.co.kr/learn/courses/30/lessons/42748?language=javascript
function solution(array, commands) {
    var answer = [];
    for (let i = 0; i < commands.length; i++) {
        answer.push(array.slice(commands[i][0]-1, commands[i][1]).sort((x,y)=>x-y)[commands[i][2]-1]);
    }
    
    return answer;
}
