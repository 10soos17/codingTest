#!/usr/local/bin/python3
"""
한 반에 5명인 학생, 총 3개의 반 점수가 '국어, 영어, 수학, 사회, 과학' 순서로 있는 다중 리스트를 랜덤한 값으로 만들어주시고 아래 값을 모두 출력
1. 반 점수 모두가 담긴 전교 점수 다중 리스트를 만들어주세요.
2. 반 평균을 구하세요.
3. 반 1등 점수를 구하세요.
4. 전교 평균을 구하세요.
다시풀기!
"""
import random as r

total_score = []
class_score = []
student_score = []

for i in range(3):
    class_score = []
    for i in range(5):
        student_score = []
        for i in range(5):
            student_score.append(r.randint(40, 100))
        class_score.append(student_score)
    total_score.append(class_score)
    
total_average = 0
c_average = []
s_average = 0
#print(sum(total_score)) #Error

for c in total_score:
    for s in c:
        s_average += sum(s)/5
    c_average.append(s_average // 5)
    s_average = 0

print(c_average)
print(sum(c_average)//len(c_average))
