#!/usr/local/bin/python3
#공백으로 구분하여 두 숫.첫번째 숫자로 두번째 숫자를 나누었을 때 그 몫과 나머지

n = list(map(int, input().split()))

a = n[0] // n[1]
b = n[0] % n[1]

print(a, b)
