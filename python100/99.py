#!/usr/local/bin/python3
"""
토끼들이 징검다리를 건너려고 합니다. 하지만 돌이 부실해서 몇번 건너지 못할것 같습니다.
대기중인 토끼들의 통과 여부를 배열에 담아 출력해주세요
1. 각 돌들이 얼마나 버틸수 있는지 배열로 주어집니다.
2. 각 토끼가 착지할때 마다 돌의 내구도는 1씩 줄어듭니다.
    ex) [1,2,1,4] 각 돌마다 1마리 2마리 1마리 4마리의 착지를 버틸 수 있습니다.
3. 토끼들은 점프력이 각자 다릅니다. 
    ex)[2,1] 첫번째 토끼는 2칸씩 두번째 토끼는 1칸씩 점프합니다.
4. 각 토끼들은 순서로 다리를 건넙니다.
입력
돌의내구도 = [1, 2, 1, 4, 5, 2]
토끼의점프력 = [2, 1, 3, 1]
출력
['pass', 'pass', 'fail', 'fail']
------------------------------
def rabbitJump(stone,jump):
    result=[]
    a=-1
    for i in jump:
        while len(stone)-1 >= a+i:
            if stone[a+i] >= i:
                stone[a+i]-=1
                a=a+i
            else:
                result.append("fail")
                break
        if len(stone)-1 <= a+i:
           result.append("pass")
        a=-1
    
    print(result)

stone=list(map(int,input("strength").split(',')))
jump=list(map(int,input("jump").split(',')))
#stone=[1, 2, 1, 4, 5, 2]
#jump=[2, 1, 3, 1]
rabbitJump(stone,jump)
--------
"""
def jumping(stone,jump):
    res=[]
    for i in jump:
        for j in range(i-1,len(stone),i):
            if stone[j] == 0:
                res.append('fail')
                break
            elif j == len(stone)-1:
                res.append('pass')
            stone[j]-=1
    return res


stone = [1, 2, 1, 4, 5, 2]
jump = [2, 1, 3, 1]
print(jumping(stone,jump))
