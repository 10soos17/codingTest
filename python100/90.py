#!/usr/local/bin/python3
"""의약품 성분이 총 8개인 약품들이 있습니다. 예를들어 다음 데이터는 총 8개의 성분을 갖습니다.

판콜비 = 'ABCDEFGH'
넥타이레놀 = 'EFGHIJKL'

특정 약품 A의 성분이 공개되었을 때, 이와 유사한 성분을 가진 데이터들의 출력을 구하는 문제입니다.

입력 : 'ABCDEFGH' 4
데이터 : 'EFGHIJKL', 'EFGHIJKM', 'EFGHIJKZ' 등 1만개의 데이터
출력 : 'EFGHIJKL', 'EFGHIJKM', 'EFGHIJKZ' 등 4개의 요소가 같은 약품 전부(4개 이상이 아니며 같은 요소가 4개인 것을 출력해야 합니다.)

* 해당 문제는 시간 제한이 있습니다.
* 제약 데이터의 성분은 중복이 될 수 없습니다.
(예를 들어 'AAABBBAB'와 같은 데이터는 없습니다.)
"""

import random as r

l = [chr(i) for i in range(65, 91)]
total_medicine = []
medicine = []
final_medicine = []
count=0
a=0

ingreNum=int(input("What is the number of ingredients?"))
compareNum=int(input("How many drugs do you want to compare?"))

for i in range(8):
    medicine.append(r.choice(l))

for i in range(compareNum):
    total_medicine.append(r.sample(l,8))
    
for i in range(compareNum):
    for j in medicine:
        if total_medicine[a].count(j) != 0:
            count+=1
    if count==ingreNum:
        final_medicine.append(total_medicine[a])
    count=0
    a+=1
    
print(final_medicine)
