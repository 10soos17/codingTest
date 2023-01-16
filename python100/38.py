#!/usr/local/bin/python3
#1위부터 3위까지의 학생에게 상으로 사탕을 준다.점수를 공백으로 구분하여 입력받는#다. 1위~ 3위 학생은 여러명가능, 중복되는 학생까지 포함하여 사탕을 사기로 한다
# sorted , range(len(l)-1, 0, -1), data_sorted[-3]
"""
def one(n):
    count=0
    a=1
    n.sort(reverse=True)
    for i in n:
        if count==3 and i!=n[a]:
            print(a-1)
            break
        if i!=n[a]:
            count+=1
        a+=1
#scores=list(map(int,input("scores?").split(",")))

scores=[97,86,75,66,55,97,85,97,97,95]
one(scores)
----------
data = list(map(int,input().split(" ")))
order=sorted(data,reverse=True)
num=3
a=0
while a!=3:
    if order[a] == order[a+1]:
        num+=1
        a+=1
        continue
    a+=1
print(num)
------------
"""
user_input = input()

l = list(user_input.strip().split())
l = [int (i) for i in l]

count = 3
#3개는 무조건 구매, 배열 정렬 후 1~3위 중 중복되는 숫자까지 포함

data_sorted = sorted(list(l))

print(data_sorted)
for i in range(len(l)-1, 0, -1):
    if data_sorted[-3] == l[i]:
        count += 1
print(count)
