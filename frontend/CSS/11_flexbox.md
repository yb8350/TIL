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
