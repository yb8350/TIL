/* user code */
function answer(x, y) {
  let result = [];
  if(x > y) {
    let box = x;
    x = y;
    y = box;
  }
  for(let i = x; i <= y; i++) {
    result.push(i);
  }
  return result;
}

  /* main code */
let input = [
  // TC: 1
  [3, 7],
  // TC: 2
  [8, 3],
  // TC: 3
  [12, 10],
  ];
  for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1} `);
  console.log(answer(input[i][0], input[i][1]));
  }
  