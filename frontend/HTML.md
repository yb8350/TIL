## 개요

**1. 소개**

- ❗ HTML과 CSS 없는 웹 개발은 없다!

- ❗ 이 부분을 잘 다져놓지 않으면 언젠간 발목이 잡힐 것.

**2. HTML과 웹 브라우저**

- `.html` 파일을 구동하는 프로그램 ⇒ 웹 브라우저(ex. 크롬, 엣지, 익스프로러, 사파리, ...)

- ⭐ **HTML(Hyper Text Markup Language) :** 하이퍼텍스트를 마크업하는 언어

  📎 하이퍼 텍스트 : 웹 문서를 이루는 요소들

  📎 마크업 언어 : 데이터의 표현 방식을 기술하는 언어(구조를 표현)

**3. HTML, CSS 그리고 JavaScript**

- ⭐ **[구조] HTML :** 웹 문서의 기본적인 골격을 담당

- ⭐ **[표현] CSS :** 각 요소들의 레이아웃, 스타일링을 담당

- ⭐ **[동작] JavaScript :** 동적인 요소(사용자와의 인터렉션)을 담당

**4. 웹 표준과 웹 접근성\_호환성**

- ⭐ **웹 표준 :** 월드 와이드 웹의 측면을 서술하고 정의하는 공식 표준이나 다른 기술 규격을 가리키는 일반적인 용어

  📎 html5는 W3C에서 2014년에 공식 표준화 ⇒ 2019년에 WHATWG(에플, 모질라, 구글, MS)에 의해 HTML Living Standard가 표준화

  📎 웹 표준을 준수하여 작성하면 운영체제, 브라우저마다 의도된 대로 보여지는 페이지 만들기 가능

- ⭐ **웹 접근성 :** 장애를 가진 사람과 장애를 가지지 않은 사람 모두 웹사이트를 이용할 수 있게 하는 방식

  📎 일시적 장애, 상황적 제약 등의 이유로 장애를 갖지 않은 사람에게도 이점을 준다.

  📎 웹 브라우징에 쓰이는 보조과학기술 : 스크린리더, 화면 돋보기, 음성 인식, 키보드 오버레이 등

- ⭐ **웹 호환성(Cross Browsing) :** 웹 브라우저 버전, 종류와 관계 없는 웹사이트 접근

  📎 웹 표준 준수를 통해 브라우저 호환성을 확보

<br>

## 실습환경 세팅

**2. VScode 실습환경 세팅**

- VSCode 설치 : [https://code.visualstudio.com/](https://code.visualstudio.com/)
- Tab키 설정 : `Ctrl` + `,` ⇒ Tab Size ⇒ 4를 2로 변경

**3. 첫 HTML 문서 만들기**

- html:5 를 입력 후 Tab을 누르면 기본 형태 자동으로 완성

**4. VScode 확장프로그램**

- auto rename tag : 열림 태그만 수정해도 닫힘 태그까지 수정해주는 프로그램
- Live Server : 실시간으로 수정 내용이 반영되는 프로그램
- prettier : 코드의 잘못 작성된 서식을 수정해주는 프로그램

  📎 Tab서식 변경 : `Ctrl` + `,` ⇒ prettier tab 검색 ⇒ Tab Width ⇒ 4를 2로 변경

  📎 Save마다 서식 변경 : `Ctrl` + `,` ⇒ format on save 검색 ⇒ Format On Save ⇒ 체크

**5. VScode 단축키**

**에디터 창 제어**
기능|윈도우|맥  
:--:|--|--
현재 창 닫기 | `Ctrl`+`w` | `Cmd`+`w`
닫은 창 다시 열기 | `Ctrl`+`Shift`+`t` | `Cmd`+`Shift`+`t`
사이드바 토글 | `Ctrl`+`b` | `Cmd`+`b`
사이드바 - 탐색기 | `Ctrl`+`Shift`+`e` | `Cmd`+`Shift`+`e`
사이드바 - 전체 검색 | `Ctrl`+`Shift`+`f` | `Cmd`+`Shift`+`f`
에디터 확대 | `Ctrl`+`+(=)` | `Cmd`+`+(=)`
에디터 축소 | `Ctrl`+`-` | `Cmd`+`-`

**소스 코드 편집**  
기능|윈도우|맥
:--:|--|--
들여쓰기|`Tab` 혹은 `Ctrl`+`]`|`Tab` 혹은 `Cmd`+`]`
내어쓰기|`Shift`+`Tab` 혹은 `Ctrl`+`[`|`Shift`+`Tab` 혹은 `Cmd`+`[`
아래에 행 삽입|`Ctrl`+`Enter`|`Cmd`+`Enter`
위에 행 삽입|`Ctrl`+`Shift`+`Enter`|`Cmd`+`Shift`+`Enter`
현재 행 이동|`Alt`+`⬇/⬆`|`Opt`+`⬇/⬆`
현재 행 복사|`Alt`+`Shift`+`⬇/⬆`|`Opt`+`Shift`+`⬇/⬆`
현재 행 삭제|`Ctrl`+`Shift`+`k`|`Cmd`+`Shift`+`k`
주석 토글|`Ctrl`+`/`|`Cmd`+`/`
