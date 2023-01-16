#!/usr/local/bin/python3
#1부터 100까지의(100을 포함) 모든 숫자를 일렬로 놓고 모든 자릿수의 총합
"""
numList=""
sum=0
for i in range(1,101):
    numList+=str(i)

for i in numList:
    sum+=int(i)
    
print(sum)
----------
"""
nList=[]
a = 0

for i in range(1,101,1):
   nList.append(str(i))


sList = ''.join(nList)

for i in sList:
   a += int(i)

print("총합은 : ",a) 
