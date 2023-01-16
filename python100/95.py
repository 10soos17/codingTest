#!/usr/local/bin/python3
"""
빈 종이에 stamp 모양으로 생긴 도장을 90*k 도로 회전하며 찍습니다.
도장은 N*N 크기이며 각 도장이 찍히는 부분은 1이상의 자연수와 도장이 찍히지 않는 0.
도장의 크기 N과,
종이에 찍힌 도장 횟수를 표현한 stmp배열과,
얼만큼 회전할 것인지를 알려주는 회전수 k를 입력받았을 때
각 위치에서 몇 번 도장이 찍혔는지 그 결과값을 출력하세요.
# 기본 입력부분입니다 
# N, stmp, k를 입력받습니다.

N = int(input())
stmp = []
for i in range(N):
    stmp.append(list(map(int,input().split(' '))))
k = int(input())


def solution(stmp,n):
    N = len(stmp)
    # 0으로 만들어진 배열 생성 
    # [[0]*N]*N으로 하면 안됨!!!!
    p = [[0] * N for _ in range(N)]
    
    # 회전시키기 전 최초 1번찍어주기
    p = sum_matrix(p,stmp)
    #회전시키며 도장찍기
    for i in range(n):
        stmp = rotate(stmp)
        p=sum_matrix(p,stmp)
    return p

#배열(도장) 회전시키기
def rotate(stmp):
    N = len(stmp)
    rot = [[0] * N for _ in range(N)]
    
    for i in range(N):
        for j in range(N):
            rot[j][N-1-i] = stmp[i][j]
    return rot

#행렬 더하기 즉 도장이 찍히는 정도를 더한다.
def sum_matrix(p,stmp):
    for i in range(len(p)):
        for j in range(len(p[0])):
            p[i][j] = p[i][j]+stmp[i][j]
    return p

print(solution(stmp,k))
----------------
"""
import random

size = int(input("size"))
rotation = int(input("rotation"))

count = 0
a=0
b=0
ori = [[random.randint(0,9)]*size for i in range(size)]
fir = [[""]*size for i in range(size)]
sec = [[""]*size for i in range(size)]
thi = [[""]*size for i in range(size)]
res = [[""]*size for i in range(size)]

for i in range(size):
    for j in ori[a]:
        fir[a][b] = ori[size-1-b][a]
        sec[a][b] = ori[size-1-a][size-1-b]
        thi[a][b] = ori[b][size-1-b]
        b+=1
    a+=1
    b=0

a=0
b=0

if rotation % 4 == 0:
    for i in range(size):
        for j in ori[a]:
            res[a][b] = ori[a][b] + ori[a][b]
            b+=1
        a+=1
        b=0
if rotation % 4 == 1:
    for i in range(size):
        for j in ori[a]:
            res[a][b] = ori[a][b] + fir[a][b]
            b+=1
        a+=1
        b=0
if rotation % 4 == 2:
    for i in range(size):
        for j in ori[a]:
            res[a][b] = ori[a][b] + sec[a][b]
            b+=1
        a+=1
        b=0
if rotation % 4 == 2:
    for i in range(size):
        for j in ori[a]:
            res[a][b] = ori[a][b] + thi[a][b]
            b+=1
        a+=1
        b=0
a=0
b=0

print(ori,"\n",fir,"\n",sec,"\n",thi,"\n",res,"\n")
for i in range(size):
    for j in res[a]:
        print(res[a][b], end = "")
        b+=1
    print("\n")
    b=0
    a+=1
-------------
"""
def stamp(mat,num):
    new=[[0]*len(mat) for i in range(len(mat))]
    res=[[0]*len(mat) for i in range(len(mat))]
    while num !=0:
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                new[j][len(mat)-i-1]=mat[i][j]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                res[i][j]=mat[i][j]+new[i][j]
                mat[i][j]=new[i][j]
        num-=1
    return res
    
mat=[
[1,1,1,2],
[2,0,0,0],
[1,1,1,1],
[0,0,0,0]
]
num=1
res=stamp(mat,num)
for i in res:
    print(i,sep="\n")
