import sys
input = sys.stdin.readline()
# input = "3"
num = int(input.rstrip())

for i in range(1,10):
    print(num,"*",i,"=",num * i)
