#!/usr/local/bin/python3
"""음식이 나오고 한참을 기다렸지만 만나기로 한 친구 2명이 오지 않았어요.
기린은 배가고파 음식을 먹기 시작합니다. 원형테이블에는 N개의 음식들이 있습니다.
한개의 음식을 다 먹으면 그 음식의 시계방향으로 K번째 음식을 먹습니다.
하지만 아직 오지 않은 친구들을 위해 2개의 접시를 남겨야 합니다.
마지막으로 남는 음식은 어떤 접시인가요?

입력은 2개의 정수로 이루어지며 공백으로 구분되어 입력됩니다.
첫번째 숫자가 음식의 개수 N, 두번째 숫자가 K입니다.
첫번째 가져가는 음식이 K이며 나머지는 첫번째 음식으로부터 시계방향으로 가져감.
food = int(input("How many-?"))
jump = int(input("How many-?"))
friend = 2
fList = [""] * (food)
i=0
a=1
for i in range(len(fList)):
    fList[i] = a
    i += 1
    a += 1
if len(fList) > friend:
    i=jump-1
    fList.pop(i)
while len(fList) > friend:
    if i+jump-1 < len(fList):
        i += jump-1
        fList.pop(i)
    else:
        i = i+jump-1-len(fList)
        fList.pop(i)
print(fList)
-----------
"""
#n=6
#k=3
n=int(input("How many seat...?"))
k=int(input("jump...?"))
s=0

table = [i for i in range(1,n+1)]
table.pop(s)
while len(table) > 2:
    s+=k
    if s<=len(table):
        print(table.pop(s-1))
    elif s > len(table):
        s=s-len(table)-1
        print(table.pop(s-1))
print(table)
