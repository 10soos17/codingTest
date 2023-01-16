#!/usr/local/bin/python3
#1~9까지의 숫자 중 하나를 입력하면 그 단의 구구단 결과를 한 줄
# 한줄에 프린트하기,입력인수 end 이용해서 끝 문자를 지정
"""
def one(n):
    for i in range(1,10):
        print(n*i," ",end='')

num=int(input("number?"))
one(num)
"""
n = int(input("number?"))

for i in range(1,10,1):
   print(n*i, end=' ')

