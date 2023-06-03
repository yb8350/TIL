# https://school.programmers.co.kr/learn/courses/30/lessons/176963

def solution(name, yearning, photo):
    answer = []
    longing = dict(zip(name, yearning))

    for i in range(len(photo)):
        sum = 0
        for human in photo[i]:
            try:
                sum += longing[human]
            except:
                pass
        answer.append(sum)
    return answer