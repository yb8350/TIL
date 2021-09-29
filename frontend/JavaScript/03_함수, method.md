### 22. 함수

- **함수 :** 다수의 명령문을 코드 블록으로 감싸고 하나의 실행 단위로 만든 코드의 집합
    - 유사한 동작을 하는 코드를 하나로 묶어 범용성을 확대시킨 블록 코드
    - 정의 부분과 호출 부분으로 구성
    - 가급적 1가지 일만을 처리, 매개 변수는 3개 이내로 작성을 권장
    - 자바스크립트는 매개변수와 인수의 개수가 일치하는지 확인하지 않음
    - argument[ ]를 활용하여 매개 변수를 사용할 수 있음
    - return 이후에는 코드가 수행되지 않는다.

```jsx
// 방법1 : 함수 선언식
function add(x, y) {
	return x + y;
}

// 방법2 : 함수 표현식
const add = function (x, y) {
	return x + y;
};

//방법3 : 화살표 함수
const add = (x, y) => x + y;

//함수 호출
add(10, 20, 30) // 30
add(10) // NaN

//argument
function add() {
	return arguments[0] + arguments[1];
}
```

### 23. 재귀 함수

- **재귀 함수 :** 함수 스스로 자신을 참조해 호출하면서 동일한 코드가 계속적으로 수행되는 함수 호출 방법
    - 특정 조건이 되었을 경우, 그만 호출하도록 제한하는 exit code가 필요

```jsx
//factorial
function factorial(x) {
	if (x === 0) return 1;
	return x * factorial(x - 1);
}
```

### 24. 콜백 함수

- **콜백 함수 :** 다른 함수의 매개변수로 전달되어 수행되어지는 함수
- **고차 함수 :** 매개변수를 통해 함수를 받아 호출하는 함수
- **call by value :** 값에 의한 복사로, 함수 내에서 매개 변수 값을 변경시켜도 원본 데이터에는 영향이 없다.
    - 원시 타입을 매개 변수로 넘겼을 때 발생
- **call by reference :** 주소에 대한 복사로, 함수 내에서 매개 변수 값을 변경시키면 원본 데이터에도 영향을 준다.
    - 객체 타입을 매개 변수로 넘겼을 때 발생

```jsx
// 콜백 함수
function add(x, y) {
	return x + y;
}
function sub(x, y) {
	return x - y;
}
function mul(x, y) {
	return x * y;
}
function div(x, y) {
	return x / y;
}

// 고차 함수
function calculator(callback, x, y) {
	return callback(x, y);
}

console.log(calculator(add, 7, 3));
console.log(calculator(sub, 7, 3)); 
console.log(calculator(mul, 7, 3)); 
console.log(calculator(div, 7, 3));
```

### 25. 연습문제

![image](https://user-images.githubusercontent.com/57048162/135320427-890ebe6d-280c-451e-887a-59a2aa7b7031.png)

```jsx
function MAX(x, y) {
	if(x > y) return x;
	else if (x < y) return y;
	else return "same";
}
console.log(MAX(0, 3)); // output: 3
console.log(MAX(-1, 5)); // output: 5
console.log(MAX(100, 7)); // output: 100
```

### 26. method

- **method :** 객체에 저장된 값이 함수인 경우를 뜻한다.
- **this :** 메서드에서 객체 내부의 속성(property) 값을 접근할 수 있는 지시자

![image](https://user-images.githubusercontent.com/57048162/135329635-dfeab9c6-bbd9-499e-8157-5c7079a56ea2.png)

```jsx
//method
	let user = {
	name: "john",
	age: 27,
	hello_func() {
		console.log("hello");
	},
};

//method 변경
unction hello_func() { console.log("hello"); }
function hi_func() { console.log("hi"); }

let obj = {
	name: "john",
	age: 27,
	func: hello_func,
};

obj.func = hi_func;
onsole.log(hi_func == obj.func); // output: true
```





