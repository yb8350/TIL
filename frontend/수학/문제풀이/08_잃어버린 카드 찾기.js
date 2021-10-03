/* user code */
function answer(a, b, c) {
  let number = 0;
  // sort
  num = [a, b, c];
  num.sort((x, y) => x - y);
  if (b-a > c-b) number = a + (c - b);
  else if (b-a < c-b) number = b + (b - a);
  return number;
  }
  /* main code */
let input = [
  // TC: 1
  [1, 7, 10],
  // TC: 2
  [3, 8, 18],
  // TC: 3
  [2, 5, 11],
  ];
  for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i][0], input[i
  ][1], input[i][2])}`);
  }
  