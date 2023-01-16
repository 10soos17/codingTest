#!/usr/local/bin/python3
#다음 빈 칸을 채워 퀵 정렬을 완성해주세요.
def quickSort(inList):
    lenIn = len(inList)
    if lenIn <= 1:
        return inList
    point = inList.pop(lenIn//2)
    groupOne = []
    groupTwo = []
    
    for i in range(lenIn-1):
        if inList[i] <= point:
            groupOne.append(inList[i])
        else:
            groupTwo.append(inList[i])
    return quickSort(groupOne) + [point] + quickSort(groupTwo)

inList = [180, 145, 165, 45, 170, 175, 173, 171]
#inList = input().split(' ')
inList = [int (i) for i in inList]
#내용을 채워주세요.

print(quickSort(inList))
