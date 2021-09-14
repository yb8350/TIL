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

- **`grid-template-rows` :** 몇개의 행을 갖게 되는지 지정
    - 단위를 갖는 값을 지정(ex. px, em, fr(비율을 설정하는 단위) 등)
    - repeat( ) : 첫번째 인수에는 반복할 횟수, 두 번째 인수에는 반복할 값을 작성
- **`grid-template-columns` :** 몇 개의 열을 갖게 되는지 지정

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

