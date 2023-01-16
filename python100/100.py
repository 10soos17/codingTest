#!/usr/local/bin/python3
"""
N x M으로 이루어진 아래와 같은 공간에 퍼즐이 쌓여져 있습니다.
퍼즐을 맞추기 위해서는 반드시 맨 오른쪽 줄로 이동시켜 줘야 합니다.
만약 종류가 같은 퍼즐이 연속될 시에 점수가 추가되며 그 퍼즐은 사라집니다.
점수는 다음과 같습니다.
- 파란색 공 : 1점
- 빨간색 공 : 2점
- 노란색 공 : 3점
- 초록색 공 : 4점
- 주황색 공 : 5점
점수는 공의 개수만큼 추가됩니다. 예를 들어 빨간색 공이 2개 연속되어 없어졌을 경우 2*2 = 4점입니다.
게임 플레이어는 게임이 시작되면 어떤 퍼즐을 이동할 것인지 모두 작성합니다. 만약 비어있는 곳을 선택하게 된다면 점수가 1점 감소하며 그대로 진행합니다.
위 규칙에 맞는 점수를 리턴하는 함수를 작성하세요.
예를 들어 입력이 
퍼즐 판 : [[0, 0, 0, 0], [0, 1, 0, 3], [2, 5, 0, 1], [2, 4, 4, 1], [5, 1, 1, 1]]
조작 : [1, 1, 1, 1, 3, 3, 3] 
일 경우,총 점수는 2점으로 2를 출력해야 합니다.
def solution(plate, moves):
    stack=[0]
    point = 0
    while moves:
        m = moves.pop(0)
        for i in range(len(plate)):
            if plate[i][m-1]!=0:
                if stack[len(stack)-1] == plate[i][m-1]:
                    point+= plate[i][m-1]*2
                    plate[i][m-1] = 0
                    stack.pop()
                else:
                    stack.append(plate[i][m-1])
                plate[i][m-1] = 0
                break
            else:
                if  i==len(plate)-1 and plate[i][m-1]==0:
                    point-=1

    return point
base=[[0, 0, 0, 0], [0, 1, 0, 3], [2, 5, 0, 1], [2, 4, 4, 1], [5, 1, 1, 1]]
move=[1, 1, 1, 1, 3, 3, 3]
solution(base,move)
---------------------------
import random

def puzzle(base,move):
    a=0
    score=0
    scoreCount=0
    scoreBase=['']*len(move)
    for i in move:
        while base[a][i-1] == 0 and a != len(base)-1:
            a+=1
        if base[a][i-1] == 0 and a ==len(base)-1:
            scoreBase[scoreCount]= base[a][i-1]
            score-=1
            
        scoreBase[scoreCount]= base[a][i-1]
        if scoreCount!=0 and scoreBase[scoreCount] == scoreBase[scoreCount-1]:
            score+=(base[a][i-1]*2)
            scoreBase.pop(scoreCount)
            scoreBase.pop(scoreCount-1)
            scoreCount-=2
        scoreCount+=1
        base[a][i-1] = 0
        a=0
    print(score)
    
row=int(input("row?"))
col=int(input("column?"))
move=list(map(int,input("move?").split(',')))
a=0
b=0
base = [['']*col for i in range(row)]
for i in range(row):
    for j in range(col):
        base[a][b]=random.randint(0,5)
        b+=1
    a+=1
    b=0  
#base=[[0, 0, 0, 0], [0, 1, 0, 3], [2, 5, 0, 1], [2, 4, 4, 1], [5, 1, 1, 1]]
#move=[1, 1, 1, 1, 3, 3, 3]
puzzle(base,move)
-------
"""
def puzzle(mat,move):
    queue=[]
    q=-1
    score=0
    for i in range(len(move)):
        for j in range(len(mat)):
            if len(mat)-1 == j and mat[j][move[i]-1] == 0:
                score-=1
            elif mat[j][move[i]-1] !=0:
                queue.append(mat[j][move[i]-1])
                mat[j][move[i]-1]=0
                q+=1
                if len(queue) != 1 and queue[q-1] == queue[q]:
                    score+=(queue[q]*2)
                    queue.pop(-1)
                    queue.pop(-1)
                    q-=2
                break
    return score
    
mat=[[0, 0, 0, 0], 
[0, 1, 0, 3], 
[2, 5, 0, 1], 
[2, 4, 4, 1], 
[5, 1, 1, 1]]
move=[1, 1, 1, 1, 3, 3, 3]
puzzle(mat,move)
