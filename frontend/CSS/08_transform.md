## transform

### 1. transform (변형) 개요

- **`transform` :** 요소의 형태를 다양한 방법으로 변형할 수 있는 속성

    📎 원래 자리를 유지하면서 변형된다.

    📎 html에서의 좌표 체계는 오른쪽으로, 아래쪽으로 갈 수록 +가 된다.

    - none (기본값)
    - 함수를 이용해 값을 지정, 함수를 여러 개 기입할 경우 오른쪽에서 왼쪽으로 하나씩 적용된다.

### 2. 크기 - scale

- **`transform`**
    - scale() : 요소의 크기를 조절

        📎 width, height가 적용된 상태에서 한 번 더 조정하는 역할, 즉 기존 공간을 유지하는 상태에서 보여지는 게 달라지는 것이다.

        📎 0~1 사이의 실수 입력

        📎 한 개만 입력하면 전체를, 두 개를 입력하면 각각 x축과 y축을 변형 가능

    - scaleX() : x축의 크기를 조절
    - scaleY() : y축의 크기를 조절

```css
.box{
	width: 400px;
	transfrom:scale(0.5);
}
```

### 3. 회전 - rotate

- **`transform`**
    - rotate() : 요소를 회전

        📎 하나의 각도 값만 입력(ex. 45deg ⇒ 45도, 1turn ⇒ 한 바퀴)

        📎 양수일 때는 시계방향, 음수는 반시계방향으로 회전

```css
.box {
	width: 300px;
	transform: rotate(180deg);
}
```

### 4. 이동 - translate

- **`transform`**
    - translate() : 요소를 이동

        📎 하나만 사용하면 x축으로만 이동, 2개 입력하면 x축, y축 순서로 이동

        📎 음수, % 사용 가능

    - translateX() : x축으로 요소를 이동
    - translateY() : y축으로 요소를 이동

```css
.box {
	transform: translate(100px);
}
```

### 5. 기울이기 - skew

- **`transform`**
    - skew() : 요소를 기울인다. (회전과 다르게 찌그러지는 느낌)

        📎 하나만 쓰면 x축으로 기울임, 2개 쓰면 x축, y축 순서로 기울임

    - skewX() : x축으로 요소를 기울인다.
    - skewY() : y축으로 요소를 기울인다.

```css
.box {
	transform: skew(20deg);
}
```

### 6. 기준점 - transform-origin

- **`transform-origin` :** 요소의 기준점을 변경

    📎 

    - center : 50%, 정중앙을 기준으로 설정 (기본값)
    - left : 0%
    - right : 100%
    - top : 0%
    - bottom : 100%

```css
.box1 {
	transform-origin: top left;
}

.box2 {
	transform-origin: 50px 100px; /*x축으로 50px, y축으로 100px 이동한 위치를 기준점으로*/
}
```
