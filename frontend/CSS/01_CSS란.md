## CSS란

### 1. CSS 소개

- CSS(Cascading Style Sheets)

  📎 Cascadeing : 위에서 아래로 흐른다. css 적용 규칙을 명확하기 위한 방법

- css3부터는 모듈(ex. font, table, animation 등) 별로 버전 관리를 진행

### 2. CSS는 어떻게 생겼을까

- CSS는 룰 기반(Rule-based)의 언어이다.
- CSS를 통해 특정 요소, 혹은 특정 요소들의 집합의 스타일 규칙을 정의할 수 있다.
- **주석 :** `/* 내용 */` 의 형식으로 작성

<img src="https://user-images.githubusercontent.com/57048162/132126294-d7dd2c59-e477-4398-a599-fd3f6b2a3121.png" alt="css형태">

> **1. 선택자 (Selector) :** 스타일을 지정할 html 요소를 선택  
> **2. 선언 블록(declation block) :** 중괄호 `{ }` 내부의 여러 선언들을 작성  
> **3. 선언(declations) :** 프로퍼티와 값으로 이루어진 쌍  
> 4. `선택자 { 하나 이상의 선언 }` 의 형태로 이루어진 하나의 Rule(혹은 Rule Set)

### 3. CSS를 적용하는 방법

1. **내부 스타일(embedded)**
   - HTML 문서의 head 태그 내부에 스타일을 작성하는 방식

```html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <style>
      h1 {
        color: red;
      }
    </style>
    <title>css</title>
  </head>
  <body>
    <h1>hello world</h1>
  </body>
</html>
```

2. **인라인 스타일(inline)**
   - 태그 내부에 style 속성을 이용하여 스타일을 적용하는 방식

```html
<body>
  <h1 style="color:red;">hello world</h1>
</body>
```

3. **외부 스타일(external)**
   - `<link>` 태그로 외부 css 문서를 참조하여 스타일을 적용하는 방식

```html
<!DOCTYPE html>
<html lang="ko">
  <head>
    <link rel="stylesheet" href="style/main.css" />
    <title>css</title>
  </head>
  <body>
    <h1>hello world</h1>
  </body>
</html>
```

### 5. 캐스캐이딩 원칙

> 1. 스타일 **우선순위**
> 2. 스타일 **상속**

1. **스타일 우선 순위**

   - 동일한 스타일이라도 선언된 곳에 따라 우선순위가 정해진다.

     📎 브라우저에 의해 정의된 스타일 < 개발자가 선언한 스타일 < 사용자가 구성한 스타일

   - 적용 범위가 적을수록 우선시 된다.

     📎 tag 스타일 < class 스타일 < id 스타일 < 인라인 스타일

   - 소스코드의 순서가 뒤에 있으면 덮어쓴다.

2. **스타일 상속**
   - 부모 요소에 있는 스타일 속성들이 자식 요소로 전달된다.  

     📎 자식 요소에서 재정의 할 경우, 부모의 스타일을 덮어쓴다.

   - 상속이 되지 않는 속성도 있다. (ex. 배경 이미지, 배경 색 등)

### 6. MDN 활용하기

- '원하는 속성 + css mdn' 으로 검색 (ex. text color css mdn)
- Can I use 사이트를 통해 속성을 검색하여 지원 브라우저를 확인
