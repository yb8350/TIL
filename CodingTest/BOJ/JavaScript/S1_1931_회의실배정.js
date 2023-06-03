const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let N = parseInt(input[0]);
let time = [];
for (let i = 0; i < N; i++) {
  let [a, b] = input[i + 1].split(" ");
  time.push([Number(a), Number(b)]);
}

time = time.sort((a, b) => (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));

let prev_time = 0;
let result = 0;
for (let i = 0; i < N; i++) {
  if (prev_time <= time[i][0]) {
    prev_time = time[i][1];
    result += 1;
  }
}

console.log(result);
