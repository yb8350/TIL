## **transition**

### 2. transition–property, transition–duration

- **`transition–property` :** 전환하고 싶은 속성을 지정
    - none : 아무것도 변경하지 않음
    - all : 모든 css를 변경
    - 그 외 다른 속성들을 기입 가능, 여러 개 작성 가능
- **`transition–duration` :** 전환하고 싶은 속성의 전환 시간을 지정
    - 시간을 입력(1s=1000ms)

```css
.box {
	width: 300px;
	background-color: blue;
	color: black
	transition–property: background-color width;
	transition–duration: 0.5s 1s;
}
.box:hover {
	width: 350px;
	background-color: red;
	color: white;
}
```

### 4. transition–delay, transition–timing–function

- **`transition–delay` :** 전환하는 것을 지연시키는 속성
    - 시간을 입력
- **`transition–timing–function` :** 전환되는 중간시간을 어떤 속도로 전환되는 지를 지정
    - ease (기본값)
    - linear : 일정한 속도로 변경

```css
.box {
	width: 300px;
	background-color: blue;
	color: black
	transition–property: background-color width;
	transition–duration: 0.5s 1s;

	transition–delay: 1s;
	transition–timing–function: linear;
}
.box:hover {
	width: 350px;
	background-color: red;
	color: white;
}
```

### 5. transition (shorthand)

- **`transition` :** 요소를 A에서 B로 시간의 흐름을 가지고 전환하는 속성
    - property name | duration | timing function | delay 순으로 입력
    - 시간 속성을 하나만 입력한 경우 duration으로 인식

```css
.box{
	transition: all 3s ease-in-out 1s;
}
```
