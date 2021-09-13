## flexbox

### 1. Flexbox 개요

- Flexbox : 요소를 1차원 형태로 정렬할 수 있도록 도와주는 속성

    📎 기존에는 inline-block으로 바꿔주거나 float을 써서 하는 방법이 있지만 둘 다 단점이 많기 때문에 대체 방안이 필요했다. ⇒ 그래서 나온 게 flexbox!

### 2. 용어 - flex container, flex item, main axis, cross axis

- **flex container :** item을 담고 있는 부모 요소
- **flex item :** container에 담아놓은 요소
- **main axis :** 주 축(기본값은 가로 축)
- **cross axis :** 주 축에 수직이 되는 축

### 3. Container - display

- **`display`**

    📎 display의 값은 outside와 inside로 나뉜다. outside는 현재 요소와 외부 요소와의 관계(ex. inline, block등)를, inside는 자식 요소들의 배치(ex.flex, grid 등)를 뜻한다.

    - flex : flexbox로 지정

```css
.container {
	display: inline-flex;
}
```

### 4. Container - flex–direction

- Container에 적용되는 속성인지, item에 적용되는 속성인지 사용 전에 꼭 확인!
- **`flex–direction` :** flex container 내부의 주 축 및 방향을 결정
    - row : 가로의 왼쪽에서 오른쪽으로 주 축을 지정 (기본값)
    - row-reverse : 가로의 오른쪽에서 왼쪽으로 주 축을 지정
    - column : 세로의 위쪽에서 아래쪽으로 주 축을 지정
    - column-reverse : 세로의 아래쪽에서 위쪽으로 주 축을 지정

```css
.container {
	display: flex;
	flex-direction: row-reverse;
}
```

### 5. Container - flex–wrap, flex-flow (shorthand)

- **`flex–wrap` :** flex item을 한 줄에 배치할지 여러 행으로 나누어 표현할지 결정하는 속성
    - nowrap : 강제로 한 줄에 배치 (기본값)
    - wrap : 여러 행에 걸쳐서 배치
    - wrap-reverse : 여러 행에 걸쳐서 배치되지만 시작점과 끝점이 바뀐다.
- **`flex-flow` :** flex–direction과 flex–wrap을 한 줄로 작성하는 속성

```css
.container {
	flex-flow: column wrap;
}
```

### 6. Item - order

- **`order` :** flex container 안에서 현재 요소의 배치 순서를 지정

    📎 눈에 보이는 순서만 변경된다.

    📎 부모 요소에 flex 혹은 grid가 설정되어야 적용된다.

    - 정수를 입력(음수 사용 가능)

```css
.item:nth-child(3) {
	order: -1; /*3번 item이 첫번째로 이동*/
}
```

### 7. Item - flex-grow

- **`flex-grow` :** flex container 요소 내부에서 할당 가능한 공간의 정도를 선언

    📎 item별로 flex-grow 값을 다르게 지정하면 그 비율에 따라 공간을 차지

    - 0 (기본값)

    ![image](https://user-images.githubusercontent.com/57048162/133127748-e8b162af-912a-4b5e-b1ca-9853f8bf9c08.png)

    - 1 : 남은 공간을 꽉 채워서 공간을 차지

    ![image](https://user-images.githubusercontent.com/57048162/133127799-e535a2a9-9ba7-4991-b434-03dbe89bcc8e.png)

    - 0 이상의 숫자 입력 가능

```css
.item:nth-child(2) {
	flex-grow: 2;
}
.item:nth-child(2) {
	flex-grow: 1;
}
```

### 8. Item - flex-shrink

- **`flex-shrink` :** item이 container보다 클 때, 내부에서 축소되는 방법을 지정
    - 1 : item 모두가 똑같은 비율로 줄어든다. (기본값)
    - 0 : item 고유의 크기 유지
    - 0 이상의 숫자 입력

```css
.item:nth-child(1) {
	flex-shrink: 0;
}
.item:nth-child(3) {
	flex-shrink: 2;
}
```

### 9. Item - flex-basis

- **`flex-basis` :** flex item의 초기 크기를 지정

    📎 item에 초기값을 지정하지 않고 flex-grow를 적용하면 늘어난 범위만 똑같고, 내용에 따라 최종 item의 크기는 다르다. 

    ![image](https://user-images.githubusercontent.com/57048162/133134084-b13fb51d-0b8c-41b0-8cec-93a31662e2a8.png)

    - auto (기본값)
    - width값을 입력
    - 0도 설정 가능, 0으로 설정후 grow로 비율 설정을 해주면 정확히 비율 계산이 된다.

```css
.item {
	flex-basis: 100px;
}
```

### 10. Item - flex (shorthand)

- **`flex` :** 하나의 flex item이 자신의 컨테이너가 차지하는 공간에 맞추기 위해 크기를 키우거나 줄이는 방법을 결정하는 속성

    📎 `flex-grow` , `flex-shrink` , `flex-basis` 설정 가능

    📎 다른 속성은 값을 지정하지 않으면 기본값으로 설정되지만 flex에서 한 개 혹은 두 개의 단위없는 숫자 값을 입력하면 `flex-basis`는 0으로 설정된다.

    - 1개의 값 : 숫자면 `flex-grow`, px이나 %를 지정하면 `flex-basis`
    - 2개의 값 : 첫 번째는 무조건 숫자(`flex-grow`), 두 번째는 숫자면 `flex-shrink`, px이나 %를 지정하면 `flex-basis`
    - 3개의 값 : grow → shrink → basis 순서로 값을 입력
    - initial : 0 1 auto와 동일
    - auto : 1 1 auto와 동일
    - none : 0 0 auto와 동일

```css
.item {
	flex: 1 1 50px;
}
```

### 11. Container - justify-content

- **`justify-content` :** 주 축을 기준으로 정렬하는 방법을 지정
    - flex-start : 주 축의 시작 방향에 붙어서 배치
    - flex-end : 주 축의 끝 방향에 붙어서 배치
    - center : 주 축의 가운데에 배치
    - space-between : 주 축의 양 끝에 붙어서 배치, 요소 간의 간격이 일치
    - space-around : 주 축의 방향으로 요소의 앞뒤에 동일한 여백을 추가하여 배치(space-between과 유사해보일 수 있음)

```css
.container {
	justify-content: center;
}
```

### 12. Container - align-items

- **`align-items` :** 교차 축에 대한 정렬 방법을 지정

    📎 flex는 한 줄이라고 이해해야한다. align-items는 교차 축을 기준으로 한 줄이 시작하는 점을 지정하는 것. wrap을 사용했을 경우, 줄마다의 정렬 방법을 지정하게 된다.

    ![image](https://user-images.githubusercontent.com/57048162/133138203-9e911070-38bf-438a-9883-b5bb9fd39103.png)

    - stretch : 교차 축의 시작점부터 끝점까지 전부 차지 (기본값)
    - flex-start : 교차 축의 시작점에 붙어서 배치
    - flex-end : 교차 축의 끝점에 붙어서 배치
    - center : 교차 축의 중심에 배치

```css
.container {
	align-items: center;
}
```

### 13. Container - align-content

- **`align-content` :** 교차 축을 기준으로 여러 줄에 대한 정렬 방법을 지정
    - flex-start : 교차 축의 시작 방향에 붙어서 배치
    - flex-end : 교차 축의 끝 방향에 붙어서 배치
    - center : 교차 축의 가운데에 배치
    - space-between : 교차 축의 양 끝에 붙어서 배치, 요소 간의 간격이 일치
    - space-around : 교차 축의 방향으로 요소의 앞뒤에 동일한 여백을 추가하여 배치(space-between과 유사해보일 수 있음)

```css
.container {
	align-content: space-around;
}
```

### 14. Item - align-self

- **`align-self` :** item 자신만의 정렬 방법을 지정
- stretch : 교차 축의 시작점부터 끝점까지 전부 차지 (기본값)
- flex-start : 교차 축의 시작점에 붙어서 배치
- flex-end : 교차 축의 끝점에 붙어서 배치
- center : 교차 축의 중심에 배치

```css
.item:nth-child(4) {
	align-self: stretch;
}
```

![image](https://user-images.githubusercontent.com/57048162/133138516-770b921e-393e-4117-b614-df42e2cc1430.png)








