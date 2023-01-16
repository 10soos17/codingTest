#!/usr/local/bin/python3
"""
행렬 2개가 주어졌을 때 곱할 수 있는 행렬인지 확인하고 곱할 수 있다면 그 결과를, 곱할 수 없다면 -1을 출력
def sol(one,two):
    three=[[0,0]]*len(one[0])
    a=0
    b=0
    if len(one[0]) != len(two):
        return False
    for i in one:
         for j in one[a]:
             for f in two:
                 three[a][b] += j*(two[b][a])
                 b+=1
             b=0
             a+=1
         print(three)
         a=0    
         
a = ([1, 2],
     [2, 4])
b = ([1, 0],
     [0, 3])
sol(a,b)
----------
"""
def sol(a, b):
    c = []
    if len(a) == len(b[0]):
        for i in range(len(a)):
            c.append([0]*len(b[0]))
        for i in range(len(c)):
            for j in range(len(c[i])):
                for k in range(len(a[i])):
                    c[i][j] += a[i][k] * b[k][j]
        return c
    else:
        return -1

