#!/usr/local/bin/python3
#숫자가 공백으로 구분되어 주어지면 연속수인지 아닌지 "YES"와 "NO"로 판별
"""
def number(data):
    n=len(data)
    for i in range(n-1):
        for j in range(i+1,n):
            if data[i] >= data[j]:
                return False
    return True
                
data=list(map(int,input().split()))
print(number(data))
"""
def stamp(num):
    for i in range(len(num)-1):
       if num[i]+1 != num[i+1]:
            return 'NO'
    return 'YES'
    
num = list(map(int, input("numbers?").split(' ')))
print(stamp(num))
