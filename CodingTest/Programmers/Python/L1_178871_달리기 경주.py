# https://school.programmers.co.kr/learn/courses/30/lessons/178871
def solution(players, callings):
    # 선수 이름을 해시 테이블에 저장
    pos = {}
    for i, name in enumerate(players):
        pos[name] = i

    # 경주가 끝났을 때 선수들의 위치를 저장할 리스트
    result = list(players)

    # 해설진이 부른 선수들을 하나씩 처리
    for name in callings:
        # 이전 위치와 현재 위치
        prev = pos[name]
        curr = prev - 1

        # 현재 위치가 0 미만이면 1등이므로 무시
        if curr < 0:
            continue

        # 선수 위치 변경
        result[prev], result[curr] = result[curr], result[prev]

        # 해시 테이블 갱신
        pos[name] = curr
        pos[result[prev]] = prev

    return result
