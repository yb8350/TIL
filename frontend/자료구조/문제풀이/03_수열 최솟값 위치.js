/* user code */
function answer(nums) {
  let result = [];
  let min = Math.min.apply(null, nums);
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] == min) {
      result.push(i)
    }
  }
  return result;
  }
  /* main code */
  let input = [
  // TC: 1
  [5, 2, 10, 2],
  // TC: 2
  [4, 5, 7, 4, 8],
  // TC: 3
  [11, 15, 12, 16, 11, 12],
  ];
  for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1} `);
  console.log(answer(input[i]));
  }