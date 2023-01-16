#!/usr/local/bin/python3
"""
영하네 반은 국어, 수학, 영어 시험을 보았습니다. 영하는 친구들의 평균 점수를 구해주기로 했습니다.

공백으로 구분하여 세 과목의 점수가 주어지면
전체 평균 점수를 구하는 프로그램을 작성하세요. 단, 소숫점 자리는 모두 버립니다."""
"""
first=int(input("국어?"))
second=int(input("수학?"))
third=int(input("영어?"))

aver=int((first+second+third)//3)
print(aver)
-----------
scores = list(input("height?").split(" "))
sum=0
for i in scores:
    sum+=int(i)
average=sum//3
print(average)
--------------------------------
map함수 https://blog.naver.com/bosongmoon/221605182533
"""

data = list(map(int, input().split()))

print(int(sum(data)//3))
