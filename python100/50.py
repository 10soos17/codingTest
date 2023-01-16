#!/usr/bin/env python3
#아래 코드의 빈 칸을 채워 버블 정렬을 완성해 봅시다.
def bubble(data):
    n=len(data)
    for i in range(n):
        for j in range(n-i-1):
            if data[j] > data[j+1]:
                data[j],data[j+1] = data[j+1],data[j]
    
    for i in range(n):
        print(data[i],end='')
    
data=list(map(int,input().split()))
print(bubble(data))
