### 3. 자바스크립트 학습환경

- 오프라인 개발 환경 : VSCode
- 온라인 개발 환경 : Leetcode

**node.js 설치**

⇒ 설치 확인 : cmd창에 node 라고 입력하면 버전이 나오는 것을 통해 알 수 있다.

**VSCode 설치**

⇒ 확장프로그램

- code runner : vscode와 nodejs를 연결시켜준다.
- prittier : vscode에서 코드를 작성할 때 가시성 높게 변환해준다.

### 4. Overview

**JavaScript란?**

- 객체 기반의 스크립트 프로그래밍 언어(인터프리터 언어)
- ECMAScript 사양을 준수하는 범용 스크립팅 언어
- 자바와 연관x, 웹의 동적 동작을 구현하기 위해 제작
- Mocha → LiveScript → JavaScript로 명칭 변경

**ECMAScript란?**

- Ecma International이 ECMA-262 기술 규격에 따라 정의하고 있는 표준화된 스크립트 프로그래밍 언어
- 자바스크립트를 표준화하기 위해 만들어졌으며, 액션스크립트와 J스크립트 등 다른 구현체도 포함
- Ecma International : 정보 통신에 대한 표준을 제정하는 비영리 표준화 기구
- ECMA-262 : Ecma International에서 제정한 기술 규격의 이름, 범용 목적의 스크립트 언어 명세 기술

### 5. 기본 입출력

- 출력

```jsx
console.log("hello world");
```

- 입력

```jsx
const fs = require("fs");
const input = fs.readFileSync("./input.txt", "utf8");

console.log(input);
```

### 6. 기본 용어

- Java Script는 문법의 대부분을 C, C++, Java로부터 차용하여 제작된 스크립트 기반의 언어이다.
- 다수의 표현식(expression)으로 하나의 명령문(statement)이 만들어지며, 명령문으로 프로그램이 수행된다.
- 식별자 : 스크립트에서 변수나 함수에 이름을 붙일 때 사용하는 단어
    - 대소문자를 구별
    - 키워드 사용 불가
    - 숫자로 시작 불가
    - 특수문자는 _와 $만 허용
    - 공백 문자 포함 불가
- 주석

```jsx
//이렇게 사용

/*
	이렇게도 사용
*/
```

### 7. 변수와 상수

- **변수(let) :** 변경 가능한 값을 저장하기 위한 기억 공간
    - 사용하기 전 반드시 선언을 해주어야 한다.
    - 중복 선언 불가능
    - 한 줄에 여러 변수 선언과 초기화 가능
- **상수(const) :** 변경 불가능한 값을 저장하기 위한 기억 공간
    - 사용하기 전 반드시 선언을 해주어야 한다.
    - 중복 선언 불가능
    - 상수를 지정할 때 이름을 보통 대문자로 표기
- **호이스팅 :** 코드에 선언된 변수 및 함수를 유효한 범위의 코드 상단으로 끌어 올리는 작업
    - var를 이용해 선언하면, 어디에서 선언을 하든 할당이 되지 않은 상태로 변수의 선언만 맨 위로 올라간다.


### 8. 자료형 ~ 9. 객체타입

![image](https://user-images.githubusercontent.com/57048162/135098222-73f1b402-8e34-4633-9a27-39606f1453c9.png)
- 객체 수정 : `object.key = 값`
- 객체 삭제 : `delete object.key`

```jsx
let str = "hello, world";
console.log(typeof str); //string
console.log(typeof undefined); //undefined
console.log(typeof null); //object => 하위 버전 호환성으로 object 표기

let check = 10 > 3; // 비교를 통해 boolean 결과 생성 -> true
console.log(check); //true

let user = {
name: "john", // key: "name", value: "john"
age: 27, // key: age, value: 27
};

console.log(typeof user); //object
console.log(typeof user.name); //string
console.log(typeof user.age); //number
```

### 10. 객체 복사 문제점

- object를 복사할 때는 대상 전체가 아닌 object 내 주소 값만 복사가 된다.
- **얕은 복사(Shallow copy)**
    - 객체 내 또 다른 객체가 있다면 복사되지 않음

```jsx
let user = {
	name: "john",
	age: 23,
};

// 1번째 방법 : 반복문
let admin = {};
for (let key in user) {
	admin[key] = user[key];
}

// 2번째 방법 : 함수 사용
let admin_obj = Object.assign({}, user);

// 3번째 방법 : 전개 연산자
let admin_spread = { ...user };
```

- **깊은 복사(Deep copy)**

```jsx
let user = {
	name: "john",
	age: 23,
	sizes: { height: 180, weight: 72 },
};

// 1번째 방법 : 재귀 함수
function copyObj(obj) {
	let result = {};
	for (let key in obj) {
		if (typeof obj[key] === "object") result[key] = copyObj(obj[key]);
		else result[key] = obj[key];
	}
	return result;
}
let admin = copyObj(user);

// 2번째 방법 : json 객체 이용 - 객체를 문자열로 바꿨다가 다시 객체로 변경
let admin_json = JSON.parse(JSON.stringify(user));
```

### 11. 형 변환

- 자바스크립트는 느슨한 타입 언어 or 동적 타입 언어 ⇒ 변수의 자료형을 명시적으로 선언할 필요가 없다.
- 연산자로 인한 계산이나 변수에 전달되는 값은 자동으로 암묵적 형 변환 수행
- 강제적 형 변환을 위해서는 자료형 함수를 이용해 명시적으로 형 변환을 수행

```jsx
// type of string
console.log(String(123)); // output: 123
console.log(String(1 / 0)); // output: Infinity
console.log(String(-1 / 0)); // output: -Infinity
console.log(String(NaN)); // output: NaN
console.log(String(true)); // output: true
console.log(String(false)); // output: false
console.log(String(undefined)); // output: undefined
console.log(String(null)); // output: null

// type of number
console.log(Number("")); // output: 0
console.log(Number("123")); // output: 123
console.log(Number("hello")); // output: NaN
console.log(Number("123hello")); // output: NaN
console.log(Number(true)); // output: 1
console.log(Number(false)); // output: 0
console.log(Number(null)); // output: 0
console.log(Number(undefined)); // output: NaN
console.log(parseInt("123.123")); // output: 123
console.log(parseFloat("123.123")); // output: 123.123

//type of boolean
onsole.log(Boolean("")); // output: false
console.log(Boolean("123")); // output: true
console.log(Boolean("hello")); // output: true
console.log(Boolean("0")); // output: true
console.log(Boolean(0)); // output: false
console.log(Boolean(123)); // output: true
console.log(Boolean(NaN)); // output: false
console.log(Boolean(null)); // output: false
console.log(Boolean(undefined)); // output: false
```

### 12. 산술대입 연산자
- [연산자 우선순위](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Operator_Precedence#%ED%91%9C)
- **산술 연산자 :** 수학적 계산을 위해 제공하는 연산자

```jsx
// 덧셈 연산자: +
console.log(10 + 5);

// 뺄셈 연산자: -
console.log(10 - 5);

// 곱셈 연산자: *
console.log(10 * 5);

// 나눗셈 연산자: /
console.log(10 / 4); // 2.5
console.log(parseInt(10 / 4)); // 2

// 나머지 연산자: %
console.log(7 % 3);

// 거듭제곱 연산자: **
console.log(2 ** 3);
```

- **대입 연산자 :** 계산한 결과를 하나의 변수에 저장하기 위한 연산자

```jsx
// 대입 연산자: =
let a = 3;
let b = 9;
let c;
c = a + b;
```

- **복합 대입 연산자 :** 산술 연산자로 피연산자를 계산해 결과값을 한번에 대입시켜주는 연산자

```jsx
let n = 10;
let a, b, c, d, e;
a = b = c = d = e = 30;

//복합 대입 연산자: +=
console.log(a += n);

//복합 대입 연산자: -=
console.log(b -= n);

//복합 대입 연산자: *=
console.log(c *= n);

//복합 대입 연산자: /=
console.log(d /= n);

//복합 대입 연산자: %=
console.log(e %= n);
```

- **증가, 감소 연산자 :** 숫자 1만큼 증가 혹은 감소시킬 때 사용되는 연산자
    - 증가 연산자 : ++(피연산자), (피연산자)++
    - 감소 연산자 : --(피연산자), (피연산자)--

```jsx
let n = 3;
let r1 = n++; //r1 = 3, n = 4

n = 3;
let r2 = ++n; //r2 = 4, n = 4

n = 3;
let r3 = n--; //r3 = 3, n = 2

n = 3;
let r4 = --n; //r4 = 2, n = 2
```

### 13. 비교논리 연산자

- **비교 연산자 :** 좌항과 우항의 피연산자를 비교한 다음 결과값을 논리적 자료형으로 반환하는 연산자
    - 동등 비교 연산자(==) : 단순 값의 같음을 비교
    - 일치 비교 연산자(===) : 자료형까지 같음을 판단

![image](https://user-images.githubusercontent.com/57048162/135140743-51c92ec9-180e-49f3-bd8c-7987358ab19c.png)


```jsx
console.log("Z" > "A"); // output: true
console.log("Hello" < "Hi"); // output: true
console.log("Hello" >= "Helloo"); // output: false
console.log("5" <= 10); // output: true
console.log(true == 1); // output: true
console.log(false != 123); // output: true
console.log(true === 1); // output: false
console.log(false !== 123); // output: tru
```

- **논리 연산자 :** 좌항과 우항의 피연산자 간 논리 값을 연산하여 참 또는 거짓을 결과로 얻는 연산자
    - &&(AND), ||(OR), !(NOT)

![image](https://user-images.githubusercontent.com/57048162/135140929-fd7d96c5-7aaf-4da8-ad22-fdc58da39604.png)

```jsx
onsole.log(true || false); // output: true
console.log(Boolean(0 || false)); // output: false
console.log(Boolean(123 || false)); // output: true
console.log(Boolean(123 && 0)); // output: false
console.log(Boolean(false && true)); // output: false
console.log(Boolean(true && 3)); // output: true
console.log(Boolean(0 && false)); // output: false
console.log(!false); // output: true
console.log(!123); // output: false
```

### 14. SCOPE

- **Scope :** 변수 혹은 상수에 접근할 수 있는 범위
    - Global Scope : 전역에 선언되어 어디에서도 접근 가능
    - Local Scope : 특정 지역에 선언되어, 해당 지역 내에서만 접근 가능

```jsx
let x - 1; // global scope
console.log(x); // 1
{
	let x = 2; // local scope
	let y = 3; // local scope
	console.log(x); // 2
	{
		let y = 4;
		console.log(y); // 4
	}
}

console.log(x); // 1
console.log(y); // error

```
