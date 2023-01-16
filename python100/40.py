#!/usr/local/bin/python3
#제한 무게를 넘으면 다음 기구. 총 몇 명 탈 수 있는지 알 수 있는 프로그램을 작성
#첫번째 줄에서 제한 무게, 두번째 줄 함께한 친구들의 수 n, 다음친구들의 몸무게
"""
limit=int(input("Weight limit?"))
personnel=int(input("How many-?"))
count=0

for i in range(personnel):
    if weight =< limit:
        weight += int(input("weight?"))
        count = i
    print(count)
"""

limit = int(input("limit?"))
n = int(input("total?"))
m = n
a = 0
while a !=  m:
   kg = int(input("kg?"))
   if kg > limit:
      n -= 1
      a +=1
   else:
      a+=1
print(n)


