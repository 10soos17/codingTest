#!/usr/local/bin/python3
#소수이면 YES로, 소수가 아니면 NO로 출력

def check_prime(n):
    i = 2
    while i < n:
        if n % i == 0:
            break #소수아님(두 수가 같지 않는 한)
        i = i + 1
    if i == n: #단,소수(두 수가 동일할 경우)
        print("YES")
    else: #소수 아님 (두 수가 같지 않다면)
        print("NO")
check_prime(int(input()))

"""
입력받은 수와 제수가 같아질때까지 나누기(제수범위는 2부터)
나머지가 0일 경우 break
break->while 빠져나온 후, 
입력받은 수와 제수가 같을 경우에 소수
그외엔 소수 아님
while 문(제수가 입력수보다 작을 때까지//제수는 2부터 1씩 증가) :
입력받은 수를 제수로 나누기->나머지 == 0이면 break
if(제수==입력수) -> 소수
else(그외) -> 소수아님-i
"""
