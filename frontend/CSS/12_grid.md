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


