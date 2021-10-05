/* user code */
function answer(nums) {
  let result = [];
  let m1 = Math.max.apply(null, nums);
  result.push(m1);
  nums.splice(nums.indexOf(m1), 1);
  result.push(Math.max.apply(null, nums));

  return result;
  }
  
  /* main code */
let input = [
  // TC: 1
  [-11, 5, 18, -2, -3, 6, 4, 17, 10, 9],
  // TC: 2
  [3, 7, -14, 2, -6, 13, -20, -2, -7, 6, -17, -
  5, 14, -9, 19],
  // TC: 3
  [
  -15, -4, -8, 12, 12, -8, -8, 9, 10, 15,
  -2, 10, -14, 2, 13, 19, -9, 3, -18, 14,
  ],
  ];
  for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1} `);
  console.log(answer(input[i]));
  }