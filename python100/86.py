#!/usr/local/bin/python3
"""
쉔은 회전초밥집에 갔습니다.
초밥집에 간 쉔은 각 초밥에 점수를 매기고 낮은 점수의 순서로 초밥을 먹으려 합니다.
이때 n위치에 놓여진 초밥을 쉔은 접시가 몇 번 지나가고 나서 먹을지 출력하세요.
1. 초밥은 놓여진 위치에서 옮겨지지 않습니다.
2. 지나간 초밥은 나머지 초밥이 지나간 후에 다시 돌아옵니다.
3. 초밥은 1개 이상 존재합니다.
예:A, B, C, D, E 초밥이 있고 각 점수가 1, 1, 3, 2, 5 일 때 3번째(C초밥)을 먹게 되는 순서는
1인 초밥 A와 B를 먹고 다음 2인 D 초밥을 먹어야 됩니다.
A B C D E 의 순서로 접시가 도착하지만 C가 도착했을때 먹지 못하는 상황이 옵니다.
2점을 주었던 D를 먼저 먹어야 C를 먹을 수 있습니다. 
즉, A B C D E C , 접시가 5번 지나가고 먹게 된다
입력
point = [5,2,3,1,2,5]
dish = 1
출력
10
nums = list(map(int,input("numbers?").split(',')))
num = int(input("which one?"))
value = nums[num-1]
valNum=nums.index(value)
mini=min(nums)
i = 0
count = 0

while mini != value :

    if nums[i] != mini:
        i+=1
        count+=1
    if nums[i] == mini:
        nums.pop(i)
        count+=1
    if nums[i] == mini and i+1 == len(nums):
        nums.pop(i)
        i=0
        count+=1
    if nums[i] != mini and i+1 == len(nums):
        i=0
        count+=1
    mini=min(nums)
    valNum=nums.index(value)
    if i == valNum and mini == value and i == valNum:
        break
    if i == valNum and mini == value and i != valNum:
        i+=1
    if i == valNum and mini == value and i != valNum and i+1 == len(nums):
        i=0
        count+=1
print(count)
-------------
"""
def dish(data,num):
    count=0
    inNum=0
    inVal=data[num-1]
    new=sorted(data)
    minVal=new.pop(0)
    while inVal in data:
        if inNum>len(data)-1:
            inNum=0
        if data[inNum] < inVal and data[inNum] == minVal:
            data.pop(inNum)
            count+=1
            minVal=new.pop(0)
            continue
        elif data[inNum] == inVal and data[inNum] == minVal:
            count+=1
            return count
            
        inNum+=1
        count+=1
#data=list(map(int,input()))
#num=int(input())
data = [5,2,3,1,2,5]
num = 1

print(dish(data,num))

