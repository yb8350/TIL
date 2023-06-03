#https://programmers.co.kr/learn/courses/30/lessons/67256?language=python3
def solution(numbers, hand):
    pos = {'1': (0, 0), '2': (0, 1), '3': (0, 2),
           '4': (1, 0), '5': (1, 1), '6': (1, 2),
           '7': (2, 0), '8': (2, 1), '9': (2, 2),
           '*': (3, 0), '0': (3, 1), '#': (3, 2)}
    left = [1,4,7]
    right= [3,6,9]
    mid = [2,5,8,0]
    LH = pos['*']
    RH = pos['#']
    answer = ''
    for n in numbers:
        if n in left:
            answer += "L"
            LH = pos[str(n)]
        elif n in right:
            answer += "R"
            RH = pos[str(n)]
        else:
            rightLocal = abs(RH[0] - pos[str(n)][0]) + abs(RH[1] - pos[str(n)][1])
            leftLocal = abs(LH[0] - pos[str(n)][0]) + abs(LH[1] - pos[str(n)][1])

            if rightLocal > leftLocal:
                answer += "L"
                LH = pos[str(n)]
            elif rightLocal < leftLocal:
                answer += "R"
                RH = pos[str(n)]
            else:
                if hand == "right":
                    answer += "R"
                    RH = pos[str(n)]
                else:
                    answer += "L"
                    LH = pos[str(n)]
    return answer
