#!/usr/local/bin/python3
"""
첫 줄에는 학생의 이름이 공백으로 구분되어 입력되고, 두번째 줄에는 그 학생의 수학 점수가 공백으로 구분되어 주어집니다. 두 개를 합쳐 학생의 이름이 key이고 value가 수학 점수인 딕셔너리를 출력
students = list(map(str,input("students?").split(" ")))
scores = list(map(int,input("scores?").split(" ")))

sDict ={}
a=0
for i in students:
    sDict[i]=scores[a]
    a+=1
print(sDict)
----------
"""
keys = input().split()
values = map(int, input().split())

result = dict(zip(keys, values))
print(result)
