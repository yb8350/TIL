### 27. Number

> 자바스크립트에서 일반적인 숫자는 64비트 형식의 IEEE-754 표준 기반 형태로 저장되는 자료형
> 
- **지수 표기법 :** 아주 큰 숫자나 아주 작은 숫자를 표기하기 위해 e를 이용해서 0의 개수를 대체 표기 가능
- **진법 표기 :** 0x(16진수), 0o(8진수), 0b(2진수)

```jsx
// 지수 표기법
let billion_1 = 1000000000; // 10억
let billion_2 = 1e9; // 1 + 0 9개

// 진법 표기
console.log(0x0f); // output: 15
console.log(0o17); // output: 15
console.log(0b1111); // output: 15
```

**<Number 상수 값>**

```jsx
console.log(Number.MAX_VALUE); // output: 1.7976931348623157e+308 => 지수로 표기되는 양수 최대값
console.log(Number.MIN_VALUE); // output: 5e-324 => 지수로 표기되는 양수 최소값

console.log(Number.MAX_SAFE_INTEGER); // output: 9007199254740991 => 안전하게 표기되는 최대 양수 값
console.log(Number.MIN_SAFE_INTEGER); // output: -9007199254740991 => 안전하게 표기되는 최소 음수 값

console.log(Number.POSITIVE_INFINITY); // output: Infinity => 무한대 양수 값
console.log(Number.NEGATIVE_INFINITY); // output: -Infinity => 무한대 음수 값

console.log(Number.NaN); // output: NaN => 부동소수점 산술에서 정의되지 않거나 표현할 수 없는 값으로 해석될 수 있는 숫자 데이터 유형
console.log(NaN); // output: NaN
```

**<Number 메서드>**

- 형 변환

```jsx
let num = 1e-6;

num.toString(); //숫자를 문자열로 변환
String(num); //숫자를 문자열로 변환
num + "" //숫자를 문자열로 변환
```

- 자리 수 표현

```jsx
let num = 123.456;

num.toFixed(n); //소수의 n자리까지 표현
num.toPrecision(n) //정수와 소수의 자리 수를 합한 n만큼 표현
```

- Number 자료형 확인

```jsx
Number.isNaN(num); //num이 NaN인지 확인, boolean 타입으로 반환
Number.isFinite(num); //num이 정상적인 유한수인지 확인, boolean 타입으로 반환
```

- 정수와 실수 형 변환

```jsx
Number.parseInt(num); //num을 정수로 변환
Number.parseFloat(num); //num을 실수로 변환
```

### 28. String, 29. 문자열 변환

> 텍스트 길이에 상관없이 문자열 형태로 저장되는 자료형, 항상 UTF-16 형식을 따른다.
> 
- **정의 방법 :** " "(큰 따옴표), ' '(작은 따옴표), ` `(백틱), String( )
- **문자 표기 :** 줄바꿈 `\n` , ?? `\r` , \ `\\` , Tab `\t` , 유니코드 `\u{}`

**<String 메서드>**

- 문자열 길이

```jsx
let str = "Hello";

str.length; //문자열 길이 확인
```

- 문자열 접근

```jsx
let str = "Hello";

str.charAt(index); //문자열 내 개별 문자 접근, 인덱스 위치의 문자 출력
str.charCodeAt(index); //문자열 내 개별 문자 접근, 인덱스 위치의 아스키 코드 출력
str[index]; //문자열 내 개별 문자 접근
```

- 문자열 검색

```jsx
let str = "Hello";

str.indexOf(substr); //찾고자하는 문자 or 문자열을 입력하여 문자열 검색, 해당 substr의 인덱스를 반환
str.indexOf(substr, pos); //입력한 substr가 위치한 pos 번째의 인덱스를 반환
str.lastIndexOf(substr); //마지막으로 등장하는 substr의 인덱스를 반환

str.includes(substr); //문자열 안에 substr이 포함되어있는지 boolean타입으로 반환
str.startsWith(substr); //substr로 시작하는지 확인하여 boolean타입으로 반환
str.endsWith(substr); //substr로 끝나는지 확인하여 boolean타입으로 반환
```

- 문자열 변환

```jsx
let str = "Hello";

str.toUpperCase(); //문자열을 대문자로 변환
str.toLowerCase(); //문자열을 소문자로 변환
```

- 문자열 치환
    - 정규표현식 사용 가능(/치환문자열/g(전체)i(대소문자 구분x)

```jsx
let str = "Hello";

str.replace(origin_str, change_str); //탐색할 문자열과 변환할 문자열을 입력하여 해당하는 문자열을 변환
```

- 문자열 추출

```jsx
let str = "Hello";

str.silce(start, end); //문자열을 start인덱스부터 end인덱스 전까지 잘라 반환
str.substring(start, end); //slice와 동일하지만 시작이 클 경우 start와 end의 위치를 바꾼 후 문자열을 잘라서 반환
str.substr(start, length); //start인덱스부터 length 길이 만큼 문자열을 잘라서 반환
```

- 문자열 분할

```jsx
let str = "Hello hi wow";

str.split(Separator, limit); //Separator를 기준으로 문자열을 배열로 분할(ex. " ", "", ","), limit를 입력하면 그만큼의 인덱스까지만 배열이 만들어짐
```

### 30. Array , 31. 배열 조작 , 32. 배열 탐색 - 변형

> 여러 개체(Entity)값을 순차적으로 나열한 자료구조, 배열 내 값을 요소(element)라고 하며 배열 요소는 index로 접근한다.
> 
- 자바스크립트에서의 배열은 다른 언어에서 말하는 일반적인 배열이 아닌 Hash 기반의 객체
- 메모리가 연속적인 밀집 배열(dense array)이 아닌 비연속적인 희소 배열(sparse array)이다.

**<Array 메서드>**

- 배열 선언/접근/속성

```jsx
let arr_ = new Array(num); // num크기의 배열 생성
let arr = []; //배열 생성

arr[index]; //배열의 index 위치에 접근

array.length; //배열 요소의 갯수 확인
```

- 배열 타입 확인

```jsx
Array.isArray(value); //배열인지 확인
```

- 배열 요소 삭제

```jsx
let arr = [];

delete arr[index]; //해당 index의 요소 삭제, 삭제해도 배열 사이즈가 그대로인 문제가 있다.
```

- 배열 조작

```jsx
let arr = [];

// LIFO-back
arr.push(element); //배열의 끝에 값을 추가
arr.pop() //배열의 가장 마지막 값을 삭제

// LIFO - front
arr.unshift(element); //배열의 첫 번째에 값을 추가
arr.shift(); //배열의 가장 첫 번째 값을 삭제

arr.splice(index); //index 값 이후의 요소를 삭제
arr.splice(index, num, element...); //index 값 이후로 num개 만큼 삭제, element를 추가하면 삭제된 위치에 요소 추가

arr.slice(start, end); //start index부터 end index 전까지 잘라서 반환

arr.concat(arg1, arg2...); //입력한 arg를 기존 배열과 병합, 인수에 요소도 배열도 입력 가능
```

- 배열 반복문

```jsx
//for ...length : index 접근
for (let i = 0; i < fruits.length; i++) {
	console.log(fruits[i]);
}

//for ...of : element 접근
for (let fruit of fruits) {
	console.log(fruit);
}

//for ...in : key 접근
for (let key in fruits) {
	console.log(fruits[key]);
}
```

- 배열 탐색

```jsx
let arr = [];

arr.indexOf(item, from); //입력한 item의 index를 앞에서부터 탐색, from을 통해 몇 번째에 위치하는 item의 index를 찾을지 지정 가능
arr.lastIndexOf(item, from); //입력한 item의 index를 뒤에서부터 탐색, from을 통해 몇 번째에 위치하는 item의 index를 찾을지 지정 가능
arr.includes(item); //입력한 item이 포함되어있는지 boolean 타입으로 반환
```

- 배열 변형(callback 미사용)

```jsx
let arr = [];

arr.sort(); // 배열의 값을 오름차순으로 정렬
arr.reverse(); // 배열의 값을 내림차순으로 정렬

arr.join(separator); //배열을 문자열로 변환, separator 값으로 배열의 요소를 구분한다.
```

### 33. 고차함수, 34. 그 외 고차함수

> 하나 이상의 함수를 매개변수로 취하거나 함수를 결과로 반환하는 함수
> 

**<고차함수 메서드>**

- sort( )
    - 일반적인 sort( )의 문제점 : 4가 10보다 뒤쪽에 정렬
        
        ⇒ 원인 : sort 메서드로 정렬될 때 배열의 요소가 일시적으로 문자열로 변경된다.
        
    - 한계점 : 대소문자가 구분되어 정렬
    - 해결 : sort()함수의 매개변수로 함수를 넣어 고차함수를 이용한 정렬을 수행

```jsx
// before
let nums = [1, -1, 4, 0, 10, 20, 12];
console.log(nums.sort()); // output: [ -1, 0, 1, 10, 12, 20, 4 ]
console.log(nums.reverse()); // output: [ 4, 20, 12, 10, 1, 0, -1 ]

// after
let ascending_order = function (x, y) { return x - y; };
let descending_order = function (x, y) { return y - x; };
let nums = [1, -1, 4, 0, 10, 20, 12];
console.log(nums.sort(ascending_order)); // output: [ -1, 0, 1, 4, 10, 12, 20]
console.log(nums.sort(descending_order)); // output: [ 20, 12, 10, 4, 1, 0, -1 ]

// 대소문자 구분 없애는 콜백함수
let ascending_order = function (x, y) {
	x = x.toUpperCase();
	y = y.toUpperCase();
	if (x > y) return 1;
	else if (y > x) return -1;
	else return 0;
};
let descending_order = function (x, y) {
	x = x.toUpperCase();
	y = y.toUpperCase();
	if (x < y) return 1;
	else if (y < x) return -1;
	else return 0;
};

// 위의 상황을 모두 합친 콜백함수
let ascending_order = function (x, y) {
	if (typeof x === "string") x = x.toUpperCase();
	if (typeof y === "string") y = y.toUpperCase();
	return x > y ? 1 : -1;
};
let descending_order = function (x, y) {
	if (typeof x === "string") x = x.toUpperCase();
	if (typeof y === "string") y = y.toUpperCase();
	return x < y ? 1 : -1;
};
```

- forEach( )

```jsx
let arr = [1, 2, 3];

arr.forEach(function(item, index, array){}); //배열 요소 별로 콜백함수 각각에 실행
//item: 배열 요소, index: 배열 위치, array: 배열

arr.forEach(function (i) {
	console.log(i);
}); // ouptut: 1 2 3
```

- map( )

```jsx
let nums = [1, 2, 3, 4, 5];

arr.map(function(item, index, array){}); // 배열 요소 별로 함수 실행한 결과를 배열로 반환
//item: 배열 요소, index: 배열 위치, array: 배열

let use_map = arr.map(function (item) {
	return item * 2;
});
console.log(use_map); // output: [ 2, 4, 6, 8, 10]
```

- find( )

```jsx
let arr = [
	{ name: "bob", age: 17, job: false },
	{ name: "alice", age: 20, job: false },
	{ name: "john", age: 27, job: true },
];

arr.find(function(item, index, array){}); //콜백 함수 조건을 만족하는 단 하나의 값을 반환
//item: 배열 요소, index: 배열 위치, array: 배열

let find_job = arr.find(function (user) {
	return user.job == false;
});
console.log(find_job); // output: { name: 'bob', age: 17, job: false }
```

- filter( )

```jsx
let arr = [
	{ name: "bob", age: 17, job: false },
	{ name: "alice", age: 20, job: false },
	{ name: "john", age: 27, job: true },
];

arr.filter(function(item, index, array){}); //콜백 함수의 조건을 만족하는 값 모두를 배열로 반환
//item: 배열 요소, index: 배열 위치, array: 배열

let filter_job = arr.filter(function (user) {
	return user.job == false;
});
console.log(filter_job);
/* [ { name: 'bob', age: 17, job: false },
{ name: 'alice', age: 20, job: false } ] */

```

- reduce( )

```jsx
let arr = [1, 2, 3, 4, 5];

arr.reduce(function(accmulator, item, index, array){}, initial); //요소 별 함수 수행 누적 결과값 반환
//accumulator: 이전 함수 결과(initial로 초기값 설정 가능), item: 배열 요소, index: 배열 위치, array: 배열

let call_count = 0;
console.log("result\tvalue\tindex");
let sum = nums.reduce(function (accumulator, item, index, array) {
	console.log(accumulator, "\t\t", item, "\t\t", index);
	call_count++;
	return accumulator + item;
}, 0); // initial 없다면, 즉 초기값을 입력하지 않으면 배열의 1번째 값을 초기값으로 사용하고 배열의 2번째 값부터 시작한다.
/* output
result value index
0        1     0
1        2     1
3        3     2
6        4     3
10       5     4 */

console.log(call_count); // output: 5
console.log(sum); // output: 15
```
