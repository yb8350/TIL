### 35. 생성자

- **생성자 :** 유사한 객체를 다중으로 만들 때 사용되는 함수
    - 일반적으로 생성자 함수의 첫 글자는 대문자로 시작한다.
    - new 연산자를 통해 객체 생성
- **new.target :** new와 함께 호출했는지 확인해주는 속성

```jsx
function FishBread(flavor, price) {
	this.flavor = flavor;
	this.price = price;
	this.base = "flour";
}

let bread = new FishBread("cream", 1200);

//new.target
function User(name) {
	if (!new.target) {
		return new User(name); //new를 적지 않은 경우 객체를 생성해줌
	}
	this.name = name;
}
let result_1 = User("john"); //new를 작성하지 않았음에도 정상적으로 객체 생성됨 
console.log(result_1);
// output: User { name: 'john' }
```

### 36. Collection

- **Collection :** 구조 혹은 비구조화 형태로 프로그래밍 언어가 제공하는 값을 담을 수 있는 공간
    - Indexed Collection : Array, Typed Array
    - Keyed Collection : Object, Map, Weak Map, Set, Weak Set

### 37. Map

- Map : 다양한 자료형의 key를 허용하고, key-value 형태의 자료형을 저장 가능한 Collection
    - Object에 비해 다양한 key의 사용을 허용하고, 값의 추가/삭제 시 메서드를 통해 수행이 필요하다.

**<Map 메서드>**

- 요소 추가/접근/삭제

```jsx
let map = new Map(); //맵 생성

map.set(key, value); //key와 value를 맵에 추가
map.set("name", "alice").set(123, 789).set(false, "bool_type"); //이렇게 chaining으로 연결해서 한 번에 추가 가능

map.get(key); //key값에 해당하는 value 반환

map.delete(key); //key값에 해당하는 항목 삭제
map.clear(); //맵 전체를 삭제
```

- **Map 반복문**
    - for ...of 구문을 통해 반복문 수행 가능

```jsx
let recipe_juice = new Map([
	["strawberry", 50],
	["banana", 100],
	["ice", 150],
]);

for (let item of recipe_juice.keys()) console.log(item);// output: strawberry banana ice
for (let amount of recipe_juice.values()) console.log(amount);// output: 50 100 150
for (let entity of recipe_juice) console.log(entity);// output: [ 'strawberry', 50 ] [ 'banana', 100 ] [ 'ice', 150 ]
```

- **Map <-> Object 변환**

```jsx
let recipe_juice = new Map([
	["strawberry", 50],
	["banana", 100],
	["ice", 150],
]);

Object.fromEntries(map); //map을 object로 변환
Object.entries(object); //object를 [key, value] 형태로 변환

let recipe_juice_obj = Object.fromEntries(recipe_juice); // output: { strawberry: 50, banana: 100, ice: 150 }
let recipe_juice_kv = Object.entries(recipe_juice_obj); // output: [ [ 'strawberry', 50 ], [ 'banana', 100 ], [ 'ice', 150 ] ]
let recipe_juice_map = new Map(recipe_juice_kv); // output: Map(3) { 'strawberry' => 50, 'banana' => 100, 'ice' => 150
```

### 38. Set

- Set : value만을 저장하여 중복을 허용하지 않는 Collection

**<Set 메서드>**

- **요소 추가/삭제**

```jsx
let set = new Set();

set.add(value); //요소 추가
set.add(1).add(1).add(10).add(20); //이렇게 chaining으로 연결해서 한 번에 추가 가능

set.has(value); //해당 value가 있는지 확인 후 boolean 타입으로 반환

set.delete(value); //요소를 삭제, 삭제의 성공 여부에 따라 boolean 타입으로 반환
map.clear(); //set 전체를 삭제
```

- **Set 반복문**

```jsx
let str = new Set("Hello!");

console.log(str); // output: Set(5) { 'H', 'e', 'l', 'o', '!' }

for (let item of str) console.log(item); // output: H e l o !
for (let item of str.entries()) console.log(item); // output: [ 'H', 'H' ] [ 'e', 'e' ] [ 'l', 'l' ] [ 'o', 'o' ] [ '!', '!' ]
```

### 39. Math

- Math표준 Built-in 객체로써 수학적인 연산을 위한 속성값과 메서드를 제공하는 객체
    - Math는 생성자 함수가 아니며, 모든 속성과 메서드는 정적이기에 Math.function()으로 언제든 호출 가능

**<Math 메서드>**

```jsx
Math.E; //오일러 상수r
Math.PI; //파이 값

Math.max(...x); //최대값
Math.min(...x); //최소값
Math.abs(x); //절대값

Math.max.apply(null, arr); //인수로 배열을 받을 경우의 최대값
Math.min.apply(null, arr); //인수로 배열을 받을 경우의 최대값

Math.random(); //0과 1 사이의 랜덤 난수값
Number.parseInt(Math.random() * 10); // 정수의 랜덤 값

Math.pow(x, y); //제곱, x의 y승
Math.sqrt(x); //제곱근, 루트

Math.round(x); //소수의 반올림
Math.ceil(x); //소수의 올림
Math.floor(x); //소수의 내림
```

### 40. Date

- Date : 표준 Built-in 객체로서 날짜와 시간을 위한 속성값과 메서드를 제공하는 객체
    - 1970년 1월 1일 UTC(협정 세계시) 자정과의 시간 차이를 밀리초로 나타나내는 정수값으로 표현

**<Date 메서드>**

- Date 생성자

```jsx
// Default
let datee_now = new Date(); // output: 2021-07-31T13:35:00.570Z
let date_now_str = Date(); // output: Sat Jul 31 2021 22:35:00 GMT+0900 (대한민국 표준시)

// milliseconds
let date_ms_1 = new Date(0); // output: 1970-01-01T00:00:00.000Z
let date_ms_2 = new Date(24 * 3600 * 1000); // output: 1970-01-02T00:00:00.000Z

// date string
let date_str = new Date("2020-01-01"); // 2020-01-01T00:00:00.000Z

// year, month(0 ~ 11), date, hours, minutes, seconds, ms
let date_params_1 = new Date(2021, 0, 1); // output: 2020-12-31T15:00:00.000Z, 표준시로 결과가 나옴
let date_params_2 = new Date(Date.UTC(2021, 0, 1)); // output: 2021-01-01T00:00:00.000Z
let date_params_3 = new Date(Date.UTC(2021, 0, 1, 6, 12, 18, 24)); // output: 2021-01-01T06:12:18.024Z
```

- 날짜 정보 얻기

```jsx
let date = new Date();

date.getFullYear(); //년 반환
date.getMonth(); //월 반환
date.getDate(); //일 반환
date.getDay(); //요일 반환

date.getHours(); //표준시 반환
date.getUTCHours(); //UTC 시 반환
date.getMinutes(); //분 반환
date.getSeconds(); //초 반환

date.getTime()); //1970.1.1. 와의 차이(ms)
date.getTimezoneOffset(); //표준 시간과의 차이(min)
```

- 날짜 정보 설정

```jsx
let date = new Date();

date.setFullYear(year); //년 설정
date.setMonth(); //월 설정
date.setDate(); //일 설정
date.setHours(); //시 설정
date.setMinutes(); //분 설정
date.setSeconds(); //초 설정

date.setFullYear(2020, 3, 15); // output: 2020-04-15T14:01:35.091Z
date.setDate(0); // 이전 달의 마지막 날(ex. 4월이었을 경우 3월 31일로 설정)

```

- parse

```jsx
Date.parse("2020-03-31T00:00:00.000"); // output: 1584230400000 => 결과는 표준시로 나온다. z가 없으면 utc기준, 있으면 표준시 기준으로 설정
new Date(Date.parse("2020-03-31T00:00:00.000Z")); // output: 2020-03-31T00:00:00.000Z

```

- benchmark
    - 벤치마크 측정 대상 함수 전,후로 시간을 비교하여 알고리즘 성능을 측정할 수 있다.

```jsx
function dateSub(old_date, new_date) {
return new_date - old_date;
}
function getTime(old_date, new_date) {
return new_date.getTime() - old_date.getTime();
}
function benchmark(callback_func) {
let date_1 = new Date("2020-01-01");
let date_2 = new Date();
let start = Date.now();
for (let i = 0; i < 100000; i++) {
callback_func(date_1, date_2);
}
return Date.now() - start;
}
console.log("dateSub: " + benchmark(dateSub) + "ms"); // dateSub: 17ms
console.log("getTime: " + benchmark(getTime) + "ms"); // getTime: 4ms
```

### 41. N차원 Array

- N차원 배열 : 배열 안에 N개 만큼 배열이 존재하는 객체

```jsx
let array = [
	[101, 102, 103],
	[201, 202, 203],
	[301, 302, 303],
];

console.log(array[0]); // output: [ 101, 102, 103 ]
console.log(array[1][0]); // output: 201

for (let i = 0; i < array.length; i++) {
	for (let j = 0; j < array[i].length; j++) {
		console.log(array[i][j]);
	}
} /** output: 101 ... 303 */

array.pop(); // array: [ [ 101, 102, 103 ], [ 201, 202, 203 ] ]
array.push([401, 402, 403]); // array: [ [ 101, 102, 103 ], [ 201, 202, 203 ], [ 401, 402, 403 ]
```
