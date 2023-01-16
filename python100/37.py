#!/usr/local/bin/python3
# 입력 : 원영 원영 은비 은비 은비 은비 채연 채연
# 출력 : "은비가 총 4표로 반장이 되었습니다."와 같습니다.
#count 함수는 문자열에서 해당 문자의 개수를 셉니다.
"""
data = ["원범", "원범", "혜원", "혜원", "혜원", "혜원", "유진", "유진"]

num={}
for i in data:
    num[data.count(i)]=i
    
print(data[max(num)],max(num))
-----
data = ["원범", "원범", "혜원", "혜원", "혜원", "혜원", "유진", "유진"]

count = 0
oldCount=0
for i in data:
    for j in data:
        if i == j:
            count+=1
    if count > oldCount:
        num={}
        num[count]=i
        oldCount=count
        count = 0
    count = 0
print(num)
-----
def one(n):
    num=0
    for i in n:
        if n.count(i)>num:
            num=n.count(i)
            name=i
    print(f"{name}(이)가 총 {num}표로 반장이 되었습니다.")

names=list(map(str,int(input("number?").split(" ")))
#names=['원범', '원범', '혜원', '혜원', '혜원', '혜원', '유진', '유진']
one(names)

"""

data = list(map(str, input().split()))
count = 0
for i in range(len(data)):
	if data.count(data[i-1]) < data.count(data[i]):
		count = i
print("{}(이)가 총 {}표로 반장이 되었습니다.".format(data[count], data.count(data[count])))

