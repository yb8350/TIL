/* user code */
function answer(withdraw, total) {
  let result;
  let money = withdraw % 5 != 0 ? 0 : withdraw + 0.5;
  result = total - money < 0 ? total : total - money;
  return result;
  }
  /* main code */
let input = [
  // TC: 1
  [40, 130.0],
  // TC: 2
  [33, 130.0],
  // TC: 3
  [300, 300.0],
  ];
  for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i][0], input[i
  ][1])}`);
  }
  