import sys

input = sys.stdin.readline
str = input().rstrip()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for word in croatia:
  str = str.replace(word, '*')

print(len(str))

# ---리팩토링 전---
# import sys

# input = sys.stdin.readline
# str = input().rstrip()
# res = 0
# croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
# i = 0
# while i < len(str):
#     toggle = False
#     for word in croatia:
#         if str[i:i+len(word)] == word:
#             res+=1
#             i+=len(word)-1
#             toggle = True
#             break
#     if not(toggle):
#         res+=1
#     i+=1

# print(res)
