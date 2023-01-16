#!/usr/local/bin/python3
"""
병합정렬(merge sort)은 대표적인 정렬 알고리즘 중 하나로 다음과 같이 동작합니다.
> 1. 리스트의 길이가 0 또는 1이면 이미 정렬된 것으로 본다. 그렇지 않은 경우에는
2. 정렬되지 않은 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
3. 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
4. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.
def mergeSort(x):
    if len(x) > 1:
        mid = len(x)//2
        lx, rx = x[:mid], x[mid:]
        mergeSort(lx)
        mergeSort(rx)

        li, ri, i = 0, 0, 0
        while li < len(lx) and ri < len(rx):
            if lx[li] < rx[ri]:
                x[i] = lx[li]
                li += 1
            else:
                x[i] = rx[ri]
                ri += 1
            i += 1
        x[i:] = lx[li:] if li != len(lx) else rx[ri:]
mergeSort([180, 145, 165, 45, 170, 175, 173, 171])

"""
def merge(data):
    n = len(data)
    if n <= 1:
        return data
    middle = n//2
    one = merge(data[:middle])
    two = merge(data[middle:])
    last = []
    while one and two:
        if one[0] < two[0]:
            last.append(one.pop(0))
        else:
            last.append(two.pop(0))
    
    while one:
        last.append(one.pop(0))
    while two:
        last.append(two.pop(0))

data = list(map(int,input().split(",")))
#data = [180, 145, 165, 45, 170, 175, 173, 171]

print(merge(data))
