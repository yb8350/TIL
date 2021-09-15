## **grid**

### 1. Grid 개요

- Grid : 웹페이지를 위한 2차원 레이아웃 시스템, columns와 rows로 구성
- gutters : 각 행과 열 사이의 공백

### 2. Container - display

- **`display`**

    📎 flex에서 배운 것처럼 inline-grid 형태로 inside와 outside로 구분 가능

    - grid : grid로 지정

```css
.container {
	display: grid;
}
```

### 3. Container - grid-template-rows, grid-template-columns

- **`grid-template-rows` :** 몇개의 행을 갖게 되는지 명시적으로 지정

    📎 내부에 요소가 있든 없든 공간을 분리해놓는다. 분리된 공간 이상의 요소를 추가하면 기본적으로 가진 요소의 크기만큼 공간을 차지한다.

    - 단위를 갖는 값을 지정(ex. px, em, fr(비율을 설정하는 단위) 등)
    - repeat( ) : 첫번째 인수에는 반복할 횟수, 두 번째 인수에는 반복할 값을 작성
- **`grid-template-columns` :** 몇 개의 열을 갖게 되는지 명시적으로 지정

    📎 내부에 요소가 있든 없든 공간을 분리해놓는다. 분리된 공간 이상의 요소를 추가하면 기본적으로 가진 요소의 크기만큼 공간을 차지한다.

    - 단위를 갖는 값을 지정(ex. px, em, fr(비율을 설정하는 단위) 등)
    - repeat( ) : 첫번째 인수에는 반복할 횟수, 두 번째 인수에는 반복할 값을 작성

```css
.container1 {
	grid-template-columns: 80px 80px 80px;
	grid-template-rows: 100px 100px;
}
```

![image](https://user-images.githubusercontent.com/57048162/133280047-94a5946f-ed2e-46dd-8838-7922309863da.png)

```css
.container2 {
	grid-template-columns: 2fr 1fr;
	grid-template-rows: repeat(4, 1fr);
}
```

### 4. Container - grid-template-areas

- **`grid-template-areas` :** 2차원의 구역을 나눠서 영역을 나눌 수 있게하는 속성
    - 행렬을 입력

```css
.container {
	grid-template-columns: repeat(5, 1fr);
	grid-template-rows: repeat(3, 1fr);
	grid-template-areas: 
		"a a a a ."
		"b b b . c"
		"d d d d d";

}
.a {gird-area: a;}
.b {gird-area: b;}
.c {gird-area: c;}
.d {gird-area: d;}
```

### 5. Container - row-gap, column-gap, gap

- **`row-gap` :** 행 사이의 gutters를 결정하는 속성
    - 단위 값을 입력
- **`column-gap` :** 열 사이의 gutters를 결정하는 속성
    - 단위 값을 입력
- **`gap` :** guteers의 폭을 결정하는 속성

    📎 row → column 순으로 입력

```css
.container {
	gap: 20px 50px;
}
```

### 6. Container - grid-auto-rows, grid-auto-columns

- **`grid-auto-rows` :** 추가되는 행의 크기를 암시적으로 지정

    📎 `grid-template-rows` 에서 지정한 값을 넘어선 요소들의 크기를 결정한다. 

- **`grid-auto-columns` :** 추가되는 열의 크기를 암시적으로 지정

    📎 `grid-template-columns` 에서 지정한 값을 넘어선 요소들의 크기를 결정한다. 

```css
.container {
	grid-auto-rows: 100px;
	grid-auto-columns: 50px;
}
```

### 7. Container - grid-auto-flow

- **`grid-auto-flow` :** item이 어떻게 흘러갈지 결정
    - row : 가로 방향으로 item을 배치 (기본값)
    - column : 세로 방향으로 item을 배치
    - dense : 다른 요소가 여러 공간을 차지하는 경우 중간에 비게 되는 공간을 메꿔줌

        📎 단독으로 사용하면 row 상태에서 적용된다.

        📎 dense를 사용하지 않았을 경우

        ![image](https://user-images.githubusercontent.com/57048162/133287110-31629dd5-192a-40ec-bb57-8a0a4454ee15.png)

        📎 dense를 사용한 경우

        ![image](https://user-images.githubusercontent.com/57048162/133287130-e2a09cab-6d32-4385-a917-3d1d9c9d21cb.png)

```css
.container {
	grid-auto-flow: row dense;
}
```

### 8. Container - grid (shorthand)

- **`grid` :** grid와 관련된 속성을 한 번에 설정

    📎 외재적인 속성(`grid-template-rows` , `grid-template-columns` , `grid-template-areas` ), 내재적인 속성( `grid-auto-rows` , `grid-auto-columns` , `grid-auto-flow` ) 값을 설정 가능

    - / 로 구분한다. 앞쪽은 rows, 뒤쪽은 column값을 입력한다.
    - 내재적으로 설정하기 위해서는 해당하는 값 앞에 auto-flow를 붙인다.

```css
.container {
	grid: auto-flow dense / 40px 40px 1fr;
}
```

### 9. Container - justify-content, align-content

- **`justify-content` :** 주 축을 기준으로 정렬 방법을 지정

    📎 container에 요소를 배치하고 남는 공간이 있어야 한다.

    - start : 주 축의 시작 점에 배치 (기본값)
    - end : 주 축의 끝 점에 배치
    - center : 주 축의 중심에 배치
    - space-around : 주 축을 기준으로 요소의 앞뒤에 일정한 여백을 제공
    - space-between : 주 축을 기준으로 요소 사이의 공간이 일정하도록 배치
- **`align-content` :** 교차 축을 기준으로 정렬 방법을 지정
    - start : 교차 축의 시작 점에 배치 (기본값)
    - end : 교차 축의 끝 점에 배치
    - center : 교차 축의 중심에 배치
    - space-around : 교차 축을 기준으로 요소의 앞뒤에 일정한 여백을 제공
    - space-between : 교차 축을 기준으로 요소 사이의 공간이 일정하도록 배치

```css
.container {
	justify-content: center;
	align-content: center;
}
```

### 10. Container - justify-items, align-items

- **`justify-items` :** grid 하나의 칸 안에서 요소를 주 축 기준으로 어떻게 정렬할지 지정
    - stretch : grid 하나의 칸을 주 축 기준으로 가득 채움 (기본값)
    - start : 주 축의 시작점에 배치
    - end : 주 축의 끝점에 배치
    - center : 주 축의 중심에 배치
- **`align-items` :** grid 하나의 칸 안에서 요소를 교차 축 기준으로 어떻게 정렬할지 지정
    - stretch : grid 하나의 칸을 교차 축 기준으로 가득 채움 (기본값)
    - start : 교차 축의 시작점에 배치
    - end : 교차 축의 끝점에 배치
    - center : 교차 축의 중심에 배치

```css
.container {
	justify-items: start;
	align-items: end;
}
```

### 11. Item - grid-row, grid-column

- **`grid-row` :** 행을 기준으로 item요소의 시작점과 끝점을 설정 가능한 속성

    📎 `grid-row-start`와 `grid-row-end` 속성을 합쳐놓은 속성이다.

    📎 1부터 시작하는 선을 기준으로 칸을 계산한다. (ex. start가 1, end가 3이면 2칸을 차지)

    ![image](https://user-images.githubusercontent.com/57048162/133491576-df99ad1e-0457-4204-a3b4-23db5d3ff2a2.png)

    📎 음수는 명시적으로 지정하는 `grid-template-*` 를 썼을 때만 사용 가능하다.

    - start / end 형태로 작성(ex. 1 / 3)
    - end 위치에서 span을 붙이고 숫자를 입력하면 몇 칸을 차지하고 싶은 건지로 인식(ex. span 2라고 입력하면 시작점에서부터 2칸을 차지)
- **`grid-column` :** 열을 기준으로 item요소의 시작점과 끝점을 설정 가능한 속성

```css
.item {
	grid-row: 4 / span 2;
	grid-column: 2 / -1;
}
```

### 12. Item - grid-area

- **`grid-area` :** item을 지정하는 이름을 붙이는 속성, 요소의 시작 위치와 끝 위치를 지정할 수 있는 shorthand 속성으로 사용되기도 한다.
    - `grid-row-start` , `grid-column-start` , `grid-row-end` , `grid-column-end` 값을 순서대로 설정 가능
    - 문자열을 작성하면 요소를 지정하는 이름으로 사용

```css
.item1 {
	grid-area: a;
}
.item2 {
	grid-area: 4 / 2 / span 2 / -1;
}
```

### 13. Item - order

- **`order` :** grid에서 사용하면 flex와 비슷하게 순서를 지정하는 용도로 쓸 수 있다.
    - 0 (기본값)
    - 정수를 입력

```css
.item:nth-child(5) {
	order: -1; /*5번 요소가 정렬 순서의 가장 첫번째로 이동*/
}
```

### 14. Item - z-index

- **`z-index` :** 쌓임의 순서를 지정

    📎 grid-row와 grid-column을 이용하면 grid 안의 요소가 겹칠 수 있다. 이럴 때 쌓임 순서를 지정하는 용도로 사용한다.

```css
.item {
	z-index: -1;
}
```

### 15. Grid 단위 - fr, min-content, max-content

- fr : 비율을 지정
- min-content : 가장 긴 단어를 기준으로 최소한으로 줄여준다.
- max-content : 문장 전체를 한 줄에 넣을 수 있도록 최대한으로 늘려준다.

```css
.container {
	grid-template-rows: 100px 1fr 1fr; /*fr은 고정 사이즈와 혼용이 가능*/
	grid-template-columns: max-content 1fr;
}
```

### 16. Grid 단위 - auto-fill, auto-fit

- repeat ()
    - auto-fill : container의 크기가 늘어남에 따라 요소를 자동적으로 채워준다.
    - auto-fit : 기본적으로는 auto-fill과 똑같이 동작하나, 빈 공간이 생겼을 때 item를 늘려 메꿔준다.
- minmax( ) : 가장 작을 때와 가장 클 때를 지정한다.

```css
.container {
	grid-template-columns: repeat(auto-fill, minmax(100px, 1fr); /*컨테이너의 너비에 1px도 빈 공간이 생기지 않게 유지*/
}
```

