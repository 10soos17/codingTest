#!/usr/local/bin/python3
"""숫자 1723에서 두개의 수를 뽑으면 [17,12,13,72,73,23] 을 만들 수 있습니다.
이 중 가장 큰 수는 73입니다.
위 예시처럼 어떤 수 n개에서 k개의 수를 선택하여 만들 수 있는 수 중에서 가장 큰 수를 찾아 주세요.
"""
num = list(str(input("number?")))
count = int(input("How many numbers?"))

a=0
for i in num:
    num[a]=int(i)
    a+=1

num.sort()
maxi=0

while count != 0:
   maxi+=(num.pop()*(10**(count-1)))
   count-=1
 
print(maxi)
