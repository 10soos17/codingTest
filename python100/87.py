#!/usr/local/bin/python3
"""먹기 대회.정해진 시간이 끝난 후 음식을 먹은 그릇 개수를 파악한 후 각 선수들의 등수.
1. 같은 이름의 선수는 없습니다. 2. 접시의 수가 같은 경우는 없습니다.
**입력 예1)**
    손오공 야모챠 메지터 비콜로
    70 10 55 40
**출력 예1)**
    {'손오공': 1, '메지터': 2, '비콜로': 3, '야모챠': 4}
name = 'A C B D'.split(' ')
point = list(map(int, '70 10 55 40'.split(' ')))

def hojun(x): #이름과 기능을 바꿔서 적용해보세요.
    return x[1]

def sol(name, point):
    d = {}
    z = [[i, j] for i, j in zip(name, point)]
    z = sorted(z, key=hojun, reverse=True)
    
    for i in range(len(z)):
        d[z[i][0]] = i+1
    return d

print(sol(name, point))

#아래 코드를 실행해보세요.
test = 'AA CCCC BBB D'.split(' ')
sorted(test, key=len)
---------
def foodFighter(one,two):
    foodict={}
    newdict={}
    n=1
    for i in range(len(two)):
        foodict[two[i]]=one[i]
    num=sorted(foodict.keys(),reverse=True)

    for i in num:
        newdict[foodict[i]]=n
        n+=1
    return newdict

#one=list(map(str,input().split()))
#two=list(map(int,input().split()))
one=["홍길동","엄석대","연개소문","김첨지"]
two=[2, 1, 10, 0]
print(foodFighter(one,two))
"""
names = list(map(str,input("Who?").split()))
nums = list(map(int,input("How many?").split()))

match={}
a=0

for i in nums:
    match[i]=names[a]
    a+=1
order=list(match.keys())
order.sort()
order.reverse()
newOrder={}
b=1
for i in order:
    newOrder[b]=match[i]
    b+=1

print(newOrder)

