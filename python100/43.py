#!/usr/local/bin/python3
#사용자에게 숫자를 입력받고 이를 2진수를 바꾸고 그 값을 출력
"""
append -- 리스트 요소 추가, reverse -- 리스트 인덱스 반대로, join --str만 가능

num = int(input("number?"))
bin=[]
while num >= 1:
    remainder = num%2
    num =num//2
    bin.append(remainder)
    
bin.reverse()
for i in bin:
    print(i,end='')
------------------------------
deci = int(input("number?"))
rem =[]

while deci//2 >= 1:
   rem.append(deci%2)
   deci = deci//2

print(rem[::-1]) 
-----------------------
"""
a = int(input())
b = []

while a:
    print(a)
    b.append(str(a % 2))
    a = int(a / 2)

print(b)
b.reverse()
print(b)
print(''.join(b))
