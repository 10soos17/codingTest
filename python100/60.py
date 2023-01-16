#!/usr/local/bin/python3
#새학기가 되어 이름을 가나다 순서대로 배정하고 번호
"""
enumerate : 자료형(리스트,튜플,등)을 입력받아, 그 인덱스와 해당값을 리턴

students = sorted(student)

for number, name in enumerate(students):
    print("번호: {}, 이름: {}".format(number+1, name))
---------------------
student = ['강은지','김유정','박현서','최성훈','홍유진','박지호','권윤일','김채리','한지호','김진이','김민호','강채연']
student.sort()
for i in range(len(student)):
    print(f"Number: {i}, Name: {student[i]}")
--------------
"""

student = ['강은지','김유정','박현서','최성훈','홍유진','박지호','권윤일','김채리','한지호','김진이','김민호','강채연']
student = sorted(student)

a=0
for i in student:
   a+=1
   print("번호:{}, 이름:{}".format(a,i))
