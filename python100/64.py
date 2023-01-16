#!/usr/local/bin/python3
"""
정량 N에 정확히 맞춰야만 움직이는 화물용 엘레베이터가 있습니다.
화물은 7kg, 3kg 두 가지이며 팔이 아픈 은후는 가장 적게 화물을 옮기고 싶습니다.
예를 들어 정량이 24kg이라면 3kg 8개를 옮기는 것 보다는
7kg 3개, 3kg 1개 즉 4개로 더 적게 옮길 수 있습니다.
입력
정량 N이 입력됩니다.
출력
가장 적게 옮길 수 있는 횟수를 출력합니다.
만약 어떻게 해도 정량이 N이 되지 않는다면 -1을 출력합니다.
#64번 이상한 엘리베이터
    N = int(input())
    result = 0
    
    while True:
        if N%7 ==0:
            result += N//7
            print(result)
            break
        N -= 3
        result += 1
        if N < 0:
            print(-1)
            break
-----------------------
weight = int(input("weight?"))
seven=weight//7
three=(weight%7)//3
if weight%7 != 0 and weight%7 != 3 and weight%7 != 6:
    print(-1)
else:
    print(seven+three)
---------------------
"""

n = int(input("kg?"))
count = 0
rem = n%7

if n%7 != 0 and n%3 != 0 :
   print("-1")
while n != 0 :
    if  n%7 != n:
      rem = n%7
      count += n // 7
      n = rem
    elif n%3 != n :       
      rem = n%3
      count += n // 3
      n = rem

print(count)
