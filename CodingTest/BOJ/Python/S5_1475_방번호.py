import sys
import math

input = sys.stdin.readline

num = input().rstrip()
res = [0 for n in range(10)]
for i in range(len(num)):
    res[int(num[i])]+=1

res[6] = math.ceil((res[6] + res[9]) / 2.0)
res[9] = 0
print(max(res))
