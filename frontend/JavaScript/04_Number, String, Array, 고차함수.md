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
