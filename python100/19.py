#!/usr/local/bin/python3

#공백으로 구분하여 두 숫자 a와 b가 주어지면, a의 b승을 구하는 프로그램을 작성하세요
#제곱연산자 **
data = list(map(int, input().split()))
data[1]
c=1
while data[1] !=0:
  c = c*data[0]
  data[1] -= 1
print(c)

"""---------
n = list(map(int, input().split()))
    print(n[0] ** n[1])
"""
