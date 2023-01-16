#!/usr/local/bin/python3
#순서가 없는 10개의 숫자가 공백으로 구분되어 주어진다. 주어진 숫자들 중 최댓값
#sorted 함수
"""
num=list(map(int,input("number?").split(" ")))
num.sort()
print(num.pop())
---------------
"""
data = list(map(int, input().split()))
print(sorted(data)[-1])
