/* user code */
function answer(employee) {
  let employee_id;
  employee_id = employee.indexOf(Math.max.apply(null, employee)) + 1;
  return employee_id;
  }

  /* main code */
let input = [
  // TC: 1
  [3, 7, 9, 6, 1],
  // TC: 2
  [2, 7, 1, 4, 3, 0, 5],
  // TC: 3
  [7, 5, 0, 1, 2, 12, 6],
  ];
  for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
  }
  