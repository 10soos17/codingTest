#!/usr/local/bin/python3
#숫자를 입력 받고 천단위로 콤마(,)를 찍어주세요.
"""
format 함수
------
n = int(input())

result = format(n, ',')
print(result)
--------
num=str(input("number?"))

numList=[]
newList=""

for i in num:
    numList.append(i)
numList.reverse()
count=1
plus=len(numList)//3

for i in range(len(numList)+plus):
    newList+=numList.pop(0)
    count+=1
    if count==4:
        numList.insert(0,",")
        count=0
        
for i in newList:
    numList.append(i)
numList.reverse()
for i in numList:
    print(i,end='')
------------------
def comma(num):
    num=str(num)
    n=len(num)
    numList=[]
    newList=[]
    new=""
    newnew=""
    count=0
    
    for i in range(n):
        numList.append(num[i])
    for i in range(n):
        new+=numList.pop()
        count+=1
        if count != n and count%3==0:
            new+=","
    for i in new:
        newList.append(i)
    newList.reverse()
    for i in newList:
        newnew+=i
    return newnew
        
num=input()
print(comma(num))
--------------
"""
num = list(map(int,(input("number?"))))

a = len(num)-3
while a > 0:
    num.insert(a,',')
    a -= 3
       
for i in num:
    print(i,end='')
